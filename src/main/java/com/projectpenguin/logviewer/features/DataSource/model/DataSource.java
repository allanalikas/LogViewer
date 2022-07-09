package com.projectpenguin.logviewer.features.DataSource.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "datasources")
public class DataSource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "username")
    private String username;

    @Column(name = "filePath")
    private String filePath;

    @Column(name = "description")
    private String description;

    @Column(name = "isActive")
    private boolean isActive;

    @Column(name = "dateAdded")
    private LocalDateTime dateAdded;

    @Column(name = "dateModified")
    private LocalDateTime dateModified;

    @Column(name = "dateRemoved")
    private LocalDateTime dateRemoved;

    public DataSource() {
    }

    public DataSource(UUID id, String username, String filePath, String description, boolean isActive, LocalDateTime localDateTime, LocalDateTime localDateTime2,
        LocalDateTime dateRemoved) {
        this.id = id;
        this.username = username;
        this.filePath = filePath;
        this.description = description;
        this.isActive = isActive;
        this.dateAdded = localDateTime;
        this.dateModified = localDateTime2;
        this.dateRemoved = dateRemoved;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsActive() {
        return this.isActive;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getDateAdded() {
        return this.dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public LocalDateTime getDateModified() {
        return this.dateModified;
    }

    public void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public LocalDateTime getDateRemoved() {
        return this.dateRemoved;
    }

    public void setDateRemoved(LocalDateTime dateRemoved) {
        this.dateRemoved = dateRemoved;
    }


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", filePath='" + getFilePath() + "'" +
            ", description='" + getDescription() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", dateAdded='" + getDateAdded() + "'" +
            ", dateModified='" + getDateModified() + "'" +
            ", dateRemoved='" + getDateRemoved() + "'" +
            "}";
    }    

}
