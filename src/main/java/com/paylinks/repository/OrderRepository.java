package com.paylinks.repository;

import com.paylinks.model.OrderEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface OrderRepository{ //extends JpaRepository<OrderEntity, Long> {

  List<OrderEntity> findOrdersByShipperId(String shipperId);

}
