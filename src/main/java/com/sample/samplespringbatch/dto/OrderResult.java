package com.sample.samplespringbatch.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order_retail")
public class OrderResult {

  @Id
  @GeneratedValue
  private Integer orderId;

  private String sku;

  private Integer retail;

}
