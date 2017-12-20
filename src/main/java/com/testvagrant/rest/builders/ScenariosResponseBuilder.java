package com.testvagrant.rest.builders;

import com.testvagrant.rest.models.Scenarios;
import com.testvagrant.rest.responses.ErrorResponse;
import com.testvagrant.rest.responses.ScenariosResponse;

import java.util.ArrayList;
import java.util.List;

public class ScenariosResponseBuilder {

    private ScenariosResponse scenariosResponse = new ScenariosResponse();

    public ScenariosResponseBuilder() {
        scenariosResponse.setScenarios(new ArrayList<>());
        scenariosResponse.setError(new ErrorResponseBuilder().build());
        scenariosResponse.setSuccess(true);
    }

    public ScenariosResponseBuilder withScenarios(List<Scenarios> scenarios) {
        scenariosResponse.setScenarios(scenarios);
        return this;
    }

    public ScenariosResponseBuilder withError(ErrorResponse error) {
        scenariosResponse.setError(error);
        return this;
    }

    public ScenariosResponseBuilder withSuccess(boolean success) {
        scenariosResponse.setSuccess(success);
        return this;
    }

    public ScenariosResponse build() {
        return scenariosResponse;
    }
}
