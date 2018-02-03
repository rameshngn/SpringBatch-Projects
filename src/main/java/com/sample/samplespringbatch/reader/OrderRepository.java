package com.sample.samplespringbatch.reader;

import com.sample.samplespringbatch.dto.OrderDetails;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface OrderRepository {//extends JpaRepository<OrderDetails,Class> {

  List<OrderDetails> findAllByOrderId();

}
