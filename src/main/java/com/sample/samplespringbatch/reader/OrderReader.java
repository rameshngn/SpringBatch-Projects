package com.sample.samplespringbatch.reader;

import com.sample.samplespringbatch.dto.OrderDetails;
import com.sample.samplespringbatch.dto.OrderResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderReader implements ItemReader {

  @Autowired
  OrderRepository orderRepository;

  @Override
  public List<OrderDetails> read()
      throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
    OrderResult orderResult=new OrderResult();
    List<OrderDetails> orderDetailsList=Optional.ofNullable(orderRepository.findAllByOrderId()).get();
    return orderDetailsList;
  }


}
