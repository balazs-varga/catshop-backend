package com.greenfox.catshop.basic.model;

public class BasicDTO {
    private String basicInfo;
    private String serverStatus;
    private String databaseStatus;

    public BasicDTO(String basicInfo, String serverStatus, String databaseStatus) {
        this.basicInfo = basicInfo;
        this.serverStatus = serverStatus;
        this.databaseStatus = databaseStatus;
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
}
