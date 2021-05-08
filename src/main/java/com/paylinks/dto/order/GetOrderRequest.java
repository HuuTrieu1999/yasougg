package com.paylinks.dto.order;

import lombok.Data;

@Data
public class GetOrderRequest {
  String phone;
  long sessionId;
}
