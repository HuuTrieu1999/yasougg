package com.paylinks.service;

import com.paylinks.dto.FindPathRequest;
import com.paylinks.dto.FindPathResponse;
import com.paylinks.dto.Order;
import com.paylinks.util.TSP;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class YasouService {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  public FindPathResponse find(FindPathRequest request){
    FindPathResponse response = new FindPathResponse();
    Map<String, Order> map = new HashMap<>();
    List<String> locations = new ArrayList<>();
    for (Order order : request.getOrders()){
      map.put(order.getLocation(), order);
      locations.add(order.getLocation());
    }
    String[] locationsParam = (String[]) locations.toArray();
    int[] result = TSP.findPath(locationsParam);
    List<Order> sortedOrders = new ArrayList<>();
    List<String> sortedLocations = new ArrayList<>();
    for(int index : result) {
      sortedLocations.add(locationsParam[index]);
      sortedOrders.add(map.get(locationsParam[index]));
    }

    response.setLocations(sortedLocations);
    response.setOrders(sortedOrders);
    response.setDescription("SUCCESS");
    response.setErrorCode(1);
    return response;
  }
}