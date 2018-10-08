package com.fujiyama.pulp.developerprofiler.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

public class User implements Serializable {
    @SerializedName("login")
    private String username;

    @SerializedName("id")
    private BigInteger id;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("html_url")
    private String profileUrl;

    @SerializedName("name")
    private String fullName;

    @SerializedName("company")
    private String company;

    @SerializedName("blog")
    private String blog;

    @SerializedName("location")
    private String location;

    @SerializedName("email")
    private String email;

    @SerializedName("hireable")
    private String hireAble;

    @SerializedName("bio")
    private String bio;

    @SerializedName("public_repos")
    private BigInteger publicRepos;

    @SerializedName("public_gists")
    private BigInteger publicGists;

    @SerializedName("followers")
    private BigInteger followers;

    @SerializedName("following")
    private BigInteger following;

    @SerializedName("created_at")
    private Timestamp joinDate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHireAble() {
        return hireAble;
    }

    public void setHireAble(String hireAble) {
        this.hireAble = hireAble;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public BigInteger getPublicRepos() {
        return publicRepos;
    }

    public void setPublicRepos(BigInteger publicRepos) {
        this.publicRepos = publicRepos;
    }

    public BigInteger getPublicGists() {
        return publicGists;
    }

    public void setPublicGists(BigInteger publicGists) {
        this.publicGists = publicGists;
    }

    public BigInteger getFollowers() {
        return followers;
    }

    public void setFollowers(BigInteger followers) {
        this.followers = followers;
    }

    public BigInteger getFollowing() {
        return following;
    }

    public void setFollowing(BigInteger following) {
        this.following = following;
    }

    public Timestamp getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Timestamp joinDate) {
        this.joinDate = joinDate;
    }
}
