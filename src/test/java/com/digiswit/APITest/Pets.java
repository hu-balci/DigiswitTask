package com.digiswit.APITest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class Pets {

    String Url="https://petstore.swagger.io/v2";

    String pet="dog";

    String jsonBody="{\n" +
            "  \"id\": 20,\n" +
            "  \"category\": {\n" +
            "    \"id\": 20,\n" +
            "    \"name\": \"dog\"\n" +
            "  },\n" +
            "  \"name\": \"doggie\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"string\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 0,\n" +
            "      \"name\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"available\"\n" +
            "}";


    String updatedJsonBody="{\n" +
            "  \"id\": 20,\n" +
            "  \"category\": {\n" +
            "    \"id\": 20,\n" +
            "    \"name\": \"dog\"\n" +
            "  },\n" +
            "  \"name\": \"doggie\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"string\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 0,\n" +
            "      \"name\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"sold\"\n" +
            "}";
    String status="sold";


    @Test
    public  void PostPet (){
        Response response=given()
                .accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(jsonBody)
                .when().post(Url+"/pet");

        Assert.assertEquals("application/json",response.contentType());
        Assert.assertEquals(200,response.statusCode());
        Assert.assertTrue(response.body().asString().contains(pet));

    }


    @Test
    public  void positiveGetPetByIdTest () {

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("petId", "20")
                .when().get(Url+"/pet/{petId}/");

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json");
        Assert.assertTrue(response.body().asString().contains(pet));
    }

    @Test
    public  void negativeGetPetByIdTest () {

        //get pet by incorrect id

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("petId", "200")
                .when().get(Url+"/pet/{petId}/");

        Assert.assertEquals(response.statusCode(), 404);
        Assert.assertTrue(response.body().asString().contains("Pet not found"));
    }

    @Test
    public void positivePutPetTest(){

        Response response=  given().and()
                .contentType(ContentType.JSON)
                .and()
                .body(updatedJsonBody).
                when()
                .put(Url+"/pet");

        Assert.assertEquals("application/json",response.contentType());
        Assert.assertEquals(200,response.statusCode());
        Assert.assertTrue(response.body().asString().contains(status));

    }

    @Test
    public void negativePutPetTest(){

            //assert by incorrect status

        Response response=  given().and()
                .contentType(ContentType.JSON)
                .and()
                .body(updatedJsonBody).
                when()
                .put(Url+"/pet");

        Assert.assertEquals(200,response.statusCode());
        Assert.assertTrue(response.body().asString().contains("available"));

    }

    @Test
    public void deletePet(){

        Response response=  given().and()
                .contentType(ContentType.JSON)
                .and()
                .body(updatedJsonBody).
                when()
                .delete(Url+"/pet/20");

        Assert.assertEquals(200,response.statusCode());
    }

    @Test
    public void negativeDeletePetTest(){

        // delete by deleted pet id

        Response response=  given().and()
                .contentType(ContentType.JSON)
                .and()
                .body(updatedJsonBody).
                when()
                .delete(Url+"/pet/20");

        Assert.assertEquals(404,response.statusCode());
    }

}
