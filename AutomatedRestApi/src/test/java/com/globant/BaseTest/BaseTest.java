package com.globant.BaseTest;

import com.google.gson.Gson;
import constants.Endpoint;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.params.CoreConnectionPNames;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;


public class BaseTest {


    public Response getEndPoint(String url) {

        Response response = given().contentType("application/json").when().get(url);
        return response;
    }

    public Response getOneEndPoint(String url, String id) {

        Response response = given().contentType("application/json").when().get(url + "/" + id);

        return response;
    }

    public Response deleteEndPoint(String url) {

        Response response = given().contentType("application/json").when().delete(url);
        return response;
    }

    public Response postEndPoint(String url) {

        Response response = given().contentType("application/json").when().post(url);
        return response;
    }

    public Response putEndPoint(String url, String id, String body) {

        RequestSpecification request = getRequestSpecification();
        request.body(body);
        Response responsePut = request.put(url + "/" + id);

        return responsePut;
    }

    public RequestSpecification getRequestSpecification() {

        RequestSpecification request = RestAssured.given();
        return request;
    }



}
