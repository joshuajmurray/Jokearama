package com.jmurray.jokearama;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Joshua on 10/30/2017.
 */

public class JokeFactory {
    private static JokeFactory sJokeFactory;

    private List<Joke> mJokes;

    public static JokeFactory get(Context context) {
        if(sJokeFactory == null) {
            sJokeFactory = new JokeFactory(context);
        }
        return sJokeFactory;
    }

    private JokeFactory(Context context) {
        mJokes = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            Joke joke = new Joke();
            joke.setName("Joke #" + i);
            mJokes.add(joke);
        }
    };

    public List<Joke> getJokes() {
        return mJokes;
    }

    public Joke getJoke(UUID id) {
        for(Joke joke : mJokes) {
            if(joke.getID().equals(id)) {
                return joke;
            }
        }
        return null;
    }


}
