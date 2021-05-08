package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Order {

  @Id
  long id;

  String address;
  String receiver_name;
  String receiver_phone;
  String due_day;
  boolean isDelivery;
  String shipper_id;
}
