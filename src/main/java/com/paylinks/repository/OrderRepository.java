package com.paylinks.repository;

import com.paylinks.model.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

  List<Order> findOrdersByShipperId(String shipperId);

}
