package com.fujiyama.pulp.developerprofiler.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Timestamp;

public class Gist implements Serializable {

    @SerializedName("id")
    String id;

    @SerializedName("html_url")
    String url;

    @SerializedName("created_at")
    Timestamp createdAt;

    @SerializedName("updated_at")
    Timestamp updatedAt;

    @SerializedName("description")
    String description;

    @SerializedName("files")
    String filesInfo;

    GistFileContent gistFileContent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilesInfo() {
        return filesInfo;
    }

    public void setFilesInfo(String filesInfo) {
        int start = filesInfo.lastIndexOf("{");
        int end = filesInfo.indexOf("}");
        String trimmedFilesInfo = filesInfo.substring(start, end);

        Gson gson = new Gson();
        GistFileContent result = gson.fromJson(filesInfo, GistFileContent.class);

        setGistFileContent(result);

        this.filesInfo = filesInfo;
    }

    public GistFileContent getGistFileContent() {
        return gistFileContent;
    }

    public void setGistFileContent(GistFileContent gistFileContent) {
        this.gistFileContent = gistFileContent;
    }
}
