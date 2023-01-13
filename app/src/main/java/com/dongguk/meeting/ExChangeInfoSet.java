package com.dongguk.meeting;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExChangeInfoSet {

    @SerializedName("exChangeInfo")
    @Expose
    private List<ExChangeInfo> exChangeInfo = null;

    public List<ExChangeInfo> getExChangeInfo() {
        return exChangeInfo;
    }

    public void setExChangeInfo(List<ExChangeInfo> exChangeInfo) {
        this.exChangeInfo = exChangeInfo;
    }

}