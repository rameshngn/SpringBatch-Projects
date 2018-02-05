package com.sample.samplespringbatch.writter;

import com.sample.samplespringbatch.dto.OrderResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderResultRepository extends JpaRepository<OrderResult,Integer>{

  @Query(name = "Insert into order_retail (ORDER_ID, SKU, RETAIL) values(:ORDER_ID,:SKU,:RETAIL)",nativeQuery = true)
  void insertIntoOrderResult();
}
