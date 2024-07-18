package com.example.sandbox.postPet;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.sandbox.Common;

import io.restassured.response.Response;

import static com.example.sandbox.util.constans.Tags.SMOKE;

public class NewPetTest extends Common{
    
     @Test(enabled = true,groups = {SMOKE},description ="description")
    public void createPet(){
        
        String body = "{\"id\": 32, \"category\": {\"id\": 0, \"name\": \"dog\"}, \"name\": \"doggie\", \"photoUrls\": [\"string\"], \"tags\": [{\"id\": 0, \"name\": \"string\"}], \"status\": \"available\" }";
        
        Response  response = postUrl(pet,body);
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");

    }

    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void invalidIdPet(){
        
        String body = "{\"id\": \"10\", \"category\": {\"id\": 0, \"name\": \"dog\"}, \"name\": \"\", \"photoUrls\": [\"string\"], \"tags\": [{\"id\": 0, \"name\": \"string\"}], \"status\": \"available\" }";
        
        Response  response = postUrl(pet,body);
        Assert.assertEquals(response.getStatusCode(),405,"Invalid response code");

    }
}

