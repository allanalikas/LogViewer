package com.projectpenguin.logviewer.features.DataSource.logic;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.core.Authentication;

import com.projectpenguin.logviewer.features.DataSource.controller.api.CreateDataSourceRequest;
import com.projectpenguin.logviewer.features.DataSource.model.DataSource;

public class DataSourceLogic {
    public static DataSource createNewDataSource(CreateDataSourceRequest request, Authentication auth) {
        return new DataSource(UUID.randomUUID(), auth.getName(), request.getFilePath(), "", true, LocalDateTime.now(), LocalDateTime.now(), null);
    }
}
