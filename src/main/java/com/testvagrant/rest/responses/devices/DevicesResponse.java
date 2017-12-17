package com.testvagrant.rest.responses.devices;

import com.testvagrant.rest.resources.ErrorResponse;

public class DevicesResponse<T> {
    private T devices;
    private ErrorResponse error;
    private boolean success;

    public T getDevices() {
        return devices;
    }

    public void setDevices(T devices) {
        this.devices = devices;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
