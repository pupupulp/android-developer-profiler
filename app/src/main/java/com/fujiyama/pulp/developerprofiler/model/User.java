package com.fujiyama.pulp.developerprofiler.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;
import java.sql.Timestamp;

public class User {
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
}
