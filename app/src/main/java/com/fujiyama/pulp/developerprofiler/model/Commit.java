package com.fujiyama.pulp.developerprofiler.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Commit implements Serializable {

    @SerializedName("url")
    String url;

    @SerializedName("commit")
    String commitInfo;

    @SerializedName("committer")
    String committerInfo;

    CommitContent commitContent;
    CommitterContent committerContent;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getCommitInfo() {
        return commitInfo;
    }

    public void setCommitInfo(String commitInfo) {
        Gson gson = new Gson();
        CommitContent result = gson.fromJson(commitInfo, CommitContent.class);

        setCommitContent(result);

        this.commitInfo = commitInfo;
    }

    public String getCommitterInfo() {
        return committerInfo;
    }

    public void setCommitterInfo(String committerInfo) {
        Gson gson = new Gson();
        CommitterContent result = gson.fromJson(committerInfo, CommitterContent.class);

        setCommitterContent(result);

        this.committerInfo = committerInfo;
    }

    public CommitContent getCommitContent() {
        return commitContent;
    }

    public void setCommitContent(CommitContent commitContent) {
        this.commitContent = commitContent;
    }

    public CommitterContent getCommitterContent() {
        return committerContent;
    }

    public void setCommitterContent(CommitterContent committerContent) {
        this.committerContent = committerContent;
    }
}
