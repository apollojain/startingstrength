package info.androidhive.tabsswipe.adapter;
 
import info.android.startingstrength.ProgrammingFragment;
import info.android.startingstrength.Workout1Fragment;
import info.android.startingstrength.Workout2Fragment;
import info.android.startingstrength.Workout3Fragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
 
public class TabsPagerAdapter extends FragmentPagerAdapter {
 
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }
 
    @Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            // Top Rated fragment activity
            return new ProgrammingFragment();
        case 1:
            // Games fragment activity
            return new Workout1Fragment();
        case 2:
            // Movies fragment activity
            return new Workout2Fragment();
        
    	case 3:
        // Movies fragment activity
    		return new Workout3Fragment();
        }
 
        return null;
    }
 
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 4;
    }
 
}