package com.example.sandbox.postPet;
import com.example.sandbox.Common;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.example.sandbox.util.constans.Tags.REGRESSION;

public class UploadImageTest extends Common {

    @Test(enabled = true,groups = {REGRESSION},description ="description")
    public void uploadImage(){
        String petId = "10";
       
        Response  response = postUrl(uploadImage, "petId",petId);
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");
    }

    @Test(enabled = true,groups = {REGRESSION},description ="description")
    public void invalidImageUpload(){
        String petId = "10";
       
        Response  response = postUrl(uploadImage,"petId", petId);
        Assert.assertNotEquals(response.getStatusCode(),200,"Invalid response code");
    }
}
