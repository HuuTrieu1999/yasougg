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
    String[] locationsParam = toArray(locations);
    int[] result = find(locationsParam, 0);
    if(result == null) {
      response.setDescription("Can not fin location");
      response.setOrders(request.getOrders());
      return response;
    }

    List<Order> sortedOrders = new ArrayList<>();
    List<String> sortedLocations = new ArrayList<>();
    for(int index = 1; index < result.length; index++) {
      sortedLocations.add(locationsParam[result[index]]);
      sortedOrders.add(map.get(locationsParam[result[index]]));
    }

    response.setLocations(sortedLocations);
    response.setOrders(sortedOrders);
    response.setDescription("SUCCESS");
    response.setErrorCode(1);
    return response;
  }

  private String[] toArray(List<String> list){
    String[] arr = new String[list.size()];
    for(int i = 0; i < list.size(); i++){
      arr[i] = list.get(i);
    }
    return arr;
  }

  private int[] find(String[] locationsParam, int retry){
    if(retry >=3) return null;
    try {
      return TSP.findPath(locationsParam);
    }
    catch (Exception e){
      logger.info("[TSP} Exception: ", e.getMessage());
      sleep(retry);
      return find(locationsParam, retry+1);
    }
  }

  private void sleep(int retry){
    logger.info("[Sleep] retry: {}",retry);
    try {
      Thread.sleep(1000);
    }
    catch (Exception e){
      logger.info("[Sleep] Exception: {}",e.getMessage());
    }
  }


}
