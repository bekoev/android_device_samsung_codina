package com.teamcanjica.settings.device;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.teamcanjica.settings.device.fragments.AdvancedFragmentActivity;
import com.teamcanjica.settings.device.fragments.AudioFragmentActivity;
import com.teamcanjica.settings.device.fragments.GPUFragmentActivity;
import com.teamcanjica.settings.device.fragments.IOFragmentActivity;
import com.teamcanjica.settings.device.fragments.NetworkFragmentActivity;
import com.teamcanjica.settings.device.fragments.ScreenFragmentActivity;
import com.teamcanjica.settings.device.fragments.SettingsFragmentActivity;
import com.teamcanjica.settings.device.fragments.USBFragmentActivity;

public class ContainerActivity extends Activity {

	FrameLayout frameLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.container);
		frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
		
		Fragment fragment = new Fragment();
		FragmentManager fm = getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();

		if ("start_settings".equals(getIntent().getExtras().getInt(DeviceSettings.SETTINGS))) {
			fragment = new SettingsFragmentActivity();
		} else {
			switch (getIntent().getExtras().getInt(DeviceSettings.SELECTION)) {
			case 0:
				// Network
				fragment = new NetworkFragmentActivity();
				break;
			case 1:
				// USB
				fragment = new USBFragmentActivity();
				break;
			case 2:
				// Audio
				fragment = new AudioFragmentActivity();
				break;
			case 3:
				// Screen
				fragment = new ScreenFragmentActivity();
				break;
			case 4:
				// GPU
				fragment = new GPUFragmentActivity();
				break;
			case 5:
				// I/O
				fragment = new IOFragmentActivity();
				break;
			case 6:
				// Advanced
				fragment = new AdvancedFragmentActivity();
				break;

			default:
				break;
			}
		}
		
		transaction.replace(R.id.frameLayout, fragment);
		transaction.commit();

		super.onCreate(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.device_settings, menu);
	    return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_about:
	        	startActivity(new Intent("com.teamcanjica.settings.device.AboutActivity"));
	            return true;
	        case R.id.action_settings:
	        	getFragmentManager().beginTransaction().
	        		replace(R.id.frameLayout, new SettingsFragmentActivity()).commit();
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

}
