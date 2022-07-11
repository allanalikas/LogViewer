package com.projectpenguin.logviewer.features.DataSource.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectpenguin.logviewer.features.DataSource.model.DataSource;

@Repository
public interface DataSourceRepository extends JpaRepository<DataSource, Long> {
    List<DataSource> findByUsername(String username);
}
