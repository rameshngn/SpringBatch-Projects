package com.sample.samplespringbatch.processor;

import com.sample.samplespringbatch.dto.OrderDetails;
import com.sample.samplespringbatch.dto.OrderResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class OrderProcessor implements ItemProcessor<List<OrderDetails>,List<OrderResult>> {

  @Override
  public List<OrderResult> process(List<OrderDetails> orderDetailsList) throws Exception {
    OrderResult orderResult=new OrderResult();
    List<OrderResult> orderResultList=new ArrayList<>();
    orderDetailsList.forEach(orderDetails -> {
      orderResult.setOrderId(orderDetails.getOrderId());
      orderResult.setSku(orderDetails.getSku());
      orderResult.setRetail(calculteRetailAmount(orderDetails.getCost()));
      orderResultList.add(orderResult);
    });
    return orderResultList;
  }
  private Integer calculteRetailAmount(Integer cost){
    return cost*2;
  }
}
