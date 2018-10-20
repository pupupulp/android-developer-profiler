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
}
