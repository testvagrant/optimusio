package com.testvagrant.rest.resources;

import com.testvagrant.rest.models.Builds;
import com.testvagrant.rest.repositories.BuildRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/optimus/api")
public class BuildsResource {

    private BuildRepository buildRepository;
    private MongoTemplate mongoTemplate;

    public BuildsResource(BuildRepository buildRepository, MongoTemplate mongoTemplate) {
        this.buildRepository = buildRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @RequestMapping("/builds")
    public List<Builds> getAllBuilds() {
        return buildRepository.findAll();
    }

    @RequestMapping("/builds/{id}")
    public Builds getBuildById(@PathVariable String id) {
        return buildRepository.findById(id);
    }

}
