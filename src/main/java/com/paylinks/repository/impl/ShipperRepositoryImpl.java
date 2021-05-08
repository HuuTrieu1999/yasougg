package com.paylinks.repository.impl;

import com.paylinks.model.Shipper;
import com.paylinks.repository.ShipperRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ShipperRepositoryImpl implements ShipperRepository {

  List<Shipper> list = new ArrayList<>();

  ShipperRepositoryImpl(){
    Shipper shipper = new Shipper();
    shipper.setPhoneNumber("123456");
    shipper.setName("Huu");
    shipper.setPassword("12345");
    list.add(shipper);
  }

  @Override
  public Shipper findShipperByPhoneNumber(String phoneNumber) {
    return list.get(0);
  }

  @Override
  public void save(Shipper shipper) {
    list.add(shipper);
  }


}
