package com.fujiyama.pulp.developerprofiler.rest.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Repo implements Serializable {

    @SerializedName("id")
    BigInteger id;

    @SerializedName("name")
    String name;

    @SerializedName("full_name")
    String fullName;

    @SerializedName("html_url")
    String url;

    @SerializedName("description")
    String description;

    @SerializedName("downloads_url")
    String downloadUrl;

    @SerializedName("created_at")
    Timestamp createdAt;

    @SerializedName("size")
    BigInteger size;

    @SerializedName("language")
    String language;

    @SerializedName("updated_at")
    Timestamp updatedAt;

    @SerializedName("stargazers_count")
    BigInteger starGazers;

    @SerializedName("watchers_count")
    BigInteger watchers;

    ArrayList<Commit> commits;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public BigInteger getSize() {
        return size;
    }

    public void setSize(BigInteger size) {
        this.size = size;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public BigInteger getStarGazers() {
        return starGazers;
    }

    public void setStarGazers(BigInteger starGazers) {
        this.starGazers = starGazers;
    }

    public BigInteger getWatchers() {
        return watchers;
    }

    public void setWatchers(BigInteger watchers) {
        this.watchers = watchers;
    }

    public ArrayList<Commit> getCommits() {
        return commits;
    }

    public void setCommits(ArrayList<Commit> commits) {
        this.commits = commits;
    }
}
