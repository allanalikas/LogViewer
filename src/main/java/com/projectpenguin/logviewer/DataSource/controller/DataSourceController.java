package com.projectpenguin.logviewer.DataSource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectpenguin.logviewer.DataSource.controller.api.GetDataSourceResponse;
import com.projectpenguin.logviewer.DataSource.service.DataSourceService;
import com.projectpenguin.logviewer.general.errors.ErrorCode;
import com.projectpenguin.logviewer.general.exceptions.GeneralHttpException;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class DataSourceController {
    
    @Autowired
    DataSourceService dataSourceService;

    @RequestMapping(value="/datasources", method=RequestMethod.GET)
    public ResponseEntity<GetDataSourceResponse> getDataSources(@RequestParam String param) {
        try {
            // TODO: Auth and User specific checks

            // throw new GeneralHttpException( HttpStatus.UNAUTHORIZED, ErrorCode.AUTHENTICATION, "Request not authorized.")
            GetDataSourceResponse response = new GetDataSourceResponse(dataSourceService.getDataSources());
            return new ResponseEntity<>(response, HttpStatus.OK);
            // return ResponseEntity.ok().body( response );
        } catch ( GeneralHttpException exception ) {
            return exception.createErrorResponse();
        }
    }

    @RequestMapping(value = "/datasources", method=RequestMethod.POST)
    public void createDataSource(@RequestParam String param) {
        //TODO
    }

    @RequestMapping(value = "/datasources", method=RequestMethod.PUT)
    public void updateDataSource(@RequestParam String param) {
        //TODO
    }

    @RequestMapping(value = "/datasources", method=RequestMethod.DELETE)
    public void deleteDataSource(@RequestParam String param) {
        //TODO
    }
}
