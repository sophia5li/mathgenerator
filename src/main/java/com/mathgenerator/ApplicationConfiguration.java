package com.mathgenerator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Map;

public class ApplicationConfiguration extends Configuration {

    @NotNull
    private Map<String, Map<String,String>> viewRendererConfiguration = Collections.emptyMap();

    private String name;

    @JsonProperty("viewRendererConfiguration")
    public Map<String, Map<String,String>> getViewRendererConfiguration(){
        return viewRendererConfiguration;
    }

    @JsonProperty("projectName")
    public String getName(){
        return name;
    }

    private DataSourceFactory database = new DataSourceFactory();

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory(){
        return database;
    }

    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory database){
        this.database = database;
    }
}
