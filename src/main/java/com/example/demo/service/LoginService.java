package com.example.demo.service;

import com.example.demo.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  @Autowired
  ShipperRepository shipperRepository;

  public boolean login(String phone, String password){

  }
}
