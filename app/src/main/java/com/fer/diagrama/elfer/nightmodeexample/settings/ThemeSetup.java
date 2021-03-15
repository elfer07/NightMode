package com.fer.diagrama.elfer.nightmodeexample.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatDelegate;

import com.fer.diagrama.elfer.nightmodeexample.R;
import com.fer.diagrama.elfer.nightmodeexample.constants.Mode;

/**
 * Created by Fernando Moreno on 15/3/2021.
 */
public class ThemeSetup {

    private ThemeSetup() {
    }

    public static void applyTheme(Mode mode) {
        switch (mode) {
            case DARK:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case LIGHT:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            default:
                // verify android version is < api 29
                if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                }
        }
    }

    public static void applyTheme(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String value = defaultSharedPreferences.getString(context.getString(R.string.settings_theme_key), Mode.DEFAULT.name());
        applyTheme(Mode.valueOf(value));
    }
}
