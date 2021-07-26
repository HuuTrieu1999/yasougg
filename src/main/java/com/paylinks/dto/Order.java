package com.paylinks.dto;

import lombok.Data;

@Data
public class Order {
  String name;
  String address;
  String phone;
  long time;
  String location;
}
