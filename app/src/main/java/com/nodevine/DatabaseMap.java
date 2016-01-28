package com.nodevine;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by John on 1/27/2016.
 */
public class DatabaseMap extends SQLiteOpenHelper {
    public static final String DB_NAME = "mapDatabase";
    public static final int version = 1;
    public static final String TABLE_NAME = "Map";

    public static final String TBL_id = "id";
    public static final String TBL_type = "type";
    public static final String TBL_level = "level";
    public static final String TBL_name = "name";
    public static final String TBL_xPos = "xPos";
    public static final String TBL_yPos = "yPos";
    public static final String TBL_time = "time";

    SQLiteDatabase db;

    public DatabaseMap(Context context)
    {
        super(context,DB_NAME,null,version);

        try
        {
            db = this.getWritableDatabase();
        }
        catch(Exception e)
        {
            db = this.getReadableDatabase();
        }


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME +" ("+ TBL_id + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                TBL_type + " INTEGER,"+
                TBL_level +" INTEGER,"+
                TBL_name +" TEXT,"+
                TBL_xPos + " INTEGER,"+
                TBL_yPos + " INTEGER,"+
                TBL_time + " REAL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean insert(int type,int level, String name,int xPos, int yPos,double time) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TBL_type,type);
        contentValues.put(TBL_level,level);
        contentValues.put(TBL_name,name);
        contentValues.put(TBL_xPos,xPos);
        contentValues.put(TBL_yPos,yPos);
        contentValues.put(TBL_time,time);
        long result =  db.insert(TABLE_NAME,null,contentValues);
        return (result == -1)?false:true;
    }

    /**
     * @desc delete a specific building in the map
     * @param x,y - int x,y coordinate
     * @return bool - success or failure
     */
    public boolean delete(int x,int y) {
        int result =  db.delete(TABLE_NAME, TBL_xPos + "="+x+ " AND " + TBL_yPos + "="+y,null);
        return (result == -1)?false:true;
    }

    /**
     * @desc update a specific building name in the map
     * @param name,x,y - String name, int x,y
     * @return  bool - success or failure
     */
    public boolean updateName(String name,int x,int y) {
        int id  = getSelectedBuildingId(x,y);

        ContentValues args = new ContentValues();
        args.put(TBL_name, name);
        int result =  db.update(TABLE_NAME, args,TBL_id +"="+ id,null);
        return (result == -1)?false:true;
    }

    /**
     * @desc update a specific building name in the map
     * @param x,y,newX,newY - int x,y coordinate and updated x,y coordinate
     * @return  bool - success or failure
     */
    public boolean updateLocationXY(int x,int y,int newX,int newY) {
        int id  = getSelectedBuildingId(x,y);

        ContentValues args = new ContentValues();
        args.put(TBL_xPos, newX);
        args.put(TBL_yPos, newY);
        int result =  db.update(TABLE_NAME, args,TBL_id +"="+ id,null);
        return (result == -1)?false:true;
    }

    /**
     * @desc retrieve a specific building in the map
     * @param x,y - x,y coordinate
     * @return Cursor
     */
    public Cursor getSelectedBuilding(int x, int y) {
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+ " where "+TBL_xPos+ " ="+x+" AND "+TBL_yPos+ " ="+y,null);
        return res;
    }

    /**
     * @desc retrieve id specific building in the map
     * @param x,y - x,y coordinate
     * @return int
     */
    public int getSelectedBuildingId(int x, int y) {
        Cursor res = getSelectedBuilding(x,y);
        return res.getInt(res.getColumnIndex(TBL_id));
    }


    public void clearTable()   {
        db.delete(TABLE_NAME, null,null);
    }

    public Cursor getAllData() {
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
}
