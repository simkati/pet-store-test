package com.example.sandbox.getInventory;
import static com.example.sandbox.util.constans.Tags.SMOKE;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.sandbox.Common;

import io.restassured.response.Response;

public class Inventorytest extends Common  {

    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void getInventory(){
        
        Response  response = getUrl(inventory);
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code"); 
    }
    
}
