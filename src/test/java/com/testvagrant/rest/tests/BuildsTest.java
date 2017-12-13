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
        Assert.assertEquals(java.util.Optional.of(0).get(), buildResponse.getBody().jsonPath().get("scenarioCount"));
    }

    @Test
    public void searchForBuildRecord() {
       String buildId = "5a31697f2a9636515a6bc7d8";
        Response buildResponse = (Response) new BuildsClient().findByBuildId(buildId);
        System.out.println(buildResponse.as(Builds.class).getId());
    }
}
