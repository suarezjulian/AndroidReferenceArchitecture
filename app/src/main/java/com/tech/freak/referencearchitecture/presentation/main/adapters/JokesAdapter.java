package com.tech.freak.referencearchitecture.presentation.main.adapters;

import org.apache.commons.lang.StringEscapeUtils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tech.freak.referencearchitecture.data.model.Jokes;

/**
 * Created by j.suarez on 4/14/2015.
 */
public class JokesAdapter extends RecyclerView.Adapter<JokesAdapter.ViewHolder> {

    private Jokes jokes;

    public JokesAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.textView.setText(StringEscapeUtils.unescapeHtml(jokes.getValue().get(position).getJoke()));
    }

    @Override
    public int getItemCount() {
        if (jokes != null) {
            return jokes.getValue().size();
        }
        return 0;
    }

    public void setData(Jokes jokes) {
        this.jokes = jokes;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }
}
