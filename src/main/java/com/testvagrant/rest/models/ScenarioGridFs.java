package com.testvagrant.rest.models;

public class ScenarioGridFs {

    private int interval;
    private byte[] screenshotData;

    public byte[] getScreenshotData() {
        return screenshotData;
    }

    public void setScreenshotData(byte[] screenshotData) {
        this.screenshotData = screenshotData;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }
}
