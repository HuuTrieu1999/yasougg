package com.paylinks.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class OrderEntity {

  @Id
  long id;

  String address;
  String receiverName;
  String receiverPhone;
  String dueDay;
  boolean isDelivery;
  String shipperId;
}
