package com.testvagrant.rest.repositories;

import com.testvagrant.rest.models.Devices;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface DeviceRepository extends MongoRepository<Devices,String>{

    Devices findByIdAndUdid(@Param("id") String id, @Param("udid") String udid);
}
