package info.android.startingstrength;

import info.android.startingstrength.R;

import java.util.Locale;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

    public class WorkoutActivity extends FragmentActivity {  
      
        /** 
         * The {@link android.support.v4.view.PagerAdapter} that will provide 
         * fragments for each of the sections. We use a 
         * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which 
         * will keep every loaded fragment in memory. If this becomes too memory 
         * intensive, it may be best to switch to a 
         * {@link android.support.v4.app.FragmentStatePagerAdapter}. 
         */  
        SectionsPagerAdapter mSectionsPagerAdapter;  
      
        /** 
         * The {@link ViewPager} that will host the section contents. 
         */  
        ViewPager mViewPager;  
      
        @Override  
        protected void onCreate(Bundle savedInstanceState) {  
            super.onCreate(savedInstanceState);  
            setContentView(R.layout.fragment_workout);  
      
            // Create the adapter that will return a fragment for each of the three  
            // primary sections of the app.  
            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());  
      
            // Set up the ViewPager with the sections adapter.  
            mViewPager = (ViewPager) findViewById(R.id.pager);  
            mViewPager.setAdapter(mSectionsPagerAdapter);  
      
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
      
        
        public void squatVid(View v){
        	String squatUrl = "https://www.youtube.com/watch?v=Dy28eq2PjcM";
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(squatUrl));
        	startActivity(intent);
        }
        
        public void benchVid(View v){
        	String benchUrl = "https://www.youtube.com/watch?v=gRVjAtPip0Y";
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(benchUrl ));
        	startActivity(intent);
        }
        
        public void pressVid(View v){
        	String pressUrl = "https://www.youtube.com/watch?v=F3QY5vMz_6I";
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(pressUrl ));
        	startActivity(intent);
        }
        
        public void deadliftVid(View v){
        	String deadliftUrl = "https://www.youtube.com/watch?v=-4qRntuXBSc";
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(deadliftUrl ));
        	startActivity(intent);
        }
        
        public void cleanVid(View v){
        	String cleanUrl = "https://www.youtube.com/watch?v=XDxK_8iX__U";
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(cleanUrl));
        	startActivity(intent);
        }
        
        public void backextensionVid(View v){
        	String backextensionUrl = "https://www.youtube.com/watch?v=ph3pddpKzzw";
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(backextensionUrl ));
        	startActivity(intent);
        }
        
        public void chinpullupVid(View v){
        	String chinpullupUrl = "https://www.youtube.com/watch?v=4_nOqg5eM-A";
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(chinpullupUrl ));
        	startActivity(intent);
        }
        
        public void deadliftcleanVid(View v){
        	String deadliftcleanUrl = "https://www.youtube.com/watch?v=XDxK_8iX__U&list=PL0FODwKM78EJG94MRTffHM9aJQgcgzGrX";
        	Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(deadliftcleanUrl));
        	startActivity(intent);
        }
        /** 
         * A {@link FragmentPagerAdapter} that returns a fragment corresponding to 
         * one of the sections/tabs/pages. 
         */  
        public class SectionsPagerAdapter extends FragmentPagerAdapter {  
      
            public SectionsPagerAdapter(FragmentManager fm) {  
                super(fm);  
            }  
      
            @Override  
            public Fragment getItem(int position) {  
                Fragment fragment = new Fragment();  
                switch (position) {  
                case 0:  
                    return fragment = new ProgrammingFragment();  
                case 1:  
                    return fragment = new Workout1Fragment();  
                case 2:  
                    return fragment = new Workout2Fragment();  
                case 3:  
                    return fragment = new Workout3Fragment();  
                default:  
                    break;  
                }  
                return fragment;  
            }
      
            @Override  
            public int getCount() {  
                // Show 3 total pages.  
                return 4;  
            }  
      
            @Override  
            public CharSequence getPageTitle(int position) {  
                Locale l = Locale.getDefault();  
                switch (position) {  
                case 0:  
                    return getString(R.string.programming).toUpperCase(l);  
                case 1:  
                    return getString(R.string.phase1).toUpperCase(l);  
                case 2:  
                    return getString(R.string.phase2).toUpperCase(l);
                case 3:
                	return getString(R.string.phase3).toUpperCase(l);
                }  
                return null;  
            }  
        }  
      
        /** 
         * A dummy fragment representing a section of the app, but that simply 
         * displays dummy text. 
         */  
        public static class DummySectionFragment extends Fragment {  
            /** 
             * The fragment argument representing the section number for this 
             * fragment. 
             */  
            public static final String ARG_SECTION_NUMBER = "section_number";  
      
            public DummySectionFragment() {  
            }  
      
            @Override  
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {  
                View rootView = inflater.inflate(R.layout.fragment_workout_phony, container, false);  
                TextView dummyTextView = (TextView) rootView.findViewById(R.id.section_label);  
                dummyTextView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));  
                return rootView;  
            }  
        }  
      
    }  