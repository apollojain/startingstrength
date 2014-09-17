package info.android.startingstrength;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper {

   public static final String DATABASE_NAME = "MyDBName.db";
   public static final String WEIGHTS_TABLE_NAME = "weights";
   public static final String WEIGHTS_COLUMN_ID = "id";
   public static final String WEIGHTS_COLUMN_DATE = "date";
   public static final String WEIGHTS_COLUMN_SQUAT = "squat";
   public static final String WEIGHTS_COLUMN_BENCH = "bench";
   public static final String WEIGHTS_COLUMN_DEADLIFT = "deadlift";
   public static final String WEIGHTS_COLUMN_PRESS = "press";
   public static final String WEIGHTS_COLUMN_CLEAN = "clean";
   public static final String WEIGHTS_COLUMN_EXTENSIONS = "extensions";
   public static final String WEIGHTS_COLUMN_PULLCHINUP = "pullchinup";

   private HashMap hp;

   public DBHelper(Context context)
   {
      super(context, DATABASE_NAME , null, 1);
   }

   @Override
   public void onCreate(SQLiteDatabase db) {
      // TODO Auto-generated method stub
      db.execSQL(
      "create table weights " +
      "(id integer primary key, date text,squat text,bench text, deadlift text,press text, clean text, extensions text, pullchinup text)"
      );
   }

   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      // TODO Auto-generated method stub
      db.execSQL("DROP TABLE IF EXISTS weights");
      onCreate(db);
   }

   public boolean insertWeights  (String date, String squat, String bench, String deadlift,String press, String clean, String extensions, String pullchinup)
   {
      SQLiteDatabase db = this.getWritableDatabase();
      ContentValues contentValues = new ContentValues();

      contentValues.put("date", date);
      contentValues.put("squat", squat);
      contentValues.put("bench", bench);	
      contentValues.put("deadlift", deadlift);
      contentValues.put("press", press);
      contentValues.put("clean", clean);
      contentValues.put("extensions", extensions);
      contentValues.put("pullchinup", pullchinup);

      db.insert("weights", null, contentValues);
      return true;
   }
   public Cursor getData(int id){
      SQLiteDatabase db = this.getReadableDatabase();
      Cursor res =  db.rawQuery( "select * from weights where id="+id+"", null );
      return res;
   }
   public int numberOfRows(){
      SQLiteDatabase db = this.getReadableDatabase();
      int numRows = (int) DatabaseUtils.queryNumEntries(db, WEIGHTS_TABLE_NAME);
      return numRows;
   }
   public boolean updateWeight (Integer id, String date, String squat, String bench, String deadlift,String press, String clean, String extensions, String pullchinup)
   {
      SQLiteDatabase db = this.getWritableDatabase();
      ContentValues contentValues = new ContentValues();
      contentValues.put("date", date);
      contentValues.put("squat", squat);
      contentValues.put("bench", bench);	
      contentValues.put("deadlift", deadlift);
      contentValues.put("press", press);
      contentValues.put("clean", clean);
      contentValues.put("extensions", extensions);
      contentValues.put("pullchinup", pullchinup);
      db.update("weights", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
      return true;
   }

   public Integer deleteContact (Integer id)
   {
      SQLiteDatabase db = this.getWritableDatabase();
      return db.delete("weights", 
      "id = ? ", 
      new String[] { Integer.toString(id) });
   }
   public ArrayList getAllWeights()
   {
      ArrayList array_list = new ArrayList();
      //hp = new HashMap();
      SQLiteDatabase db = this.getReadableDatabase();
      Cursor res =  db.rawQuery( "select * from weights", null );
      res.moveToFirst();
      while(res.isAfterLast() == false){
      array_list.add(res.getString(res.getColumnIndex(WEIGHTS_COLUMN_DATE)));
      res.moveToNext();
      }
   return array_list;
   }
}