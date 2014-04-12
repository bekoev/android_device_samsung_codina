package com.teamcanjica.settings.device.fragments;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.util.Log;

import com.teamcanjica.settings.device.DeviceSettings;
import com.teamcanjica.settings.device.R;
import com.teamcanjica.settings.device.Startup;

public class SettingsFragmentActivity extends PreferenceFragment {
	
	private static final String TAG = "GalaxyAce2_Settings_Settings";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		addPreferencesFromResource(R.xml.settings_preferences);

		getActivity().getActionBar().setTitle(getResources().getString(R.string.settings_name));
//		getActivity().getActionBar().setIcon(getResources().getDrawable(R.drawable.settings_icon));
	}
	
	@Override
	public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
			Preference preference) {

		String key = preference.getKey();

		Log.w(TAG, "key: " + key);

		if (key.equals(DeviceSettings.KEY_ENABLE_RESTORE)) {
			Startup.enableRestore = (((CheckBoxPreference) preference).
					isChecked() ? true : false);
		}

		return true;
	}

}
