package com.sample.samplespringbatch.processor;

import com.sample.samplespringbatch.dto.OrderDetails;
import com.sample.samplespringbatch.dto.OrderResult;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.batch.item.ItemProcessor;


public class OrderProcessor implements ItemProcessor<OrderDetails,OrderResult> {

  @Override
  public OrderResult process(OrderDetails orderDetails) throws Exception {
    OrderResult orderResult=new OrderResult();
      orderResult.setOrderId(orderDetails.getOrderId());
      orderResult.setSku(orderDetails.getSku());
      orderResult.setRetail(calculteRetailAmount(orderDetails.getCost()));

    return orderResult;
  }
  private Integer calculteRetailAmount(Integer cost){
    return cost*2;
  }
}
