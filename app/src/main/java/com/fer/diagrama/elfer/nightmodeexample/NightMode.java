package com.fer.diagrama.elfer.nightmodeexample;

import android.app.Application;

import com.fer.diagrama.elfer.nightmodeexample.settings.ThemeSetup;

/**
 * Created by Fernando Moreno on 15/3/2021.
 */
public class NightMode extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ThemeSetup.applyTheme(this);
    }
}
