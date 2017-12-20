package com.testvagrant.rest.responses;

public class BuildsResponse<T> {
    private T builds;
    private ErrorResponse error;
    private boolean success;

    public T getBuilds() {
        return builds;
    }

    public void setBuilds(T builds) {
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
