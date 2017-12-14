package com.testvagrant.rest.requests;

import java.util.Date;

public class BuildRequest {

    private String id;
    private Date buildStartTime;
    private Date buildEndTime;
    private int scenarioCount;
    private String scenarioSuccessRate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBuildStartTime() {
        return buildStartTime;
    }

    public void setBuildStartTime(Date buildStartTime) {
        this.buildStartTime = buildStartTime;
    }

    public Date getBuildEndTime() {
        return buildEndTime;
    }

    public void setBuildEndTime(Date buildEndTime) {
        this.buildEndTime = buildEndTime;
    }

    public int getScenarioCount() {
        return scenarioCount;
    }

    public void setScenarioCount(int scenarioCount) {
        this.scenarioCount = scenarioCount;
    }

    public String getScenarioSuccessRate() {
        return scenarioSuccessRate;
    }

    public void setScenarioSuccessRate(String scenarioSuccessRate) {
        this.scenarioSuccessRate = scenarioSuccessRate;
    }
}
