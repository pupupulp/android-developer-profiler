package com.fujiyama.pulp.developerprofiler.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CommitterContent implements Serializable {

    @SerializedName("login")
    String username;

    @SerializedName("avatar_url")
    String avatarUrl;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
