package com.testvagrant.rest.tests;

import com.testvagrant.rest.builders.BuildBuilder;
import com.testvagrant.rest.clients.BuildsClient;
import com.testvagrant.rest.models.Builds;
import com.testvagrant.rest.requests.BuildRequest;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class BuildsTest {

    @Test
    public void createANewBuildRecord() {
        BuildRequest buildRequest = new BuildBuilder().build();
        Response buildResponse = new BuildsClient().createBuild(buildRequest);
        System.out.println(buildResponse.asString());
    }

    @Test
    public void searchForBuildRecord() {
       String buildId = "12xyz345id";
        BuildRequest buildRequest = new BuildBuilder().withId(buildId).build();
        BuildsClient buildsClient = new BuildsClient();
        buildsClient.createBuild(buildRequest);
        Response buildResponse = new BuildsClient().findByBuildId(buildId);
        Assert.assertEquals(buildId, buildResponse.as(Builds.class).getId());
    }
}

