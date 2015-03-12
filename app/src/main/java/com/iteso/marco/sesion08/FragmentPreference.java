package com.iteso.marco.sesion08;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

/**
 * Created by marco on 3/11/15.
 */
public class FragmentPreference extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener
{
    protected ListPreference listPreference;
    protected CheckBoxPreference checkBoxPreference;

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key)
    {
        if(key.equalsIgnoreCase("ALARM"))
        {
            String value = sharedPreferences.getString(key, "0");
            if(!value.equalsIgnoreCase("0"))
            {
                value += " minutes";
            }
            else
            {
                value = "Never";
            }
            listPreference.setSummary(value);
        }
        else if ( key.equals("TASKS_ORDER"))
        {
            Preference pref = findPreference(key);
            boolean value = sharedPreferences.getBoolean(key, false);
            if(value)
                pref.setSummary("Ascending");
            else
                pref.setSummary("Descending");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        checkBoxPreference = (CheckBoxPreference)findPreference("TASKS_ORDER");
        listPreference = (ListPreference)findPreference("ALARM");

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        boolean check = sharedPreferences.getBoolean("TASKS_ORDER", false);
        if(check)
            checkBoxPreference.setSummary("Ascending");
        else
            checkBoxPreference.setSummary("Descending");

        String value = sharedPreferences.getString("ALARM", "0");
        if(!value.equalsIgnoreCase("0"))
        {
            value += " minutes";
        }
        else
        {
            value = "Never";
        }
        listPreference.setSummary(value);

    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }
}
