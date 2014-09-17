package info.android.startingstrength;

import info.android.startingstrength.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayWeight extends Activity {

   int from_Where_I_Am_Coming = 0;
   private DBHelper mydb ;
   TextView date;
   TextView squat;
   TextView bench;
   TextView deadlift;
   TextView press;
   TextView clean;
   TextView extensions;
   TextView pullchinups;
   int id_To_Update = 0;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_display_weight);
      date = (TextView) findViewById(R.id.editTextDate);
      squat = (TextView) findViewById(R.id.editTextSquat);
      bench = (TextView) findViewById(R.id.editTextBench);
      deadlift = (TextView) findViewById(R.id.editTextDeadlift);
      press = (TextView) findViewById(R.id.editTextPress);
      clean = (TextView) findViewById(R.id.editTextClean);
      extensions = (TextView) findViewById(R.id.editTextExtensions);
      pullchinups = (TextView) findViewById(R.id.editTextPullchinups);

      mydb = new DBHelper(this);

      Bundle extras = getIntent().getExtras(); 
      if(extras !=null)
      {
         int Value = extras.getInt("id");
         if(Value>0){
            //means this is the view part not the add contact part.
            Cursor rs = mydb.getData(Value);
            id_To_Update = Value;
            rs.moveToFirst();
            String dat = rs.getString(rs.getColumnIndex(DBHelper.WEIGHTS_COLUMN_DATE));
            String squa = rs.getString(rs.getColumnIndex(DBHelper.WEIGHTS_COLUMN_SQUAT));
            String benc = rs.getString(rs.getColumnIndex(DBHelper.WEIGHTS_COLUMN_BENCH));
            String deadl = rs.getString(rs.getColumnIndex(DBHelper.WEIGHTS_COLUMN_DEADLIFT));
            String pre = rs.getString(rs.getColumnIndex(DBHelper.WEIGHTS_COLUMN_PRESS));
            String clea = rs.getString(rs.getColumnIndex(DBHelper.WEIGHTS_COLUMN_CLEAN));
            String exte = rs.getString(rs.getColumnIndex(DBHelper.WEIGHTS_COLUMN_EXTENSIONS));
            String pul = rs.getString(rs.getColumnIndex(DBHelper.WEIGHTS_COLUMN_PULLCHINUP));
            if (!rs.isClosed()) 
            {
               rs.close();
            }
            Button b = (Button)findViewById(R.id.button1);
            b.setVisibility(View.INVISIBLE);

            date.setText((CharSequence)dat);
            date.setFocusable(false);
            date.setClickable(false);

            squat.setText((CharSequence)squa);
            squat.setFocusable(false); 
            squat.setClickable(false);

            bench.setText((CharSequence)benc);
            bench.setFocusable(false);
            bench.setClickable(false);

            deadlift.setText((CharSequence)deadl);
            deadlift.setFocusable(false); 
            deadlift.setClickable(false);

            press.setText((CharSequence)pre);
            press.setFocusable(false);
            press.setClickable(false);
            
            clean.setText((CharSequence)clea);
            clean.setFocusable(false);
            clean.setClickable(false);
            
            extensions.setText((CharSequence)exte);
            extensions.setFocusable(false);
            extensions.setClickable(false);
            
            pullchinups.setText((CharSequence)pul);
            pullchinups.setFocusable(false);
            pullchinups.setClickable(false);
           }
      }
   }
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      Bundle extras = getIntent().getExtras(); 
      if(extras !=null)
      {
         int Value = extras.getInt("id");
         if(Value>0){
            getMenuInflater().inflate(R.menu.display_weight, menu);
         }
         else{
            getMenuInflater().inflate(R.menu.main, menu);
         }
      }
      return true;
   }

   public boolean onOptionsItemSelected(MenuItem item) 
   { 
      super.onOptionsItemSelected(item); 
      switch(item.getItemId()) 
      { 
      	case R.id.Edit_Weight: 
	      Button b = (Button)findViewById(R.id.button1);
	      b.setVisibility(View.VISIBLE);
	      date.setEnabled(true);
	      date.setFocusableInTouchMode(true);
	      date.setClickable(true);
	
	      squat.setEnabled(true);
	      squat.setFocusableInTouchMode(true);
	      squat.setClickable(true);
	
	      bench.setEnabled(true);
	      bench.setFocusableInTouchMode(true);
	      bench.setClickable(true);
	
	      deadlift.setEnabled(true);
	      deadlift.setFocusableInTouchMode(true);
	      deadlift.setClickable(true);
	      
	      press.setEnabled(true);
	      press.setFocusableInTouchMode(true);
	      press.setClickable(true);
	
	      clean.setEnabled(true);
	      clean.setFocusableInTouchMode(true);
	      clean.setClickable(true);
	      
	      extensions.setEnabled(true);
	      extensions.setFocusableInTouchMode(true);
	      extensions.setClickable(true);
	      
	      pullchinups.setEnabled(true);
	      pullchinups.setFocusableInTouchMode(true);
	      pullchinups.setClickable(true);
	
	      return true; 
      	case R.id.Delete_Weight:
	
	      AlertDialog.Builder builder = new AlertDialog.Builder(this);
	      builder.setMessage(R.string.deleteWeight)
	     .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
	         public void onClick(DialogInterface dialog, int id) {
	            mydb.deleteContact(id_To_Update);
	            Toast.makeText(getApplicationContext(), "Deleted Successfully", Toast.LENGTH_SHORT).show();  
	            Intent intent = new Intent(getApplicationContext(),info.android.startingstrength.WeightActivity.class);
	            startActivity(intent);
	         }
	      })
	     .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
	         public void onClick(DialogInterface dialog, int id) {
	            // User cancelled the dialog
	         }
	      });
	      AlertDialog d = builder.create();
	      d.setTitle("Are you sure");
	      d.show();
	
	      return true;
      	case R.id.Back:
        	Intent intent3 = new Intent(this, WeightActivity.class);
    		startActivity(intent3);
            return true;
      	default: 
    	  return super.onOptionsItemSelected(item); 

      } 
   } 

   public void run(View view)
   {	
      Bundle extras = getIntent().getExtras();
      if(extras !=null)
      {
         int Value = extras.getInt("id");
         if(Value>0){
            if(mydb.updateWeight(id_To_Update,date.getText().toString(), squat.getText().toString(), bench.getText().toString(), deadlift.getText().toString(), press.getText().toString(), clean.getText().toString(), extensions.getText().toString(), pullchinups.getText().toString())){
               Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();	
               Intent intent = new Intent(getApplicationContext(),info.android.startingstrength.WeightActivity.class);
               startActivity(intent);
             }		
            else{
               Toast.makeText(getApplicationContext(), "not Updated", Toast.LENGTH_SHORT).show();	
            }
		 }
         else{
            if(mydb.insertWeights(date.getText().toString(), squat.getText().toString(), bench.getText().toString(), deadlift.getText().toString(), press.getText().toString(), clean.getText().toString(), extensions.getText().toString(), pullchinups.getText().toString())){
               Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();	
            }		
            else{
               Toast.makeText(getApplicationContext(), "not done", Toast.LENGTH_SHORT).show();	
            }
            Intent intent = new Intent(getApplicationContext(),info.android.startingstrength.WeightActivity.class);
            startActivity(intent);
            }
      }
   }
}

