package com.testvagrant.rest.responses;

import com.testvagrant.rest.models.Builds;

public class BuildResponse {

    private Builds builds;
    private ErrorResponse error;
    private boolean success;

    public Builds getBuilds() {
        return builds;
    }

    public void setBuilds(Builds builds) {
        this.builds = builds;
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
