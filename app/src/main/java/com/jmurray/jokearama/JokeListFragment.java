package com.jmurray.jokearama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Joshua on 10/30/2017.
 */

public class JokeListFragment extends Fragment {
    private RecyclerView mJokeRecyclerView;
    private JokeAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {
        View view = inflater.inflate(R.layout.fragment_joke_list, container, false);

        mJokeRecyclerView = (RecyclerView) view.findViewById(R.id.joke_recycler_view);
        mJokeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        JokeFactory jokeFactory = JokeFactory.get(getActivity());
        List<Joke> jokes = jokeFactory.getJokes();

        mAdapter = new JokeAdapter(jokes);
        mJokeRecyclerView.setAdapter(mAdapter);
    }

    private class JokeHolder extends RecyclerView.ViewHolder {
        private TextView mNameTextView;
        private Joke mJoke;

        public JokeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_joke, parent, false));

            mNameTextView = (TextView) itemView.findViewById(R.id.joke_title);
        }

        public void bind(Joke joke) {
            mJoke = joke;
            mNameTextView.setText(mJoke.getName());
        }
    }

    private class JokeAdapter extends RecyclerView.Adapter<JokeHolder> {
        private List<Joke> mJokes;

        public JokeAdapter(List<Joke> jokes) {
            mJokes = jokes;
        }

        @Override
        public JokeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new JokeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(JokeHolder holder, int position) {
            Joke joke = mJokes.get(position);
            holder.bind(joke);
        }

        @Override
        public int getItemCount() {
            return mJokes.size();
        }
    }
}