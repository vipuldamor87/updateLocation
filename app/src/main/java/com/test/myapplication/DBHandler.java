package com.test.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.test.myapplication.model.Batter;
import com.test.myapplication.model.UserModel;

import org.json.JSONException;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "location";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "latlngmanager";
    private static final String ID_COL = "id";

    private static final String LAT_COL = "Lat";

    private static final String LONG_COL = "Long";

    private static final String TIME_COL = "time";


    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + LAT_COL + " TEXT,"
                + LONG_COL + " TEXT,"
                + TIME_COL + " TEXT)";

        db.execSQL(query);
    }
    public void addNew(String lat, String longi, String time) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(LAT_COL, lat);
        values.put(LONG_COL, longi);
        values.put(TIME_COL, time);

        db.insert(TABLE_NAME, null, values);
        Log.e("asd","asdasd");

        db.close();
    }
    public ArrayList<UserModel> getDatalist() {


        SQLiteDatabase db = this.getWritableDatabase();
        UserModel user;
        Cursor projCursor = db.query(TABLE_NAME, null, null,null, null, null, null,null);
        ArrayList<UserModel> users = new ArrayList<UserModel>();
        while (projCursor.moveToNext()) {

            user=new UserModel();
            user.setID(projCursor.getString(projCursor.getColumnIndex(ID_COL)));
            user.setLat(projCursor.getString(projCursor.getColumnIndex(LAT_COL)));
            user.setLongi(projCursor.getString(projCursor.getColumnIndex(LONG_COL)));
            user.setTime(projCursor.getString(projCursor.getColumnIndex(TIME_COL)));
            users.add(user);
        }
        projCursor.close();
        return users;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
