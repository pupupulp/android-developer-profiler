package com.fujiyama.pulp.developerprofiler.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CommitContent implements Serializable {
    @SerializedName("message")
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
