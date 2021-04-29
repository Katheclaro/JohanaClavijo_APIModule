package com.globant.apiTest;

import com.globant.BaseTest.BaseTest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import constants.Endpoint;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globant.pojo.BankTransacctionPojo;

import java.util.List;


public class ApiTest extends BaseTest {
    /**
     * Get a endpoint empty, if there are data the tes delete them
     */
    @Test
    public void getEmptyEndPoint() {
        /**
         * Get data
        */
        Response responseGet = getEndPoint(Endpoint.URL);

        responseGet.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

        /**
         * Validate all array is empty
         */
        JSONArray data = new JSONArray(responseGet.asString());

        if (data.length() <= 0) {
            responseGet.then()
                    .assertThat()
                    .statusCode(HttpStatus.SC_OK).body("", Matchers.hasSize(0));
        }


        /**
         * Delete data to get empty
         */
        for (int i = 0; i < data.length(); i++) {

            JSONObject item = data.getJSONObject(i);
            String id = item.getString("id");
            Response responseDelete = deleteEndPoint(Endpoint.URL + "/" + id);
        }

        /**
         * Result
         */
        Response responseDelete = getEndPoint(Endpoint.URL);
        responseDelete.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK).body("", Matchers.hasSize(0));

    }

    /**
     * Create a new object and validae email
     */
    @Test
    public void createObject() {

        for (int i = 1; i < 20; i++) {

            /**
             * Get the current array
             */
            RequestSpecification request = RestAssured.given();
            BankTransacctionPojo pojoEndpoint = new BankTransacctionPojo();

            /**
             * Change the json to pojo
             */
            Response responseGet = getEndPoint(Endpoint.URL);
            List<BankTransacctionPojo> bankTransacctionPojoList = new Gson().fromJson(responseGet.asString(), new TypeToken<List<BankTransacctionPojo>>() {
            }.getType());


            /**
             * validate the email with current data
             */
            for (BankTransacctionPojo bankTransacctionPojo : bankTransacctionPojoList) {
                Assert.assertFalse(bankTransacctionPojo.getEmail().equals(pojoEndpoint.getEmail()));

            }

            request.body(new Gson().toJson(pojoEndpoint));
            /**
            * result
            */
            Response responsePost = request.post(Endpoint.URL);
            responsePost.then()
                    .assertThat()
                    .statusCode(HttpStatus.SC_CREATED);

        }

    }

    /**
     * Get a failed test
     */
    @Test
    public void negativeTest() {

        /**
         * Get data
         */
        Response responseGet = getOneEndPoint(Endpoint.URL, "1");

        BankTransacctionPojo bankTransacctionPojo = new Gson().fromJson(responseGet.asString(), BankTransacctionPojo.class);

        Response responseGetAll = getEndPoint(Endpoint.URL);
        /**
        * get the list current data and transform to Json
        */
        List<BankTransacctionPojo> bankTransacctionPojoList = new Gson().fromJson(responseGetAll.asString(), new TypeToken<List<BankTransacctionPojo>>() {
        }.getType());


        /**
         * Comparative email the object vs currently array
         */
        for (BankTransacctionPojo bankTran : bankTransacctionPojoList) {

            boolean emailExists = bankTran.getEmail().equals(bankTransacctionPojo.getEmail());
            if (emailExists) {
                System.out.println("Email already exists");

            }
            Assert.assertFalse(emailExists);
        }
    }

    /**
     * update object
     */
    @Test
    public void updateTest() {

        Response responseGet = getOneEndPoint(Endpoint.URL, "1");
        /**
        * Get a accountnumber of the object
        */
        BankTransacctionPojo bankTransacctionPojo = new Gson().fromJson(responseGet.asString(), BankTransacctionPojo.class);
        bankTransacctionPojo.setAccountNumber("1233456");

        Response responsePut = putEndPoint(Endpoint.URL, bankTransacctionPojo.getId(), new Gson().toJson(bankTransacctionPojo));

        /**
        * Validate update
        */
        responsePut.then().statusCode(HttpStatus.SC_OK);
        BankTransacctionPojo pojoResponse = new Gson().fromJson(responsePut.asString(), BankTransacctionPojo.class);
        Assert.assertEquals(bankTransacctionPojo.getAccountNumber(), pojoResponse.getAccountNumber());

    }

}




