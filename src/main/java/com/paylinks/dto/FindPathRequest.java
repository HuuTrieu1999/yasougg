package com.paylinks.dto;

import java.util.List;
import lombok.Data;

@Data
public class FindPathRequest {
  List<Order> orders;
}
