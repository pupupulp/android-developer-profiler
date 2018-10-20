package com.fujiyama.pulp.developerprofiler.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigInteger;

public class GistFileContent implements Serializable {

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
