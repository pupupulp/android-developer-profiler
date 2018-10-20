package com.fujiyama.pulp.developerprofiler.model;

import android.widget.Toast;

import com.fujiyama.pulp.developerprofiler.config.DeveloperProfiler;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

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
    JSONObject filesInfo;

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

    public JSONObject getFilesInfo() {
        return filesInfo;
    }

    public void setFilesInfo(JSONObject filesInfo) {
        String stringFilesInfo = filesInfo.toString();
        int start = stringFilesInfo.lastIndexOf("{");
        int end = stringFilesInfo.indexOf("}");
        String trimmedFilesInfo = stringFilesInfo.substring(start, end);

        Toast.makeText(DeveloperProfiler.getInstance(), trimmedFilesInfo, Toast.LENGTH_LONG).show();

        Gson gson = new Gson();
        GistFileContent result = gson.fromJson(stringFilesInfo, GistFileContent.class);

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
