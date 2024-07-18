package com.example.sandbox.getPetList;

import com.example.sandbox.Common;
import io.restassured.response.Response;


import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;
import java.util.TreeMap;

import static com.example.sandbox.util.constans.Tags.SMOKE;

public class PetListTest extends Common {

    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void availablePetList(){
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status","available");

        Response  response = getUrl(findByStatus, queryParams);
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");
    }

    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void soldPetList(){
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status","sold");
        Map<String, String> headers = new TreeMap<>();
        headers.put("Mandatoyheader","BFG");

        Response  response = getUrl(findByStatus,headers,queryParams);
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");

    }

    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void invalidStatus(){
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status","invalid");

        Response  response = getUrl(findByStatus, queryParams);
        Assert.assertEquals(response.getStatusCode(),400,"Invalid response code");
    }
}
