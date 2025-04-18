package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTest {

    @Test(description = "Verify if Login API is working...")

    public void createAccountTest() {

        SignUpRequest signUpRequest=new SignUpRequest.Builder()
                .userName("di")
                .email("disha123@yahoo.com")
                .firstName("Disha1")
                .password("disha123")
                .lastName("Bhatt")
                .mobileNumber("7777777774")
                .build();


        AuthService authService = new AuthService();
        Response response=authService.signUp(signUpRequest);
        Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
        Assert.assertEquals(response.statusCode(), 200);

    }
}
