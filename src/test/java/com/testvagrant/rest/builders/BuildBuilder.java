package com.testvagrant.rest.builders;

import com.testvagrant.rest.requests.BuildRequest;

import java.util.Date;

public class BuildBuilder {

    private BuildRequest buildRequest = new BuildRequest();

    public BuildBuilder() {
        Date currentDate = new Date();
        buildRequest.setBuildStartTime(currentDate);
        buildRequest.setBuildEndTime(currentDate);
        buildRequest.setScenarioCount(0);
        buildRequest.setScenarioSuccessRate("0.0");
    }

    public BuildBuilder withId(String id) {
        buildRequest.setId(id);
        return this;
    }

    public BuildBuilder withBuildStartTime(Date buildStartTime) {
        buildRequest.setBuildStartTime(buildStartTime);
        return this;
    }

    public BuildBuilder withBuildEndTime(Date buildEndTime) {
        buildRequest.setBuildEndTime(buildEndTime);
        return this;
    }

    public BuildBuilder withScenarioCount(int scenarioCount) {
        buildRequest.setScenarioCount(scenarioCount);
        return this;
    }

    public BuildBuilder withScenarioSuccessRate(String scenarioSuccessRate) {
        buildRequest.setScenarioSuccessRate(scenarioSuccessRate);
        return this;
    }

    public BuildRequest build() {
        return buildRequest;
    }
}
