package com.fujiyama.pulp.developerprofiler.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fujiyama.pulp.developerprofiler.R;
import com.fujiyama.pulp.developerprofiler.utility.GistRecyclerViewAdapter;

public class GistsFragment extends Fragment {

    View view;
    public GistsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gists, container, false);

        GistRecyclerViewAdapter repoRecyclerViewAdapter = new GistRecyclerViewAdapter(DeveloperProfiler.getInstance(), DeveloperProfiler.getRepos());
        recyclerView = (RecyclerView) view.findViewById(R.id.repoRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(repoRecyclerViewAdapter);


        return view;
    }
}
