package com.fujiyama.pulp.developerprofiler.config;

import android.app.Application;

import com.fujiyama.pulp.developerprofiler.model.Gist;
import com.fujiyama.pulp.developerprofiler.model.Repo;
import com.fujiyama.pulp.developerprofiler.model.User;

import java.util.ArrayList;

public class DeveloperProfiler extends Application {

    private static DeveloperProfiler instance;
    private static User user;
    private static ArrayList<Repo> repos;
    private static ArrayList<Gist> gists;

    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static DeveloperProfiler getInstance() {
        return instance;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        DeveloperProfiler.user = user;
    }

    public static ArrayList<Repo> getRepos() {
        return repos;
    }

    public static void setRepos(ArrayList<Repo> repos) {
        DeveloperProfiler.repos = repos;
    }

    public static ArrayList<Gist> getGists() {
        return gists;
    }

    public static void setGists(ArrayList<Gist> gists) {
        DeveloperProfiler.gists = gists;
    }
}
