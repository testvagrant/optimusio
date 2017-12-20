package com.testvagrant.rest.builders;

import com.testvagrant.rest.responses.ErrorResponse;
import com.testvagrant.rest.responses.DevicesResponse;

import java.util.ArrayList;

public class DevicesReponseBuilder<T> {
    private DevicesResponse devicesResponse = new DevicesResponse();

    public DevicesReponseBuilder() {
        devicesResponse.setDevices(new ArrayList<>());
        devicesResponse.setError(new ErrorResponseBuilder().build());
        devicesResponse.setSuccess(true);
    }

    public DevicesReponseBuilder withDevices(T devices) {
        devicesResponse.setDevices(devices);
        return this;
    }

    public DevicesReponseBuilder withError(ErrorResponse error) {
        devicesResponse.setError(error);
        return this;
    }

    public DevicesReponseBuilder withSuccess(boolean success) {
        devicesResponse.setSuccess(success);
        return this;
    }

    public DevicesResponse build() {
        return devicesResponse;
    }


}
