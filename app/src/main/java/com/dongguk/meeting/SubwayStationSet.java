package com.dongguk.meeting;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubwayStationSet {

    @SerializedName("stations")
    @Expose
    private List<SubwayStation> stations = null;

    public List<SubwayStation> getStations() {
        return stations;
    }

    public void setStations(List<SubwayStation> stations) {
        this.stations = stations;
    }

}