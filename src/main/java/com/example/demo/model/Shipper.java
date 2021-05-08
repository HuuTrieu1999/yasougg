package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Shipper {

  @Id
  String phone_number;

  String name;

  String password;

}
