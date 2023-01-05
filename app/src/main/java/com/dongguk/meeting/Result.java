package com.dongguk.meeting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Result {

    @SerializedName("count")
    @Expose
    private Integer count;

    @SerializedName("station")
    @Expose
    private List<Station> station = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Station> getStation() {
        return station;
    }

    public void setStation(List<Station> station) {
        this.station = station;
    }
}
