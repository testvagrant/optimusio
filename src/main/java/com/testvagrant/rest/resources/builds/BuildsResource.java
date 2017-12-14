package com.testvagrant.rest.resources.builds;

import com.testvagrant.rest.helpers.builds.BuildHelper;
import com.testvagrant.rest.models.Builds;
import com.testvagrant.rest.repositories.BuildRepository;
import com.testvagrant.rest.responses.builds.BuildsResponse;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/builds")
public class BuildsResource {

    private BuildRepository buildRepository;
    private MongoTemplate mongoTemplate;
    private BuildHelper buildHelper = new BuildHelper();

    public BuildsResource(BuildRepository buildRepository, MongoTemplate mongoTemplate) {
        this.buildRepository = buildRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping()
    public BuildsResponse getAllBuilds(HttpServletResponse response) {
        List<Builds> builds = buildRepository.findAll();
        return buildHelper.createBuildsResponse(builds,"Cannot find any builds", response);
    }

    @PostMapping("/create")
    public BuildsResponse createBuild(@RequestBody Builds builds, HttpServletResponse response) {
        Builds buildsDetails = buildRepository.save(builds);
        return buildHelper.createBuildResponse(buildsDetails,"Cannot create a new build", response);
    }
    @GetMapping("/{id}")
    public BuildsResponse getBuildById(@PathVariable String id, HttpServletResponse response) {
        Builds builds = buildRepository.findById(id);
        return buildHelper.createBuildResponse(builds, String.format("Cannot find a document with buildId %s",id), response);
    }

    @GetMapping("/latestBuild")
    public BuildsResponse getLatestBuild(HttpServletResponse response) {
        List<Builds> allBuildsByIdAsc = buildRepository.findAllBuildsByOrderByBuildStartTimeDesc();
        return buildHelper.createBuildResponse(allBuildsByIdAsc.get(0),"cannot find a build", response);
    }

    @PutMapping("/{id}")
    public BuildsResponse updateLatestBuild(@PathVariable String id, @RequestBody Builds buildEndTime, HttpServletResponse response) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Builds buildRecord = mongoTemplate.findAndModify(query, Update.update("buildEndTime", buildEndTime.getBuildEndTime()), Builds.class);
        return buildHelper.createBuildResponse(buildRecord,"cannot update build",response);
    }

    @DeleteMapping("/{id}")
    public String deleteBuild(@PathVariable String id,HttpServletResponse response) {
        buildRepository.delete(id);
        return "Ok";
    }

}
