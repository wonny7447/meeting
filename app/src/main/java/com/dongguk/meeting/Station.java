package com.dongguk.meeting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Station {

    @SerializedName("nonstopStation")
    @Expose
    private Integer nonstopStation;

    @SerializedName("stationClass")
    @Expose
    private Integer stationClass;

    @SerializedName("stationName")
    @Expose
    private String stationName;

    @SerializedName("stationID")
    @Expose
    private Integer stationID;

    @SerializedName("x")
    @Expose
    private Double x;

    @SerializedName("y")
    @Expose
    private Double y;

    @SerializedName("arsID")
    @Expose
    private String arsID;

    @SerializedName("type")
    @Expose
    private Integer type;

    @SerializedName("laneName")
    @Expose
    private String laneName;

    @SerializedName("laneCity")
    @Expose
    private String laneCity;

    @SerializedName("ebid")
    @Expose
    private String ebid;

    public Integer getNonstopStation() {
        return nonstopStation;
    }

    public void setNonstopStation(Integer nonstopStation) {
        this.nonstopStation = nonstopStation;
    }

    public Integer getStationClass() {
        return stationClass;
    }

    public void setStationClass(Integer stationClass) {
        this.stationClass = stationClass;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getStationID() {
        return stationID;
    }

    public void setStationID(Integer stationID) {
        this.stationID = stationID;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public String getArsID() {
        return arsID;
    }

    public void setArsID(String arsID) {
        this.arsID = arsID;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLaneName() {
        return laneName;
    }

    public void setLaneName(String laneName) {
        this.laneName = laneName;
    }

    public String getLaneCity() {
        return laneCity;
    }

    public void setLaneCity(String laneCity) {
        this.laneCity = laneCity;
    }

    public String getEbid() {
        return ebid;
    }

    public void setEbid(String ebid) {
        this.ebid = ebid;
    }
}
