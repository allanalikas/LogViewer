package com.projectpenguin.logviewer.DataSource.controller.api;

import java.util.List;

import com.projectpenguin.logviewer.DataSource.model.DataSource;

public class GetDataSourceResponse {

    private List<DataSource> dataSources;

    public GetDataSourceResponse(List<DataSource> dataSources) {
        this.dataSources = dataSources;
    }

    public List<DataSource> getDataSources() {
        return this.dataSources;
    }

    public void setDataSources(List<DataSource> dataSources) {
        this.dataSources = dataSources;
    }

    
}
