package com.paylinks.repository;

import com.paylinks.model.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//@Repository
public interface ShipperRepository {//extends JpaRepository<Shipper, String> {

  Shipper findShipperByPhoneNumber(String phoneNumber);

  void save(Shipper shipper);

}
