package com.testvagrant.rest.config;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

public class GridFsConfiguration extends AbstractMongoConfiguration {

    @Bean
    public GridFsTemplate gridFsTemplate() throws Exception {
        return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
    }

    @Override
    protected String getDatabaseName() {
        return "optimus";
    }

    @Override
    public Mongo mongo() throws Exception {
        return null;
    }
}
