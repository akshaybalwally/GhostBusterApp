package edu.virginia.cs2110.apb8gb;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class PlayScreen extends Activity {

	/** Called when the activity is first created. */

	private static final String TAG = PlayScreen.class.getSimpleName();

	@Override
	
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		// requesting to turn the title OFF

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// making it full screen

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		// set our MainGamePanel as the View

		setContentView(new MainGamePanel(this));
		
		Log.d(TAG, "View added");

	}

	@Override
	protected void onDestroy() {

		Log.d(TAG, "Destroying...");

		super.onDestroy();

	}

	@Override
	protected void onStop() {

		Log.d(TAG, "Stopping...");

		super.onStop();

	}
}