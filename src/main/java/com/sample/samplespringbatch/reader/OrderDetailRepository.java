package com.sample.samplespringbatch.reader;

import com.sample.samplespringbatch.dto.OrderDetails;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetails,Integer> {

  @Query(value = "select ORDER_ID, SKU, COST from order_details where ORDER_ID= :ORDER_ID",nativeQuery = true)
  List<OrderDetails> getOrderDetails(@Param("ORDER_ID") Integer ORDER_ID);


}
