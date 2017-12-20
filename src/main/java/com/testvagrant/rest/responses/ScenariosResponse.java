package com.testvagrant.rest.responses;

import com.testvagrant.rest.models.Scenarios;

import java.util.List;

public class ScenariosResponse {
    private List<Scenarios> scenarios;
    private ErrorResponse error;
    private boolean success;

    public List<Scenarios> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<Scenarios> scenarios) {
        this.scenarios = scenarios;
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
