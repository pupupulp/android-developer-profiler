package com.fujiyama.pulp.developerprofiler.rest.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Commit implements Serializable {

    @SerializedName("url")
    String url;

    @SerializedName("commit")
    CommitInfo commitInfo;

    @SerializedName("committer")
    CommitterInfo committerInfo;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CommitInfo getCommitInfo() {
        return commitInfo;
    }

    public void setCommitInfo(CommitInfo commitInfo) {
        this.commitInfo = commitInfo;
    }

    public CommitterInfo getCommitterInfo() {
        return committerInfo;
    }

    public void setCommitterInfo(CommitterInfo committerInfo) {
        this.committerInfo = committerInfo;
    }

    public class CommitInfo implements Serializable {
        @SerializedName("message")
        String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public class CommitterInfo implements Serializable {
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
}
