package com.paylinks.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

public class TSP
{
  private static Double[][] distanceVector(String ...locations){
    HttpClient httpClient = HttpClientBuilder.create().build();
    try {
      JSONObject jo = new JSONObject();
      JSONArray ja_locations = new JSONArray();
      for (String location : locations) {
        ja_locations.put(location);
      }
      JSONObject jo_option = new JSONObject();
      jo_option.put("allToAll", true);
      jo.put("locations", ja_locations);
      jo.put("options", jo_option);

      HttpPost request = new HttpPost("http://www.mapquestapi.com/directions/v2/routematrix?key=HNWIERXhbWd61INQm6c4wI5rrwO3Sh1c");
      StringEntity params = new StringEntity(jo.toString());
      request.setEntity(params);
      HttpResponse response = httpClient.execute(request);

      StringBuilder sb = new StringBuilder();
      try {
        InputStream input = response.getEntity().getContent();

        int bytesRead = 1;
        while (bytesRead != -1) {
          byte[] array = new byte[1024];
          bytesRead = input.read(array);
          sb.append(new String(array));
        }
        input.close();
      } catch (Exception e) {
        e.getStackTrace();
      }
      JSONObject jo_response = new JSONObject(sb.toString());
      if (jo_response.getJSONObject("info").getInt("statuscode") == 0) {
        JSONArray ja_distance = new JSONArray(jo_response.getJSONArray("distance"));
        List<Double[]> distance_vector = new ArrayList<>();
        for (int i = 0; i < ja_distance.length(); i++) {
          distance_vector.add(Arrays.stream(ja_distance.getJSONArray(i).toList().toArray())
              .map(Object::toString).map(Double::valueOf).toArray(Double[]::new));
        }
        return Arrays.asList(distance_vector.toArray()).toArray(new Double[0][0]);
      } else {
        System.out.println(jo_response.getJSONObject("info").getJSONArray("messages").toString());
      }

    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {

    }
    return null;
  }

  private static boolean check_exist(int[] p,int v){
    for(int i=0;i<p.length;i++){
      if(p[i]==v) return true;
    }
    return false;
  }
  private static boolean check_done(int[] p){
    for(int i=0;i<p.length;i++){
      if(p[i]==-1) return false;
    }
    return true;
  }
  //start and end at the same.
  private static int[] find_path(Double[][] distance_vector){
    int n = distance_vector.length;
    int[] p= new int[n+1];
    int cost=0;
    for(int i=0;i<n;i++){
      p[i]=-1;
    }
    //init state
    p[0]=0;
    int indx=1;
    int min_index=0;

    while(!check_done(p)){
      //init index min road
      int k=0;
      //traverse all road from current to another
      for(int j=0;j<n;j++){
        if(!check_exist(p, j)){
          if(check_exist(p, k)){
            k=j;
          }
          else{
            if(distance_vector[min_index][j]<distance_vector[min_index][k]){
              k=j;
            }
          }
        }
      }

      p[indx]=k;
      min_index=k;
      indx++;
    }
    for(int i=0;i<n-1;i++){
      cost+=distance_vector[p[i]][p[i+1]];
    }
    cost+=distance_vector[p[n-1]][p[0]];
    p[n]=0;
    p[0]=cost;
    return p;
  }

  public static int[] findPath(String ...locations) {
    Double [][] distance_vector = distanceVector(locations);
    int[] ans = find_path(distance_vector);
    return ans;
  }

//  public static void main( String[] args )
//  {
//    System.out.println( "Hello World!" );
//    String[] locations = {"Denver, CO", "Westminster, CO", "Boulder, CO"};
//    int[] ans = findPath(locations);
//    for (int i : ans) {
//      System.out.println(i);
//    }
//  }
}