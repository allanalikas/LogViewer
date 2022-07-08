package com.projectpenguin.logviewer.features.DataSource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectpenguin.logviewer.features.DataSource.model.DataSource;

@Repository
public interface DataSourceRepository extends JpaRepository<DataSource, Long> {
}
