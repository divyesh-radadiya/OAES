package com.example.item_service.entity;

import com.fasterxml.jackson.annotation.JsonRawValue;
import org.json.JSONObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Entity
public  class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int itemId;
    private int versionId;
    private int courseId;
    private String topicName;
    private String category;
    @JsonRawValue
    private String itemDescription;
    private String deficultyLevel;
    private int createdBy;
    private int modifiedBy;
    private boolean isActive;



    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getDeficultyLevel() {
        return deficultyLevel;
    }

    public void setDeficultyLevel(String deficultyLevel) {
        this.deficultyLevel = deficultyLevel;
    }


    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


}
