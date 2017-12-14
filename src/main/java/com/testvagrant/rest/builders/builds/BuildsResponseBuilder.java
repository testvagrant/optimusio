package com.testvagrant.rest.builders.builds;

import com.testvagrant.rest.builders.ErrorResponseBuilder;
import com.testvagrant.rest.resources.ErrorResponse;
import com.testvagrant.rest.responses.builds.BuildsResponse;

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
