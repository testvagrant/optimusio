package com.testvagrant.rest.repositories;

import com.testvagrant.rest.models.Scenarios;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScenarioRepository extends MongoRepository<Scenarios,String> {

    Scenarios findByScenarioName(@Param("name") String scenarioName);

    List<Scenarios> findByBuildId(@Param("buildId")ObjectId buildId);

    Scenarios findByBuildIdAndScenarioName(@Param("buildId") ObjectId buildId, @Param("name") String scenarioName);
}
