package info.android.startingstrength;

import info.android.startingstrength.R;

import java.util.Locale;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

    public class NutritionActivity extends FragmentActivity {  
      
        /** 
         * The {@link android.support.v4.view.PagerAdapter} that will provide 
         * fragments for each of the sections. We use a 
         * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which 
         * will keep every loaded fragment in memory. If this becomes too memory 
         * intensive, it may be best to switch to a 
         * {@link android.support.v4.app.FragmentStatePagerAdapter}. 
         */  
        PagerAdapter mSectionsPagerAdapter;  
      
        /** 
         * The {@link ViewPager} that will host the section contents. 
         */  
        ViewPager mViewPager;  
      
        @Override  
        protected void onCreate(Bundle savedInstanceState) {  
            super.onCreate(savedInstanceState);  
            setContentView(R.layout.fragment_nutrition);  
      
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
        /** 
         * A {@link FragmentPagerAdapter} that returns a fragment corresponding to 
         * one of the sections/tabs/pages. 
         */  
        public class SectionsPagerAdapter extends FragmentPagerAdapter {  
      
            public SectionsPagerAdapter(FragmentManager fm) {  
                super(fm);  
            }  
      
            public Fragment getItem(int position) {  
                Fragment fragment = new Fragment();  
                switch (position) {  
                case 0:  
                    return fragment = new SupplementsFragment();  
                case 1:  
                    return fragment = new OverweightFragment();  
                case 2:  
                    return fragment = new UnderweightFragment();  
                default:  
                    break;  
                }  
                return fragment;  
            }
      
            @Override  
            public int getCount() {  
                // Show 3 total pages.  
                return 3;  
            }  
      
            @Override  
            public CharSequence getPageTitle(int position) {  
                Locale l = Locale.getDefault();  
                switch (position) {  
                case 0:  
                    return getString(R.string.supplements).toUpperCase(l);  
                case 1:  
                    return getString(R.string.overweight).toUpperCase(l);  
                case 2:  
                    return getString(R.string.underweight).toUpperCase(l);  
                default:
                	break;
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
                View rootView = inflater.inflate(R.layout.fragment_nutrition_phony, container, false);  
                TextView dummyTextView = (TextView) rootView.findViewById(R.id.section_label);  
                dummyTextView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));  
                return rootView;  
            }  
        }  
      
    }  