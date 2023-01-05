package com.dongguk.meeting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class data_model {

    @SerializedName("result")
    @Expose
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}