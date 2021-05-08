package com.example.demo.service;

import com.example.demo.model.Shipper;
import com.example.demo.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  @Autowired
  ShipperRepository shipperRepository;

  public boolean login(String phone, String password){
    try {
      Shipper shipper = shipperRepository.getById(phone);
      if(shipper.getPassword().equals(password)) return true;
      else return false;
    }
    catch (Exception e){
      e.printStackTrace();
      return false;
    }
  }
}
