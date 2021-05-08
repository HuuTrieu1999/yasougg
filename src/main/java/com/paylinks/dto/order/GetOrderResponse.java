package com.paylinks.dto.order;

import com.paylinks.model.Order;
import java.util.List;
import lombok.Data;

@Data
public class GetOrderResponse {
  int code;
  String discription;
  List<Order> orders;
}
