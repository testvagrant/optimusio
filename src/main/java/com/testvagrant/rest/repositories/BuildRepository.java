package com.testvagrant.rest.repositories;

import com.testvagrant.rest.models.Builds;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BuildRepository extends MongoRepository<Builds,String> {


    Builds findById(@Param("id") String id);

    List<Builds> findAllBuildsByOrderByBuildStartTimeAsc();

    List<Builds> findAllBuildsByOrderByBuildStartTimeDesc();

}
