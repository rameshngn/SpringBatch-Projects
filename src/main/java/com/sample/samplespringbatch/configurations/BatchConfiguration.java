package com.sample.samplespringbatch.configurations;

import com.sample.samplespringbatch.dto.OrderDetails;
import com.sample.samplespringbatch.dto.OrderResult;
import com.sample.samplespringbatch.processor.OrderProcessor;
import com.sample.samplespringbatch.reader.OrderReader;
import com.sample.samplespringbatch.writter.OrderWritter;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

  @Autowired
  public JobBuilderFactory jobBuilderFactory;

  @Autowired
  public StepBuilderFactory stepBuilderFactory;

  @Autowired
  OrderReader orderReader;

  @Autowired
  OrderProcessor orderProcessor;

  @Autowired
  OrderWritter orderWritter;

  @Bean
  public Job orderJob(){
    return jobBuilderFactory.get("processOrderJob")
        .incrementer(new RunIdIncrementer())
        .listener(listenJob())
        .flow(orderStep())
        .end()
        .build();
  }

  @Bean
  public Step orderStep(){
    return stepBuilderFactory.get("orderStep")
        .<OrderDetails,List<OrderResult>>chunk(1)
        .reader(orderReader)
        .processor(orderProcessor)
        .writer(orderWritter)
        .build();
  }



  @Bean
  public JobExecutionListener listenJob(){
    return new JobCompletionListener();
  }

}
