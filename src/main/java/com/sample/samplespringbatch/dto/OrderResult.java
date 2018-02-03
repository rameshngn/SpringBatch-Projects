package com.sample.samplespringbatch.dto;

import lombok.Data;

@Data
public class OrderResult {

  private Integer orderId;

  private String sku;

  private Integer retail;

}
