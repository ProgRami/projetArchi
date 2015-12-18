package com.projects.ahmozz.myfirstgooglemapapp.metiers;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.projects.ahmozz.myfirstgooglemapapp.MyDbContract;
import com.projects.ahmozz.myfirstgooglemapapp.MyDbHelper;

/**
 * Created by ahmozz on 08/12/15.
 */
public class Collecte {
    int id;
    String date;
    User user;
    CollectionPoint collectionPoint;


    public static Cursor getAllHistory(MyDbHelper dbHelper){
        SQLiteDatabase dblite=dbHelper.getReadableDatabase();
        String[] projection = {
                MyDbContract.FeedEntry1.COLUMN_NAME_ENTRY_ID,
                MyDbContract.FeedEntry1.COLUMN_NAME_USER_ID,
                MyDbContract.FeedEntry1.COLUMN_NAME_pointCollecte_ID,
                MyDbContract.FeedEntry1.COLUMN_NAME_DATE,
        };
        Cursor cursor=dblite.query(
                MyDbContract.FeedEntry1.TABLE_NAME,
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
}