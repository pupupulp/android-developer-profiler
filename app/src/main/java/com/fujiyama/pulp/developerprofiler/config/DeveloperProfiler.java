package com.fujiyama.pulp.developerprofiler.config;

import android.app.Application;

public class DeveloperProfiler extends Application {

    private static DeveloperProfiler instance;

    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static DeveloperProfiler getInstance() {
        return instance;
    }
}
