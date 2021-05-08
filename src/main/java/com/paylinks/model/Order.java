package com.paylinks.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Order {

  @Id
  long id;

  String address;
  String receiveName;
  String receiverPhone;
  String dueDay;
  boolean isDelivery;
  String shipperId;
}
