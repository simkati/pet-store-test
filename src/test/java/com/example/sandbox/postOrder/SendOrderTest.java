package com.example.sandbox.postOrder;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.sandbox.Common;

import io.restassured.response.Response;
import static com.example.sandbox.util.constans.Tags.SMOKE;
import static com.example.sandbox.util.constans.Tags.REGRESSION;;

public class SendOrderTest extends Common{
     
    @Test(enabled = true,groups = {SMOKE},description ="description")
        
      public void createOrder(){
        
        String body = "{\"id\": 3, \"petId\": 3, \"quantity\": 2, \"shipDate\": \"2024-07-18T16:22:53.970Z\", \"status\": \"placed\", \"complete\": true}";
        
        Response  response = postUrl(order,body);
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");

    }

    @Test(enabled = true,groups = {REGRESSION},description ="description")
        
    public void invalidOrder(){
      
      String body = "{\"id\": 3, \"petId\": 3 \"quantity\": 2, \"shipDate\": \"2024-07-18T16:22:53.970Z\", \"status\": \"placed\", \"complete\": true}";
      
      Response  response = postUrl(order,body);
      Assert.assertEquals(response.getStatusCode(),400,"Invalid response code");

  }
    
}
