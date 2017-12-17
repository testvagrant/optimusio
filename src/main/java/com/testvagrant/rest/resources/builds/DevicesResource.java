package com.testvagrant.rest.resources.builds;

import com.testvagrant.rest.helpers.builds.DeviceHelper;
import com.testvagrant.rest.models.Devices;
import com.testvagrant.rest.repositories.DeviceRepository;
import com.testvagrant.rest.responses.devices.DevicesResponse;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/devices")
public class DevicesResource {

    private DeviceRepository deviceRepository;
    private MongoTemplate mongoTemplate;
    private DeviceHelper deviceHelper = new DeviceHelper();

    public DevicesResource(DeviceRepository deviceRepository, MongoTemplate mongoTemplate) {
        this.deviceRepository = deviceRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @PostMapping("/{id}")
    public DevicesResponse storeDevices(@PathVariable String id, @RequestBody List<Devices> devicesList, HttpServletResponse response) {
        devicesList.forEach(devices -> devices.setBuildId(new ObjectId(id)));
        List<Devices> save = deviceRepository.save(devicesList);
        return deviceHelper.createDeviceResponse(save,"Cannot save devices", response);
    }

    @PutMapping("/{id}/screenshot")
    public Devices storeScreenshot(@PathVariable ObjectId id, @RequestBody Devices devices, HttpServletResponse response) {
        Query query = new Query();
        query.addCriteria(Criteria.where("udid").is(devices.getUdid()).and("buildId").is(id));
        return mongoTemplate.findAndModify(query, Update.update("screenshot",devices.getScreenshot()),Devices.class);
    }

    @PutMapping("/{id}/{udid}/releaseDevice")
    public Devices releaseDevice(@PathVariable ObjectId id, @PathVariable String udid, HttpServletResponse response) {
        Query query = new Query();
        query.addCriteria(Criteria.where("udid").is(udid).and("buildId").is(id));
        return mongoTemplate.findAndModify(query, Update.update("status","Available"),Devices.class);
    }

    @PutMapping("/{id}/engageDevice")
    public DevicesResponse engageDevice(@PathVariable ObjectId id, @RequestBody Devices devices, HttpServletResponse response) {
        Query query = getDeviceQuery(devices);
        query.addCriteria(Criteria.where("buildId").is(id).and("status").is("Available"));
        Devices engagedDevice = mongoTemplate.findAndModify(query, Update.update("status","Engaged"),Devices.class);
        return deviceHelper.createDevicedResponse(engagedDevice, "No devices found matching criteria to Engage", response);
    }


    private Query getDeviceQuery(Devices devices) {
        Query query = new Query();
        if(!StringUtils.isEmpty(devices.getUdid())) {
            query.addCriteria(Criteria.where("udid").is(devices.getUdid()));
            return query;
        }
        if(!StringUtils.isEmpty(devices.getPlatform())) {
            query.addCriteria(Criteria.where("platform").is(devices.getPlatform()));
        }
        if(!StringUtils.isEmpty(devices.getDeviceName())) {
            query.addCriteria(Criteria.where("deviceName").is(devices.getDeviceName()));
        }

        if(!StringUtils.isEmpty(devices.getDeviceType())) {
            query.addCriteria(Criteria.where("deviceType").is(devices.getDeviceType()));
        }

        if(!StringUtils.isEmpty(devices.getOsVersion())) {
            query.addCriteria(Criteria.where("osVersion").is(devices.getOsVersion()));
        }
        return query;
    }
}
