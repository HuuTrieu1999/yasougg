package com.paylinks.service;

import com.paylinks.dto.login.SignupRequest;
import com.paylinks.model.Shipper;
import com.paylinks.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  @Autowired
  ShipperRepository shipperRepository;

  public boolean login(String phone, String password){
    try {
      Shipper shipper = shipperRepository.findShipperByPhoneNumber(phone);
      if(shipper.getPassword().equals(password)) return true;
      else return false;
    }
    catch (Exception e){
      e.printStackTrace();
      return false;
    }
  }

  public boolean signup(SignupRequest request){
    try {
      Shipper shipper = new Shipper();
      shipper.setPhoneNumber(request.getPhone());
      shipper.setName(request.getName());
      shipper.setPassword(request.getPassword());
      shipperRepository.save(shipper);
    }
    catch (Exception e){
      e.printStackTrace();

      return false;
    }

    return true;
  }

}
