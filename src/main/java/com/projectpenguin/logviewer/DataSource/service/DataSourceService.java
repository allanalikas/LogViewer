package com.projectpenguin.logviewer.DataSource.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectpenguin.logviewer.DataSource.model.DataSource;
import com.projectpenguin.logviewer.DataSource.repository.DataSourceRepository;

@Service
public class DataSourceService {

    @Autowired
    DataSourceRepository dataSourceRepository;

    public List<DataSource> getDataSources() {
        return dataSourceRepository.findAll();
    }

}
