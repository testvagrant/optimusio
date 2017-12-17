package com.testvagrant.rest.helpers.builds;

import com.testvagrant.rest.builders.ErrorResponseBuilder;
import com.testvagrant.rest.builders.devices.DevicesReponseBuilder;
import com.testvagrant.rest.models.Devices;
import com.testvagrant.rest.responses.devices.DevicesResponse;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DeviceHelper {

    public DevicesResponse createDeviceResponse(List<Devices> devices, String errorMessage, HttpServletResponse response) {
        DevicesReponseBuilder devicesReponseBuilder = new DevicesReponseBuilder();
        ErrorResponseBuilder errorResponseBuilder = new ErrorResponseBuilder();
        if(devices.size()==0) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            errorResponseBuilder.withErrorMessage(errorMessage);
            devicesReponseBuilder.withError(errorResponseBuilder.build());
            devicesReponseBuilder.withSuccess(false);
        }
        devicesReponseBuilder.withDevices(devices)
                .withError(errorResponseBuilder.build());
        return devicesReponseBuilder.build();
    }

    public DevicesResponse createDevicedResponse(Devices devices, String errorMessage, HttpServletResponse response) {
        DevicesReponseBuilder devicesReponseBuilder = new DevicesReponseBuilder();
        ErrorResponseBuilder errorResponseBuilder = new ErrorResponseBuilder();
        if(devices==null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            errorResponseBuilder.withErrorMessage(errorMessage);
            devicesReponseBuilder.withError(errorResponseBuilder.build());
            devicesReponseBuilder.withSuccess(false);
        }
        devicesReponseBuilder.withDevices(devices)
                .withError(errorResponseBuilder.build());
        return devicesReponseBuilder.build();
    }
}
