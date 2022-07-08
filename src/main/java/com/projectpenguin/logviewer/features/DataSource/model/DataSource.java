package com.projectpenguin.logviewer.features.DataSource.model;

import java.sql.Date;

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
    private long id;

    @Column(name = "filePath")
    private String filePath;

    @Column(name = "description")
    private String description;

    @Column(name = "isActive")
    private boolean isActive;

    @Column(name = "dateAdded")
    private Date dateAdded;

    @Column(name = "dateModified")
    private Date dateModified;

    @Column(name = "dateRemoved")
    private Date dateRemoved;

    public DataSource() {
    }

    public DataSource(long id, String filePath, String description, boolean isActive, Date dateAdded, Date dateModified,
            Date dateRemoved) {
        this.id = id;
        this.filePath = filePath;
        this.description = description;
        this.isActive = isActive;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
        this.dateRemoved = dateRemoved;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
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

    public Date getDateAdded() {
        return this.dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateModified() {
        return this.dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Date getDateRemoved() {
        return this.dateRemoved;
    }

    public void setDateRemoved(Date dateRemoved) {
        this.dateRemoved = dateRemoved;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", filePath='" + getFilePath() + "'" +
                ", description='" + getDescription() + "'" +
                ", isActive='" + isIsActive() + "'" +
                ", dateAdded='" + getDateAdded() + "'" +
                ", dateModified='" + getDateModified() + "'" +
                ", dateRemoved='" + getDateRemoved() + "'" +
                "}";
    }

}
