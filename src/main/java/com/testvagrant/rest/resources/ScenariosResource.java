package com.testvagrant.rest.resources;

import com.testvagrant.rest.helpers.ScenarioHelper;
import com.testvagrant.rest.models.Scenarios;
import com.testvagrant.rest.repositories.ScenarioRepository;
import com.testvagrant.rest.responses.ScenariosResponse;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/scenarios")
public class ScenariosResource {

    private ScenarioRepository scenarioRepository;
    private MongoTemplate mongoTemplate;
    private GridFsOperations gridFsOperations;
    private ScenarioHelper scenarioHelper = new ScenarioHelper();

    public ScenariosResource(ScenarioRepository scenarioRepository, MongoTemplate mongoTemplate, GridFsOperations operations) {
        this.scenarioRepository = scenarioRepository;
        this.mongoTemplate = mongoTemplate;
        this.gridFsOperations = operations;
    }

    @RequestMapping("/create/{id}")
    public ScenariosResponse createNewScenario(@PathVariable ObjectId id, @RequestBody Scenarios scenarios, HttpServletResponse response) {
        scenarios.setBuildId(id);
        Scenarios savedScenario = scenarioRepository.save(scenarios);
        return scenarioHelper.createScenarioResponse(savedScenario,"Scenario cannot be saved", response);
    }

    @PutMapping("/update/scenarioCompletion/{id}")
    public ScenariosResponse updateScenarioCompletion(@PathVariable ObjectId id, @RequestBody Scenarios scenarios, HttpServletResponse response) {
        Query query = getUniqueScenarioQuery(id, scenarios);
        Scenarios scenarioToUpdate = scenarioRepository.findByBuildIdAndScenarioName(id,scenarios.getScenarioName());
        Update update = getScenarioCompletionUpdate(scenarioToUpdate,scenarios);
        Scenarios updatedScenario = mongoTemplate.findAndModify(query, update,Scenarios.class);
        return scenarioHelper.createScenarioResponse(scenarioToUpdate,"Cannot complete scenario", response);
    }

    @PutMapping("/update/executionDetails/{id}")
    public ScenariosResponse updateExecutionDetails(@PathVariable ObjectId id, @RequestBody Scenarios scenarios, HttpServletResponse response) {
        Query query = getUniqueScenarioQuery(id, scenarios);
        Update update = getExecutionDetailsUpdate(scenarios);
        Scenarios updatedScenario = mongoTemplate.findAndModify(query, update,Scenarios.class);
        return scenarioHelper.createScenarioResponse(updatedScenario,"Cannot update execution details", response);
    }


    @PostMapping("/update/scenarioScreenshots/{id}/{scenarioName}/{interval}")
    public String getFileNameForScenarioTimeline(@PathVariable ObjectId id, @PathVariable String scenarioName, @PathVariable int interval, @RequestBody byte[] screenshotData, HttpServletResponse response) {
        String fileName = scenarioRepository.findByBuildIdAndScenarioName(id,scenarioName).getId()+"_"+interval;
        InputStream inputStream = new ByteArrayInputStream(screenshotData);
        gridFsOperations.store(inputStream,fileName);
        return fileName;
    }

    @PutMapping("/update/scenarioTimeline/{id}/{scenarioName}")
    public ScenariosResponse updateScenarioTimeline(@PathVariable ObjectId id, @PathVariable String scenarioName, @RequestBody String scenarioTimeline, HttpServletResponse response) {
        Query query = getUniqueScenarioQuery(id,scenarioName);
        Scenarios scenario = mongoTemplate.findAndModify(query, Update.update("scenarioTimeline", scenarioTimeline), Scenarios.class);
        return scenarioHelper.createScenarioResponse(scenario,"Cannot update scenario timeline", response);
    }

    @GetMapping("/{id}/{scenarioName}")
    public ScenariosResponse getScenario(@PathVariable ObjectId id, @PathVariable String scenarioName, HttpServletResponse servletResponse) {
        List<Scenarios> byBuildIdAndScenarioName = scenarioRepository.findAllByBuildIdAndScenarioName(id, scenarioName);
        return scenarioHelper.createScenarioResponse(byBuildIdAndScenarioName,"Cannot find scenario with name "+scenarioName, servletResponse);
    }

    private Query getUniqueScenarioQuery(@PathVariable ObjectId id, @RequestBody Scenarios scenarios) {
        Query query = new Query();
        query.addCriteria(Criteria.where("buildId").is(id).and("scenarioName").is(scenarios.getScenarioName()));
        return query;
    }

    private Query getUniqueScenarioQuery(@PathVariable ObjectId id, @RequestBody String scenarioName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("buildId").is(id).and("scenarioName").is(scenarioName));
        return query;
    }

    private Update getScenarioCompletionUpdate(Scenarios scenarioToUpdate, Scenarios scenarios) {
        Date startTime = scenarioToUpdate.getStartTime();
        Date endTime = new Date();
        long seconds = (endTime.getTime() - startTime.getTime()) / 1000;
        return Update.update("status",scenarios.getStatus())
                .set("completed",scenarios.getCompleted())
                .set("endTime",endTime)
                .set("timeTaken",Math.toIntExact(seconds));
    }

    private Update getExecutionDetailsUpdate(Scenarios scenarios) {
        return Update.update("steps",scenarios.getSteps())
                .set("failedOnScreen",scenarios.getFailedOnScreen());
    }

}
