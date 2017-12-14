package com.testvagrant.rest.builders.builds;

import com.testvagrant.rest.builders.ErrorResponseBuilder;
import com.testvagrant.rest.models.Builds;
import com.testvagrant.rest.resources.ErrorResponse;
import com.testvagrant.rest.responses.builds.BuildResponse;

public class BuildResponseBuilder {

    private BuildResponse buildResponse = new BuildResponse();

    public BuildResponseBuilder() {
        buildResponse.setBuilds(new Builds());
        buildResponse.setError(new ErrorResponseBuilder().build());
        buildResponse.setSuccess(true);
    }

    public BuildResponseBuilder withBuilds(Builds builds) {
        buildResponse.setBuilds(builds);
        return this;
    }

    public BuildResponseBuilder withError(ErrorResponse error) {
        buildResponse.setError(error);
        return this;
    }

    public BuildResponseBuilder withSuccess(boolean success) {
        buildResponse.setSuccess(success);
        return this;
    }

    public BuildResponse build() {
        return buildResponse;
    }
}
