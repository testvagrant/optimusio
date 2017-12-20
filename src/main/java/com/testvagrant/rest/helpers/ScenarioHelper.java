package com.testvagrant.rest.helpers;

import com.testvagrant.rest.builders.ErrorResponseBuilder;
import com.testvagrant.rest.builders.ScenariosResponseBuilder;
import com.testvagrant.rest.models.Scenarios;
import com.testvagrant.rest.responses.ScenariosResponse;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ScenarioHelper {

    public ScenariosResponse createScenaioResponse(List<Scenarios> scenarios, String error, HttpServletResponse response) {
        ScenariosResponseBuilder scenariosResponseBuilder = new ScenariosResponseBuilder();
        ErrorResponseBuilder errorResponseBuilder = new ErrorResponseBuilder();
        if(scenarios.size()==0 || scenarios.get(0)==null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            errorResponseBuilder.withErrorMessage(error);
            scenariosResponseBuilder.withError(errorResponseBuilder.build());
            scenariosResponseBuilder.withSuccess(false);
        }
        scenariosResponseBuilder.withScenarios(scenarios)
                .withError(errorResponseBuilder.build());
        return scenariosResponseBuilder.build();
    }

    public ScenariosResponse createScenarioResponse(Scenarios scenario, String error, HttpServletResponse response) {
      List<Scenarios> scenarios = new ArrayList<>();
      scenarios.add(scenario);
      return createScenaioResponse(scenarios,error,response);
    }
}
