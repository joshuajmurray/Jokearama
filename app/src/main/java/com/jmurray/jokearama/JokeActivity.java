package com.jmurray.jokearama;

import android.support.v4.app.Fragment;

public class JokeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new JokeFragment();
    }
}
