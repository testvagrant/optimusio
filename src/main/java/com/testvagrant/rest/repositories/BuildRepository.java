package com.testvagrant.rest.repositories;

import com.testvagrant.rest.models.Builds;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;

public interface BuildRepository extends MongoRepository<Builds,String> {

    @RequestMapping(produces = "application/json")
    Builds findById(@Param("id") String id);

}
