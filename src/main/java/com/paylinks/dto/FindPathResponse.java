package com.paylinks.dto;

import java.util.List;
import lombok.Data;

@Data
public class FindPathResponse {
  List<String> locations;
  List<Order> orders;
  String description;
  int errorCode;
}
