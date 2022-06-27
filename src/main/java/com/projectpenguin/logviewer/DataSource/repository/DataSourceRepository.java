package com.projectpenguin.logviewer.DataSource.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectpenguin.logviewer.DataSource.model.DataSource;

@Repository
public interface DataSourceRepository extends JpaRepository<DataSource, Long> {
}
