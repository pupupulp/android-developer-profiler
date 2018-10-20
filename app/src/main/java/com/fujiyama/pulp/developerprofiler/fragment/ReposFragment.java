package com.fujiyama.pulp.developerprofiler.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fujiyama.pulp.developerprofiler.R;
import com.fujiyama.pulp.developerprofiler.config.DeveloperProfiler;
import com.fujiyama.pulp.developerprofiler.utility.RepoRecyclerViewAdapter;

public class ReposFragment extends Fragment {

    View view;
    private RecyclerView recyclerView;

    public ReposFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_repos, container, false);

        RepoRecyclerViewAdapter repoRecyclerViewAdapter = new RepoRecyclerViewAdapter(DeveloperProfiler.getInstance(), DeveloperProfiler.getRepos());
        recyclerView = (RecyclerView) view.findViewById(R.id.repoRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(repoRecyclerViewAdapter);

        return view;
    }
}
