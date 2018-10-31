package com.fujiyama.pulp.developerprofiler.rest.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigInteger;
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
    GistFileInfo gistFileInfo;

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

    private class GistFileInfo implements Serializable {

        @SerializedName("filename")
        String filename;

        @SerializedName("type")
        String type;

        @SerializedName("language")
        String language;

        @SerializedName("raw_url")
        String rawUrl;

        @SerializedName("size")
        BigInteger size;

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getRawUrl() {
            return rawUrl;
        }

        public void setRawUrl(String rawUrl) {
            this.rawUrl = rawUrl;
        }

        public BigInteger getSize() {
            return size;
        }

        public void setSize(BigInteger size) {
            this.size = size;
        }
    }
}
