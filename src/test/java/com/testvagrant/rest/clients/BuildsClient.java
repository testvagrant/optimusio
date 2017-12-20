package com.testvagrant.rest.clients;

import com.testvagrant.rest.requests.BuildRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static com.testvagrant.rest.endpoints.BuildsEndPoints.*;

public class BuildsClient {

    public Response createBuild(BuildRequest buildRequest) {
        Response buildResponse = given().header("Content-Type", "application/json")
                .body(buildRequest)
                .post(BUILDS+"/create");
        return buildResponse;
    }

    public Response findByBuildId(String buildId) {
       return given().header("Content-Type", "application/json")
                .pathParam("buildId",buildId)
                .get(FIND_BY_BUILDID);
    }



}
