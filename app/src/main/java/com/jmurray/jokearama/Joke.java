package com.jmurray.jokearama;
import java.util.UUID;

/**
 * Created by Joshua on 10/30/2017.
 */

public class Joke {

    private String mName;
    private UUID mID;
    private boolean mViewed;

    public Joke() {
        mID = UUID.randomUUID();
    }

    public UUID getID() {
        return mID;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public boolean viewed() {
        return mViewed;
    }

    public void setViewed() {
        mViewed = true;
    }
}
