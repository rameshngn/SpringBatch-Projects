package com.sample.samplespringbatch.writter;

import com.sample.samplespringbatch.dto.OrderDetails;
import java.util.List;
import org.springframework.batch.item.ItemWriter;

public class OrderWritter implements ItemWriter<OrderDetails> {

  @Override
  public void write(List<? extends OrderDetails> orderDetailList) throws Exception {
    orderDetailList.forEach(System.out::println);
  }
}
