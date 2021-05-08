package com.paylinks.controller;

import com.paylinks.dto.order.GetOrderRequest;
import com.paylinks.dto.order.GetOrderResponse;
import com.paylinks.model.Order;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  @PostMapping("getOrder")
  public ResponseEntity<GetOrderResponse> getOrders(@RequestBody GetOrderRequest request){
    GetOrderResponse response = new GetOrderResponse();
    List<Order> list = new ArrayList<>();
    Order order1 = new Order();
    order1.setAddress("123 Ly Thuong Kiet Quan 10 TP HCM");
    order1.setId(13);
    order1.setReceiveName("ABC");
    order1.setShipperId("0123456789");
    order1.setReceiverPhone("12356");
    order1.setDueDay("10/05/2021");
    order1.setDelivery(false);

    Order order2 = new Order();
    order2.setAddress("256 Ly Thuong Kiet Quan 10 TP HCM");
    order2.setId(14);
    order2.setReceiveName("ABC");
    order2.setShipperId("0123456789");
    order2.setReceiverPhone("12356");
    order2.setDueDay("10/05/2021");
    order2.setDelivery(false);

    Order order3 = new Order();
    order3.setAddress("19 Ly Thuong Kiet Quan 10 TP HCM");
    order3.setId(15);
    order3.setReceiveName("ABC");
    order3.setShipperId("0123456789");
    order3.setReceiverPhone("12356");
    order3.setDueDay("10/05/2021");
    order3.setDelivery(false);
    response.setCode(1);
    response.setDiscription("Get order success");
    list.add(order1);
    list.add(order2);
    list.add(order3);
    response.setOrders(list);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
