package com.dongguk.meeting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubwayResultSet {

    @SerializedName("result")
    @Expose
    private SubwayResult result;

    public SubwayResult getResult() {
        return result;
    }

    public void setResult(SubwayResult result) {
        this.result = result;
    }

}