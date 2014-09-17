package info.android.startingstrength;

import info.android.startingstrength.R;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WeightActivity extends Activity {
   public final static String EXTRA_MESSAGE = "com.example.StartingStrength.MESSAGE";

   private ListView obj;	
   DBHelper mydb;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_weight);

      mydb = new DBHelper(this);
      ArrayList array_list = mydb.getAllWeights();

      ArrayAdapter arrayAdapter =      
      new ArrayAdapter(this,android.R.layout.simple_list_item_1, array_list);

      //adding it to the list view.
      obj = (ListView)findViewById(R.id.listView1);
      obj.setAdapter(arrayAdapter);

      obj.setOnItemClickListener(new OnItemClickListener(){

     @Override
     public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
     long arg3) {
         // TODO Auto-generated method stub
         int id_To_Search = arg2 + 1;
         Bundle dataBundle = new Bundle();
         dataBundle.putInt("id", id_To_Search);
         Intent intent = new Intent(getApplicationContext(),info.android.startingstrength.DisplayWeight.class);
         intent.putExtras(dataBundle);
         startActivity(intent);
     }
     });
   }
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.mainmenu, menu);
      return true;
      }
   @Override 
   public boolean onOptionsItemSelected(MenuItem item) 
   { 
      super.onOptionsItemSelected(item); 
      switch(item.getItemId()) 
      { 
         case R.id.item1: 
            Bundle dataBundle = new Bundle();
            dataBundle.putInt("id", 0);
            Intent intent = new Intent(getApplicationContext(),info.android.startingstrength.DisplayWeight.class);
            intent.putExtras(dataBundle);
            startActivity(intent);
            return true; 
         case R.id.action_home:
	        	Intent intenthome = new Intent(this, MainActivity.class);
	    		startActivity(intenthome);
	            return true;
	       case R.id.action_strength:
	        	Intent intentstrength = new Intent(this, WorkoutActivity.class);
	    		startActivity(intentstrength);
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
            return super.onOptionsItemSelected(item); 

       } 

   } 
   public boolean onKeyDown(int keycode, KeyEvent event) {
      if (keycode == KeyEvent.KEYCODE_BACK) {
         moveTaskToBack(true);
         Intent intent = new Intent(this, MainActivity.class);
 		 startActivity(intent);
 		 return true;
      }
      return super.onKeyDown(keycode, event);
   }
   


}