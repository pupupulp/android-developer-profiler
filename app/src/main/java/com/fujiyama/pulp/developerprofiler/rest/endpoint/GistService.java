package com.fujiyama.pulp.developerprofiler.rest.endpoint;

import com.fujiyama.pulp.developerprofiler.model.Gist;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GistService {
    @GET("/users/{user}/gists")
    Call<ArrayList<Gist>> getRepos(@Path("user") String user);
}
