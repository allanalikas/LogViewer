package com.projectpenguin.logviewer.DataSource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectpenguin.logviewer.DataSource.model.DataSource;
import com.projectpenguin.logviewer.DataSource.service.DataSourceService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class DataSourceController {
    
    @Autowired
    DataSourceService dataSourceService;

    @RequestMapping(value="/datasources", method=RequestMethod.GET)
    public List<DataSource> getDataSources(@RequestParam String param) {
        return dataSourceService.getDataSources();
    }
}
