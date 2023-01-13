package com.dongguk.meeting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExChangeInfo {

    @SerializedName("laneName")
    @Expose
    private String laneName;
    @SerializedName("startName")
    @Expose
    private String startName;
    @SerializedName("exName")
    @Expose
    private String exName;
    @SerializedName("exSID")
    @Expose
    private Integer exSID;
    @SerializedName("fastTrain")
    @Expose
    private Integer fastTrain;
    @SerializedName("fastDoor")
    @Expose
    private Integer fastDoor;
    @SerializedName("exWalkTime")
    @Expose
    private Integer exWalkTime;

    public String getLaneName() {
        return laneName;
    }

    public void setLaneName(String laneName) {
        this.laneName = laneName;
    }

    public String getStartName() {
        return startName;
    }

    public void setStartName(String startName) {
        this.startName = startName;
    }

    public String getExName() {
        return exName;
    }

    public void setExName(String exName) {
        this.exName = exName;
    }

    public Integer getExSID() {
        return exSID;
    }

    public void setExSID(Integer exSID) {
        this.exSID = exSID;
    }

    public Integer getFastTrain() {
        return fastTrain;
    }

    public void setFastTrain(Integer fastTrain) {
        this.fastTrain = fastTrain;
    }

    public Integer getFastDoor() {
        return fastDoor;
    }

    public void setFastDoor(Integer fastDoor) {
        this.fastDoor = fastDoor;
    }

    public Integer getExWalkTime() {
        return exWalkTime;
    }

    public void setExWalkTime(Integer exWalkTime) {
        this.exWalkTime = exWalkTime;
    }

}