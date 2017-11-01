package com.jmurray.jokearama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

/**
 * Created by Joshua on 10/30/2017.
 */

public class JokeFragment extends Fragment {
    private Joke mJoke;
    private TextView mJokeName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID jokeId = (UUID) getActivity().getIntent().getSerializableExtra(JokeActivity.EXTRA_JOKE_ID);
        mJoke = JokeFactory.get(getActivity()).getJoke(jokeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_joke, container, false);
        mJokeName = (TextView) v.findViewById(R.id.joke_title);
        mJokeName.setText(mJoke.getName());
        return v;
    }
}
