package com.fer.diagrama.elfer.nightmodeexample.settings;

import android.os.Bundle;

import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;

import com.fer.diagrama.elfer.nightmodeexample.R;
import com.fer.diagrama.elfer.nightmodeexample.constants.Mode;

/**
 * Created by Fernando Moreno on 15/3/2021.
 */
public class ConfigurationFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.app_settings, rootKey);

        ListPreference themePreference = getPreferenceManager().findPreference(getString(R.string.settings_theme_key));
        if (themePreference.getValue() == null) {
            themePreference.setValue(Mode.DEFAULT.name());
        }
        themePreference.setOnPreferenceChangeListener((preference, newValue) -> {
            ThemeSetup.applyTheme(Mode.valueOf((String) newValue));
            return true;
        });
    }
}
