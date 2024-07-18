package com.example.sandbox.user;

import static com.example.sandbox.util.constans.Tags.SMOKE;

import java.util.Map;
import java.util.TreeMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.sandbox.Common;

import io.restassured.response.Response;

public class AuthenticationTest extends Common {

    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void validLogin(){
        
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("username","test");
        queryParams.put("password","test");

        Map<String, String> headers = new TreeMap<>();
        headers.put("X-Expires-After","18th Thursday July 2024");
        headers.put("X-Rate-Limit","1000");

        Response  response = getUrl(login,headers,queryParams);
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");

    }

    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void invalidLogin(){
        
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("username","");
        queryParams.put("password","");

        Map<String, String> headers = new TreeMap<>();
        headers.put("X-Expires-After","18th Thursday July 2024");
        headers.put("X-Rate-Limit","1000");

        Response  response = getUrl(login,headers,queryParams);
        Assert.assertEquals(response.getStatusCode(),400,"Invalid response code");

    }

    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void logout(){
        
        Response  response = getUrl(logout);
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code"); 
    }
    
    
}
