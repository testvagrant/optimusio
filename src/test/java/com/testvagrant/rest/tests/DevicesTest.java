package com.testvagrant.rest.tests;

import com.testvagrant.rest.models.Devices;
import com.testvagrant.rest.responses.DevicesResponse;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DevicesTest {

    private byte[] screenshot = new byte[]{};

    @Test
    public void updateDevices() {
        Devices devices = new Devices();
        devices.setScreenshot(screenshot);
        Response post = given()
                .header("Content-Type", "application/json")
                .pathParam("id", "5a32c1732a9636199ebcce81")
                .pathParam("udid", "afadgad")
                .body(devices)
                .put("http://localhost:8080/v1/devices/{id}/{udid}");
        System.out.println(post.asString());
    }

    @Test
    public void engageDevice() {
        Response post = given()
                .header("Content-Type", "application/json")
                .pathParam("id", "5a3617e8cebe502dbe5cdc9a")
                .put("http://localhost:8080/v1/devices/{id}/engageDevice");
        System.out.println(post.asString());
        DevicesResponse response = post.as(DevicesResponse.class);
    }


    @Test
    public void getAllDevices() {
        Response post = given()
                .header("Content-Type", "application/json")
                .pathParam("id", "5a379f854108aaab2f92cd8a")
                .get("http://localhost:8080/v1/devices/{id}");
        System.out.println(post.asString());
        DevicesResponse response = post.as(DevicesResponse.class);
    }

    @Test
    public void getDevices() {
        Response post = given()
                .header("Content-Type", "application/json")
                .pathParam("id", "5a3898fecebe507d11397378")
                .pathParam("udid", "4200935feed2a28f")
                .get("http://localhost:8080/v1/devices/getDevice/{id}/{udid}");
        System.out.println(post.asString());
        DevicesResponse response = post.as(DevicesResponse.class);
    }


}
