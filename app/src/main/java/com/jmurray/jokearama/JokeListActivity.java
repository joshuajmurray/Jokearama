package com.jmurray.jokearama;

import android.support.v4.app.Fragment;

/**
 * Created by Joshua on 10/30/2017.
 */

public class JokeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new JokeListFragment();
    }
}
