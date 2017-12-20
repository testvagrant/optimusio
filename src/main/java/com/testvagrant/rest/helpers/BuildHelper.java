package com.testvagrant.rest.helpers;

import com.testvagrant.rest.builders.ErrorResponseBuilder;
import com.testvagrant.rest.builders.BuildsResponseBuilder;
import com.testvagrant.rest.models.Builds;
import com.testvagrant.rest.responses.BuildsResponse;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BuildHelper {

    public BuildsResponse createBuildResponse(Builds builds, String errorMessage, HttpServletResponse response) {
        BuildsResponseBuilder buildsResponseBuilder = new BuildsResponseBuilder<Builds>();
        ErrorResponseBuilder errorResponseBuilder = new ErrorResponseBuilder();
        if(builds==null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            errorResponseBuilder.withErrorMessage(errorMessage);
            buildsResponseBuilder.withError(errorResponseBuilder.build());
            buildsResponseBuilder.withSuccess(false);
        }
        buildsResponseBuilder.withBuilds(builds)
                .withError(errorResponseBuilder.build());
        return buildsResponseBuilder.build();
    }

    public BuildsResponse createBuildsResponse(List<Builds> buildsList, String errorMessage, HttpServletResponse response) {
        BuildsResponseBuilder buildsResponseBuilder = new BuildsResponseBuilder<List<Builds>>();
        ErrorResponseBuilder errorResponseBuilder = new ErrorResponseBuilder();
        if(buildsList.size()==0) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            errorResponseBuilder.withErrorMessage(errorMessage);
            buildsResponseBuilder.withError(errorResponseBuilder.build());
            buildsResponseBuilder.withSuccess(false);
        }
        buildsResponseBuilder.withBuilds(buildsList)
                .withError(errorResponseBuilder.build());
        return buildsResponseBuilder.build();
    }
}
