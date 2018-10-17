package com.fujiyama.pulp.developerprofiler.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Commit implements Serializable {

    @SerializedName("commit.author")
    String author;
}
