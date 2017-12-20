package com.testvagrant.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Devices {

    @JsonIgnore
    @Id private String id;
    private String platform;
    private String status;
    private String deviceName;
    private String platformVersion;
    private String udid;
    private String runsOn;
    @JsonIgnore private ObjectId buildId;
    @JsonIgnore private byte[] screenshot = new byte[]{};


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getRunsOn() {
        return runsOn;
    }

    public void setRunsOn(String runsOn) {
        this.runsOn = runsOn;
    }

    public ObjectId getBuildId() {
        return buildId;
    }

    public void setBuildId(ObjectId buildId) {
        this.buildId = buildId;
    }

    public byte[] getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(byte[] screenshot) {
        this.screenshot = screenshot;
    }
}
