package com.fujiyama.pulp.developerprofiler.utility;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fujiyama.pulp.developerprofiler.R;
import com.fujiyama.pulp.developerprofiler.model.Gist;

import java.util.ArrayList;

public class GistRecyclerViewAdapter extends RecyclerView.Adapter<GistRecyclerViewAdapter.GistViewHolder> {

    Context context;
    ArrayList<Gist> gists;

    public GistRecyclerViewAdapter(Context context, ArrayList<Gist> gists) {
        this.context = context;
        this.gists = gists;
    }

    @NonNull
    @Override
    public GistViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_repo, viewGroup, false);

        GistViewHolder viewHolder = new GistViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GistViewHolder gistViewHolder, int i) {
        gistViewHolder.gistName.setText(gists.get(i).getGistFileContent().getFilename());
        gistViewHolder.gistDescription.setText(gists.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return gists.size();
    }

    public static class GistViewHolder extends RecyclerView.ViewHolder {

        private TextView gistName;
        private TextView gistDescription;

        public GistViewHolder(@NonNull View itemView) {
            super(itemView);

            gistName = (TextView) itemView.findViewById(R.id.gistName);
            gistDescription = (TextView) itemView.findViewById(R.id.gistDescription);
        }
    }
}
