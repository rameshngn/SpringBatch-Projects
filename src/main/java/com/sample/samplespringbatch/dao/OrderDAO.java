package com.sample.samplespringbatch.dao;

import com.sample.samplespringbatch.dto.OrderDetails;
import com.sample.samplespringbatch.dto.OrderResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO {

  @Autowired
  DataSource orderDataSource;

  public List<OrderDetails> readOrderdetails() {

    String sqlStatement = "select ORDER_ID,SKU,COST from order_details";
    NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
        orderDataSource);
    List<OrderDetails> orderDetailsList =
        namedParameterJdbcTemplate
            .query(sqlStatement, new BeanPropertyRowMapper<>(OrderDetails.class));
    return orderDetailsList;
  }

  public int insertIntoOrderRetail(List<OrderResult> resultList) {
    String sqlStatement = "Insert into order_retail (ORDER_ID, SKU, RETAIL) values(:ORDER_ID,:SKU,:RETAIL)";
    List<Map<String, Object>> batchvalues = new ArrayList<>();
    NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
        orderDataSource);

    MapSqlParameterSource parameterSource;
    for (OrderResult orderResult : resultList) {
      parameterSource = new MapSqlParameterSource();
      parameterSource.addValue("SKU", orderResult.getSku());
      parameterSource.addValue("ORDER_ID", orderResult.getOrderId());
      parameterSource.addValue("RETAIL", orderResult.getRetail());
      batchvalues.add(parameterSource.getValues());
    }
   int insertCount[]= namedParameterJdbcTemplate.batchUpdate(sqlStatement,batchvalues.toArray(new Map[batchvalues.size()]));
  return insertCount.length;
  }
}
