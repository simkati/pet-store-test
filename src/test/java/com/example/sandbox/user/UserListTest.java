package com.example.sandbox.user;

import static com.example.sandbox.util.constans.Tags.SMOKE;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.sandbox.Common;

import io.restassured.response.Response;

public class UserListTest extends Common {

    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void CreateUserArray(){
        
        String body = "[{\"id\": 0, \"username\": \"string\", \"firstName\": \"string\", \"lastName\": \"string\", \"email\": \"string\", \"password\": \"string\", \"phone\": \"string\", \"userStatus\": 0}]";

        Response  response = postUrl(createWithArray, body);
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code"); 
    }

    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void InvalidUserArray(){
        
        String body = "[{\"id\": 0 \"username\": \"string\", \"firstName\": \"string\", \"lastName\": \"string\", \"email\": \"string\", \"password\": \"string\", \"phone\": \"string\", \"userStatus\": 0}]";

        Response  response = postUrl(createWithArray, body);
        Assert.assertNotEquals(response.getStatusCode(),200,"Invalid response code"); 
    }
    
    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void CreateUserList(){
        
        String body = "[{\"id\": 0, \"username\": \"string\", \"firstName\": \"string\", \"lastName\": \"string\", \"email\": \"string\", \"password\": \"string\", \"phone\": \"string\", \"userStatus\": 0}]";

        Response  response = postUrl(createWithList, body);
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code"); 
    }

    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void InvalidUserList(){
        
        String body = "[{\"id\": 0 \"username\": \"string\", \"firstName\": \"string\", \"lastName\": \"string\", \"email\": \"string\", \"password\": \"string\", \"phone\": \"string\", \"userStatus\": 0}]";

        Response  response = postUrl(createWithList, body);
        Assert.assertNotEquals(response.getStatusCode(),200,"Invalid response code"); 
    }
    
}
