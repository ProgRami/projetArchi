package com.projects.ahmozz.myfirstgooglemapapp.metiers;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.android.gms.maps.model.LatLng;
import com.projects.ahmozz.myfirstgooglemapapp.MapsActivity;
import com.projects.ahmozz.myfirstgooglemapapp.MyDbContract;
import com.projects.ahmozz.myfirstgooglemapapp.MyDbHelper;

import java.util.ArrayList;

/**
 * Created by ahmozz on 08/12/15.
 */
public class CollectionPoint {

    public CollectionPoint() {

    }

    private int id;
    private String name;
    private LatLng coord;
    private String address;
    private float capacity;


    public static long addCollectionPoint(MyDbHelper mBdHelper,int id,String name,Double lat,Double lng,
                                          String address,Double capacity,Double availabiity,String type){
        SQLiteDatabase dblite=mBdHelper.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put(MyDbContract.FeedEntry.COLUMN_NAME_ENTRY_ID,id);
        cv.put(MyDbContract.FeedEntry.COLUMN_NAME_NAME_POINT_COLLECTE,name);
        cv.put(MyDbContract.FeedEntry.COLUMN_NAME_LAT,lat);
        cv.put(MyDbContract.FeedEntry.COLUMN_NAME_LNG,lng);
        cv.put(MyDbContract.FeedEntry.COLUMN_NAME_ADDRESS,address);
        cv.put(MyDbContract.FeedEntry.COLUMN_NAME_CAPACITY ,capacity);
        cv.put(MyDbContract.FeedEntry.COLUMN_NAME_AVAILABILITY,availabiity);
        cv.put(MyDbContract.FeedEntry.COLUMN_NAME_TYPE,type);
        return dblite.insert(
                MyDbContract.FeedEntry.TABLE_NAME,
                null,
                cv);
    }

    public static Cursor getAllPoints(MyDbHelper dbHelper){
        SQLiteDatabase dblite=dbHelper.getReadableDatabase();
        String[] projection = {
                MyDbContract.FeedEntry.COLUMN_NAME_ENTRY_ID,
                MyDbContract.FeedEntry.COLUMN_NAME_NAME_POINT_COLLECTE,
                MyDbContract.FeedEntry.COLUMN_NAME_LAT,
                MyDbContract.FeedEntry.COLUMN_NAME_LNG,
                MyDbContract.FeedEntry.COLUMN_NAME_ADDRESS,
                MyDbContract.FeedEntry.COLUMN_NAME_CAPACITY,
                MyDbContract.FeedEntry.COLUMN_NAME_AVAILABILITY,
                MyDbContract.FeedEntry.COLUMN_NAME_TYPE
        };
        Cursor cursor=dblite.query(
                MyDbContract.FeedEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        //dblite.close();
        return cursor;
    }


    public Cursor getPointById(MyDbHelper dbHelper,int id){
        SQLiteDatabase dblite=dbHelper.getReadableDatabase();
        String[] projection = {
                MyDbContract.FeedEntry.COLUMN_NAME_ENTRY_ID,
                MyDbContract.FeedEntry.COLUMN_NAME_NAME_POINT_COLLECTE,
                MyDbContract.FeedEntry.COLUMN_NAME_LAT,
                MyDbContract.FeedEntry.COLUMN_NAME_LNG,
                MyDbContract.FeedEntry.COLUMN_NAME_ADDRESS,
                MyDbContract.FeedEntry.COLUMN_NAME_CAPACITY,
                MyDbContract.FeedEntry.COLUMN_NAME_AVAILABILITY,
                MyDbContract.FeedEntry.COLUMN_NAME_TYPE
        };
        Cursor cursor=dblite.query(
                MyDbContract.FeedEntry.TABLE_NAME,
                projection,
                MyDbContract.FeedEntry.COLUMN_NAME_ENTRY_ID+"=?",
                new String[]{
                     String.valueOf(id)
                },
                null,
                null,
                null
        );
        //dblite.close();
        return cursor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LatLng getCoord() {
        return coord;
    }

    public void setCoord(LatLng coord) {
        this.coord = coord;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public float getAvailability() {
        return availability;
    }

    public void setAvailability(float availability) {
        this.availability = availability;
    }

    public PointType[] getType() {
        return type;
    }

    public void setType(PointType[] type) {
        this.type = type;
    }

    public ArrayList<Collecte> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Collecte> history) {
        this.history = history;
    }

    private float availability;
    private PointType[] type;
    private ArrayList<Collecte> history;
}