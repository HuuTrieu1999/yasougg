package com.paylinks.controller;

import com.paylinks.dto.order.GetOrderRequest;
import com.paylinks.dto.order.GetOrderResponse;
import com.paylinks.model.OrderEntity;
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
    List<OrderEntity> list = new ArrayList<>();
    OrderEntity orderD1 = new OrderEntity();
    orderD1.setAddress("123 Ly Thuong Kiet Quan 10 TP HCM");
    orderD1.setId(13);
    orderD1.setReceiverName("ABC");
    orderD1.setShipperId("0123456789");
    orderD1.setReceiverPhone("12356");
    orderD1.setDueDay("10/05/2021");
    orderD1.setDelivery(false);

    OrderEntity orderD2 = new OrderEntity();
    orderD2.setAddress("256 Ly Thuong Kiet Quan 10 TP HCM");
    orderD2.setId(14);
    orderD2.setReceiverName("ABC");
    orderD2.setShipperId("0123456789");
    orderD2.setReceiverPhone("12356");
    orderD2.setDueDay("10/05/2021");
    orderD2.setDelivery(false);

    OrderEntity orderD3 = new OrderEntity();
    orderD3.setAddress("19 Ly Thuong Kiet Quan 10 TP HCM");
    orderD3.setId(15);
    orderD3.setReceiverName("ABC");
    orderD3.setShipperId("0123456789");
    orderD3.setReceiverPhone("12356");
    orderD3.setDueDay("10/05/2021");
    orderD3.setDelivery(false);
    response.setCode(1);
    response.setDiscription("Get order success");
    list.add(orderD1);
    list.add(orderD2);
    list.add(orderD3);
    response.setOrderDS(list);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}