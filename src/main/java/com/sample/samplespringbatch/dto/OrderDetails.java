package com.sample.samplespringbatch.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails implements Serializable {

  @Id
  @Column(name = "order_id")
  private Integer orderId;

  private String sku;

  private Integer cost;

}
