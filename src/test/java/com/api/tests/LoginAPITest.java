package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest {


        @Test(description = "Verify if Login API is working...")
        public void loginTest() {
            LoginRequest loginRequest = new LoginRequest("uday1234", "uday1234");
            AuthService authService = new AuthService();
            Response response = authService.login(loginRequest);
            LoginResponse loginResponse = response.as(LoginResponse.class);

            System.out.println(response.asPrettyString());
            System.out.println(loginResponse.getToken());
            System.out.println(loginResponse.getEmail());
            System.out.println(loginResponse.getId());

            Assert.assertTrue(loginResponse.getToken() != null);
            Assert.assertEquals(loginResponse.getEmail(), "raj@gmail.com");
            Assert.assertEquals(loginResponse.getId(), 3);

        }
    }

