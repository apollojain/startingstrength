package info.android.startingstrength;

import info.android.startingstrength.R;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
			case R.id.action_home:
	        	Intent intenthome = new Intent(this, MainActivity.class);
	    		startActivity(intenthome);
	            return true;
	        case R.id.action_strength:
	        	Intent intent = new Intent(this, WorkoutActivity.class);
	    		startActivity(intent);
	            return true;
	        case R.id.action_nutrition:
	        	Intent intent2 = new Intent(this, NutritionActivity.class);
	    		startActivity(intent2);
	            return true;
	        case R.id.action_progress:
	        	Intent intent3 = new Intent(this, WeightActivity.class);
	    		startActivity(intent3);
	            return true;
	        default:
	        	return true;
		}
	}

	
	public void strengthView(View v){
		Intent intent = new Intent(this, WorkoutActivity.class);
		startActivity(intent);

		
	}

	public void nutritionView(View v){
		Intent intent = new Intent(this, NutritionActivity.class);
		startActivity(intent);

		
	}
	
	public void progressView(View v){
		Intent intent = new Intent(this, WeightActivity.class);
		startActivity(intent);

		
	}
	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
