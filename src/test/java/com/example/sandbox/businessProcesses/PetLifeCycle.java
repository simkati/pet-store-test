package com.example.sandbox.businessProcesses;

import static com.example.sandbox.util.constans.Tags.SMOKE;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.sandbox.Common;

import io.restassured.response.Response;

public class PetLifeCycle extends Common {

     @Test(enabled = true,groups = {SMOKE},description ="description")
        public void lifeCycle(){
        
        String body = "{\"id\": 44, \"category\": {\"id\": 0, \"name\": \"cat\"}, \"name\": \"szerenke\", \"photoUrls\": [\"string\"], \"tags\": [{\"id\": 0, \"name\": \"string\"}], \"status\": \"available\" }";
        
        /* create pet */
        
        Response  response = postUrl(pet,body);
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");

        /* update */
        
        String updateBody = "{\"id\": 44, \"category\": {\"id\": 0, \"name\": \"cat\"}, \"name\": \"lukrecia\", \"photoUrls\": [\"string\"], \"tags\": [{\"id\": 0, \"name\": \"string\"}], \"status\": \"available\" }";        
        
        Response  updateResponse = putUrl(pet,updateBody);
        Assert.assertEquals(updateResponse.getStatusCode(),200,"Invalid response code");

        Response  responseAfterUpdate = getUrl(petById, "petId", "44");
        String name = responseAfterUpdate.getBody().jsonPath().get("name").toString();
        Assert.assertEquals(responseAfterUpdate.getStatusCode(),200,"Invalid response code");
        Assert.assertEquals(name,"lukrecia","name not updated");

        /* delete */
        Response  deleteResponse = deleteUrl(petById, "petId", "44");
        Assert.assertEquals(deleteResponse.getStatusCode(),200,"Invalid response code");

        Response  responseAfterDelete = getUrl(petById, "petId", "44");
        Assert.assertEquals(responseAfterDelete.getStatusCode(),404,"Invalid response code");
    }


}
