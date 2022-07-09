package com.projectpenguin.logviewer.features.DataSource.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectpenguin.logviewer.features.DataSource.model.DataSource;
import com.projectpenguin.logviewer.features.DataSource.repository.DataSourceRepository;

@Service
public class DataSourceService {

    @Autowired
    DataSourceRepository dataSourceRepository;

    public List<DataSource> getDataSources() {
        return dataSourceRepository.findAll();
    }

    public DataSource saveDataSource( DataSource dataSource ) {
        return dataSourceRepository.save( dataSource );
    }

}
