package com.projectpenguin.logviewer.DataSource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping(value="/datasources")
    public ResponseEntity getDataSources(@RequestParam String param) {
        try {
            // TODO: Auth and User specific checks

            throw new GeneralHttpException( HttpStatus.UNAUTHORIZED, ErrorCode.AUTHENTICATION, "Request not authorized.");
            //GetDataSourceResponse response = new GetDataSourceResponse(dataSourceService.getDataSources());
            //return new ResponseEntity<>(response, HttpStatus.OK);
            // return ResponseEntity.ok().body( response );
        } catch ( GeneralHttpException exception ) {
            return exception.createErrorResponse();
        }
    }

    @GetMapping(value="/testsource")
    public String getTestDataSources() {
        return "testsecurity";
    }

    @PostMapping(value = "/datasources")
    public void createDataSource(@RequestParam String param) {
        //TODO
    }

    @PutMapping(value = "/datasources")
    public void updateDataSource(@RequestParam String param) {
        //TODO
    }

    @DeleteMapping(value = "/datasources")
    public void deleteDataSource(@RequestParam String param) {
        //TODO
    }
}
