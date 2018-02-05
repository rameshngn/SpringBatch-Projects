package com.sample.samplespringbatch.reader;

import com.sample.samplespringbatch.dao.OrderDAO;
import com.sample.samplespringbatch.dto.OrderDetails;
import com.sample.samplespringbatch.dto.OrderResult;
import java.util.List;
import java.util.Optional;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
@StepScope
public class OrderReader implements ItemReader {

  @Autowired
  OrderDAO orderDAO;

  @Autowired
  OrderDetailRepository orderRepository;

  private int count=0;

  @Override
  public List<OrderDetails> read()
      throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
    OrderResult orderResult=new OrderResult();
    //List<OrderDetails> orderDetailsList=Optional.ofNullable(orderDAO.readOrderdetails()).get();
    List<OrderDetails> orderDetailsList=Optional.ofNullable(orderRepository.getOrderDetails(130)).get();
    if(!CollectionUtils.isEmpty(orderDetailsList) && count==0){
      count=count+1;
      return orderDetailsList;
    }else{
      return null;
    }

  }


}
