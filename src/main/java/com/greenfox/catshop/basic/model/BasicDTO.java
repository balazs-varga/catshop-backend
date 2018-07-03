package com.greenfox.catshop.basic.model;

public class BasicDTO {
    private String basicInfo;
    private String serverStatus;
    private String databaseStatus;
    private String createdBy;

    public BasicDTO(String basicInfo, String serverStatus, String databaseStatus, String createdBy) {
        this.basicInfo = basicInfo;
        this.serverStatus = serverStatus;
        this.databaseStatus = databaseStatus;
        this.createdBy = createdBy;
    }

    public String getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(String basicInfo) {
        this.basicInfo = basicInfo;
    }

    public String getServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(String serverStatus) {
        this.serverStatus = serverStatus;
    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
