package com.testvagrant.rest.models;

import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Scenarios {

    @Id private String id;

    private String scenarioName;
    private String deviceUdid;
    private String[] tags;
    private Date startTime;
    private ObjectId buildId;
    private String status;
    private Boolean completed;
    private Date endTime;
    private int timeTaken;
    private String scenarioTimeline;
    private String steps;
    private Binary failedOnScreen;

    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }

    public String getDeviceUdid() {
        return deviceUdid;
    }

    public void setDeviceUdid(String deviceUdid) {
        this.deviceUdid = deviceUdid;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public ObjectId getBuildId() {
        return buildId;
    }

    public void setBuildId(ObjectId buildId) {
        this.buildId = buildId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(int timeTaken) {
        this.timeTaken = timeTaken;
    }

    public String getScenarioTimeline() {
        return scenarioTimeline;
    }

    public void setScenarioTimeline(String scenarioTimeline) {
        this.scenarioTimeline = scenarioTimeline;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public Binary getFailedOnScreen() {
        return failedOnScreen;
    }

    public void setFailedOnScreen(Binary failedOnScreen) {
        this.failedOnScreen = failedOnScreen;
    }
}
