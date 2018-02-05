package com.sample.samplespringbatch.writter;

import com.sample.samplespringbatch.dao.OrderDAO;
import com.sample.samplespringbatch.dto.OrderResult;
import com.sample.samplespringbatch.reader.OrderDetailRepository;
import java.util.List;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class OrderWritter implements ItemWriter<List<OrderResult>> {

  @Autowired
  OrderDAO orderDAO;

  @Autowired
  OrderDetailRepository orderRepository;

  @Override
  public void write(List<? extends List<OrderResult>> orderResultList) throws Exception {
    orderResultList.stream().forEach(resultList -> {
      orderDAO.insertIntoOrderRetail(resultList);
    });
    System.out.println("Batch finished");
  }
}