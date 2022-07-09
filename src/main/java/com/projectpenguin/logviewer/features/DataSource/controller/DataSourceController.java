package com.projectpenguin.logviewer.features.DataSource.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.unix4j.Unix4j;
import org.unix4j.line.Line;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.projectpenguin.logviewer.features.DataSource.controller.api.CreateDataSourceRequest;
import com.projectpenguin.logviewer.features.DataSource.controller.api.GetDataSourceResponse;
import com.projectpenguin.logviewer.features.DataSource.logic.DataSourceLogic;
import com.projectpenguin.logviewer.features.DataSource.model.DataSource;
import com.projectpenguin.logviewer.features.DataSource.service.DataSourceService;
import com.projectpenguin.logviewer.general.errors.ErrorCode;
import com.projectpenguin.logviewer.general.exceptions.GeneralHttpException;

@RestController
@RequestMapping("/api")
public class DataSourceController {

    @Autowired
    DataSourceService dataSourceService;

    @GetMapping(value = "/datasources")
    public ResponseEntity getDataSources(@RequestBody CreateDataSourceRequest request) {
        try {
            // TODO: Auth and User specific checks
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (StringUtils.isBlank(auth.getName())) {
                throw new GeneralHttpException(HttpStatus.UNAUTHORIZED, ErrorCode.AUTHENTICATION,
                        "Request not authorized.");
            }

            GetDataSourceResponse response = new GetDataSourceResponse(dataSourceService.getDataSources());
            return ResponseEntity.ok().body(response);

        } catch (GeneralHttpException exception) {
            return exception.createErrorResponse();
        }
    }

    @GetMapping(value = "/datasource")
    public ResponseEntity getDataSource(@RequestParam String filePath, @RequestParam String searchCommand) {
        try {
            // TODO: Auth and User specific checks
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (StringUtils.isBlank(auth.getName())) {
                throw new GeneralHttpException(HttpStatus.UNAUTHORIZED, ErrorCode.AUTHENTICATION,
                        "Request not authorized.");
            }

            List<Line> result = new ArrayList<>();

            try {
                File file = new File(filePath);
                result = Unix4j.grep(searchCommand, file).toLineList();
            } catch (Exception e) {
                throw new GeneralHttpException(HttpStatus.BAD_REQUEST, ErrorCode.INVALID,
                        "Bad Request.");
            }

            return ResponseEntity.ok().body(result);
        } catch (GeneralHttpException exception) {
            return exception.createErrorResponse();
        }
    }

    @PostMapping(value = "/datasources")
    public ResponseEntity createDataSource(@RequestBody CreateDataSourceRequest request) {
        try {

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (StringUtils.isBlank(auth.getName())) {
                throw new GeneralHttpException(HttpStatus.UNAUTHORIZED, ErrorCode.AUTHENTICATION,
                        "Request not authorized.");
            }

            dataSourceService.saveDataSource(DataSourceLogic.createNewDataSource(request, auth));

            return ResponseEntity.ok().build();

        } catch (GeneralHttpException exception) {
            return exception.createErrorResponse();
        }
    }

    @PutMapping(value = "/datasources")
    public void updateDataSource(@RequestParam String param) {
        // TODO
    }

    @DeleteMapping(value = "/datasources")
    public void deleteDataSource(@RequestParam String param) {
        // TODO
    }

    @GetMapping(value = "/testsource")
    public String getTestDataSources() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        return "testsecurity " + name;
    }
}
