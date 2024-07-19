package com.example.sandbox.getPet;

import com.example.sandbox.Common;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.TreeMap;

import static com.example.sandbox.util.constans.Tags.REGRESSION;;

public class PetDetailTest extends Common {

    @Test(enabled = true,groups = {REGRESSION},description ="description")
    public void getAvailablePet(){
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status","available");

        Response  response = getUrl(findByStatus, queryParams);
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");

        String id = response.jsonPath().get("[0].id").toString();

        Response  response2 = getUrl(petById, "petId", id);
        Assert.assertEquals(response2.getStatusCode(),200,"Invalid response code"); 
    }

    @Test(enabled = true,groups = {REGRESSION},description ="description")
    public void getInvalidIdPet(){
        
        String id = "invalid";

        Response  response = getUrl(petById, "petId", id);
        Assert.assertEquals(response.getStatusCode(),400,"Invalid response code"); 
    }

    @Test(enabled = true,groups = {REGRESSION},description ="description")
    public void petNotFound(){
        
        String id = "123456789";

        Response  response = getUrl(petById, "petId", id);
        Assert.assertEquals(response.getStatusCode(),404,"Invalid response code"); 
    }
}
