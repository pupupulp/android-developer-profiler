package com.fujiyama.pulp.developerprofiler.rest.endpoint;

import com.fujiyama.pulp.developerprofiler.model.Commit;
import com.fujiyama.pulp.developerprofiler.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RepoService {
    @GET("/users/{user}/repos")
    Call<List<Repo>> getRepos(@Path("user") String user);

    @GET("/repos/{user}/{repo}/commits")
    Call<Commit> getRepoCommits(@Path("user") String user, @Path("repo") String repo);
}
