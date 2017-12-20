package com.testvagrant.rest.repositories;

import com.testvagrant.rest.models.Devices;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeviceRepository extends MongoRepository<Devices,String>{

    List<Devices> findAllById(@Param("id") String id);
    Devices findByBuildIdAndUdid(@Param("id") ObjectId id, @Param("udid") String udid);

    List<Devices> findAllByBuildId(@Param("id") ObjectId id);
}
