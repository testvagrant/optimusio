package com.testvagrant.rest.endpoints;

public interface BuildsEndPoints extends BaseEndPoint {
    String BUILDS = BASE_URL+"/builds";
    String FIND_BY_BUILDID = BASE_URL+"/builds/{buildId}";
}
