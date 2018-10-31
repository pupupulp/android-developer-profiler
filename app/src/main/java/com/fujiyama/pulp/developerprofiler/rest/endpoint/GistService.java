package com.fujiyama.pulp.developerprofiler.rest.endpoint;

import com.fujiyama.pulp.developerprofiler.rest.model.Gist;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GistService {
    @GET("/users/{user}/gists")
    Call<ArrayList<Gist>> getGists(@Path("user") String user);
}
