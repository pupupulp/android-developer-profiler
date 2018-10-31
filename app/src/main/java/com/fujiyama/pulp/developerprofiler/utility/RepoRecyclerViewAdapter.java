package com.fujiyama.pulp.developerprofiler.utility;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fujiyama.pulp.developerprofiler.R;
import com.fujiyama.pulp.developerprofiler.rest.model.Repo;

import java.util.ArrayList;

public class RepoRecyclerViewAdapter extends RecyclerView.Adapter<RepoRecyclerViewAdapter.RepoViewHolder> {

    Context context;
    ArrayList<Repo> repos;

    public RepoRecyclerViewAdapter(Context context, ArrayList<Repo> repos) {
        this.context = context;
        this.repos = repos;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_repo, viewGroup, false);

        RepoViewHolder viewHolder = new RepoViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder repoViewHolder, int i) {
        repoViewHolder.repoName.setText(repos.get(i).getFullName());
        repoViewHolder.repoDescription.setText(repos.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public static class RepoViewHolder extends RecyclerView.ViewHolder {

        private TextView repoName;
        private TextView repoDescription;

        public RepoViewHolder(@NonNull View itemView) {
            super(itemView);

            repoName = (TextView) itemView.findViewById(R.id.repoName);
            repoDescription = (TextView) itemView.findViewById(R.id.repoDescription);
        }
    }
}
