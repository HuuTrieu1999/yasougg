package com.paylinks.service;

import com.paylinks.dto.order.GetOrderRequest;
import com.paylinks.model.OrderEntity;
import com.paylinks.repository.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  @Autowired
  OrderRepository orderRepository;

  public List<OrderEntity> getOrder(GetOrderRequest request){

    return orderRepository.findOrdersByShipperId(request.getPhone());
  }
}
