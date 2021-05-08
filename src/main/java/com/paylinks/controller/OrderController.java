package com.paylinks.controller;

import com.paylinks.dto.order.GetOrderRequest;
import com.paylinks.dto.order.GetOrderResponse;
import com.paylinks.model.OrderEntity;
import com.paylinks.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  @Autowired
  OrderRepository orderRepository;

  @PostMapping("/getOrder")
  public ResponseEntity<GetOrderResponse> getOrders(@RequestBody GetOrderRequest request){
    GetOrderResponse response = new GetOrderResponse();

    response.setOrderDS(orderRepository.findOrdersByShipperId(request.getPhone()));
    return new ResponseEntity<>(response, HttpStatus.OK);
  }



}
