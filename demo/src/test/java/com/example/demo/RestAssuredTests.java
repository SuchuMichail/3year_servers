package com.example.demo;

import com.example.demo.requests.student_groups.AddStudentGroupRequest;
import com.example.demo.requests.student_groups.GetStudentGroupByIdRequest;
import com.example.demo.requests.students.AddStudentRequest;
import com.example.demo.requests.students.DeleteStudentRequest;
import com.example.demo.requests.students.EditStudentRequest;
import org.json.JSONException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredTests {
    @BeforeAll
    public static void setup() {
        baseURI = "http://localhost:8080/";

        given()
                .body(new AddStudentGroupRequest("CP0"))
                .contentType("application/json")
        .when()
                .post("/addStudentGroup")
        .then()
                .statusCode(200)
                .body("id", notNullValue())
                .body("name",equalTo("CP0"));

        given()
                .body(new AddStudentRequest("last","first","middle","ok",1))
                .contentType("application/json")
        .when()
                .post("/addStudent")
        .then()
                .statusCode(200)
                .body("id", notNullValue());
    }

    @AfterAll
    public static void deleteStudentTest(){
        given()
                .body(new DeleteStudentRequest(1))
                .contentType("application/json")
        .when()
                .delete("/deleteStudentById")
        .then()
                .statusCode(200)
                .body(isEmptyOrNullString());
    }

    @Test
    public void duplicateNameGroupTest(){
        given()
                .body(new AddStudentGroupRequest("CP0"))//not unique
                .contentType("application/json")
        .when()
                .post("/addStudentGroup")
        .then()
                .statusCode(500);
    }

    @Test
    public void getStudentGroupTest(){
        given()
                .body(new GetStudentGroupByIdRequest(1))
                .contentType("application/json")
        .when()
                .get("/getStudentGroupById")
        .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", equalTo("CP0"));
    }

    @Test
    public void editStudentTest(){
        given()
                .body(new EditStudentRequest(1,"last","second","middle","ok",1))
                .contentType("application/json")
        .when()
                .patch("/editStudent")
        .then()
                .statusCode(200)
                .body(isEmptyOrNullString());
    }
}
