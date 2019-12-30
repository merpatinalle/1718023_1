package com.example.a1718023.App;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragment;
import androidx.preference.PreferenceFragmentCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;

import com.example.a1718023.R;

import java.util.Objects;

public class AppSeting extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_seting);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings_container, new MyPreferenceFargment())
                .commit();
    }

    public static class MyPreferenceFargment extends PreferenceFragmentCompat implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {
    String setting_locale;

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            addPreferencesFromResource(R.xml.app_settings);
            setPreferencesFromResource(R.xml.app_settings, rootKey);
            setting_locale = this.getResources().getString(R.string.key_setting_locale);
            Objects.requireNonNull(findPreference(setting_locale)).setOnPreferenceClickListener(this);

        }

         @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
           return false;
        }

        @Override
        public boolean onPreferenceClick(Preference preference) {
            String key = preference.getKey();

            if (key.equals(setting_locale)){
                Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(intent);
                return true;
            }
            return false;
        }

    }
}
