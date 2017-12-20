package com.testvagrant.rest.builders;

import com.testvagrant.rest.responses.ErrorResponse;
import com.testvagrant.rest.responses.BuildsResponse;

public class BuildsResponseBuilder<T> {

    private BuildsResponse buildsResponse = new BuildsResponse();
    private T t;

    public BuildsResponseBuilder() {
        buildsResponse.setBuilds(t);
        buildsResponse.setError(new ErrorResponseBuilder().build());
        buildsResponse.setSuccess(true);
    }

    public BuildsResponseBuilder withBuilds(T builds) {
        buildsResponse.setBuilds(builds);
        return this;
    }

    public BuildsResponseBuilder withError(ErrorResponse error) {
        buildsResponse.setError(error);
        return this;
    }

    public BuildsResponseBuilder withSuccess(boolean success) {
        buildsResponse.setSuccess(success);
        return this;
    }

    public BuildsResponse build() {
        return buildsResponse;
    }
}
