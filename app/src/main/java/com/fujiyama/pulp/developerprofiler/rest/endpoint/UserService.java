package com.fujiyama.pulp.developerprofiler.rest.endpoint;

import com.fujiyama.pulp.developerprofiler.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {

    @GET("/users/{user}")
    Call<User> getUser(@Path("user") String user);
}
