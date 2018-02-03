package com.sample.samplespringbatch.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
//@Entity
//@Table(name = "order_details")
public class OrderDetails {

  @Id()
  private Integer orderId;

  private String sku;

  private Integer cost;

}
