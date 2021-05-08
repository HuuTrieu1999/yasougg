package com.paylinks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

//@Entity
@Data
public class Shipper {

//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  //@Column(unique = true)
  String phoneNumber;

  String name;

  String password;

}
