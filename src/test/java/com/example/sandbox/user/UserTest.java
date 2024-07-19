package com.example.sandbox.user;

import com.example.sandbox.Common;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.example.sandbox.util.constans.Tags.SMOKE;
import static com.example.sandbox.util.constans.Tags.REGRESSION;

public class UserTest extends Common {

    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void getUser(){
        
        String username = "string";

        Response  response = getUrl(user, "username", username);
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code"); 
    }
   
    @Test(enabled = true,groups = {REGRESSION},description ="description")
    public void invalidUser(){
        
        String username = "invalid";

        Response  response = getUrl(user, "username", username);
        Assert.assertEquals(response.getStatusCode(),404,"Invalid response code"); 
    }
}
