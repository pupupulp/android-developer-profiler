package com.fujiyama.pulp.developerprofiler.config;

import android.app.Application;

import com.fujiyama.pulp.developerprofiler.model.Commit;
import com.fujiyama.pulp.developerprofiler.model.Repo;
import com.fujiyama.pulp.developerprofiler.model.User;

import java.util.ArrayList;

public class DeveloperProfiler extends Application {

    private static DeveloperProfiler instance;
    private static User user;
    private static ArrayList<Repo> repos;
    private static ArrayList<Commit> commits;

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

    public static ArrayList<Repo> getRepo() {
        return repos;
    }

    public static void setRepo(ArrayList<Repo> repo) {
        DeveloperProfiler.repos = repo;
    }
}
