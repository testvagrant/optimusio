package com.testvagrant.rest.requests.builds;

public class Links {

    private Link self;
    private Link builds;

    public Link getSelf() {
        return self;
    }

    public void setSelf(Link self) {
        this.self = self;
    }

    public Link getBuilds() {
        return builds;
    }

    public void setBuilds(Link builds) {
        this.builds = builds;
    }
}
