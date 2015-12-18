package com.projects.ahmozz.myfirstgooglemapapp.metiers;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.projects.ahmozz.myfirstgooglemapapp.MyDbContract;
import com.projects.ahmozz.myfirstgooglemapapp.MyDbHelper;

import java.util.ArrayList;

/**
 * Created by ahmozz on 08/12/15.Z
 */
public class User {
    private int id;
    private String name;
    private String lastName;
    private String login;
    private Role role;
    private ArrayList<Collecte> history;


    public User(int id, String name, String lastName, String login) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.role = Role.membre;
    }

    public User() {

    }


    public static void addUser(){

    }


    public static Cursor getUserById(MyDbHelper dbHelper,int id){
        SQLiteDatabase dblite=dbHelper.getReadableDatabase();
        String[] projection = {
                MyDbContract.FeedEntry2.COLUMN_NAME_ENTRY_ID,
                MyDbContract.FeedEntry2.COLUMN_NAME_NAME_USER,
                MyDbContract.FeedEntry2.COLUMN_NAME_LAST_NAME_USER,
                MyDbContract.FeedEntry2.COLUMN_NAME_LOGIN_USER,
                MyDbContract.FeedEntry2.COLUMN_NAME_ROLE_USER
        };
        Cursor cursor=dblite.query(
                MyDbContract.FeedEntry2.TABLE_NAME,
                projection,
                MyDbContract.FeedEntry2.COLUMN_NAME_ENTRY_ID+"=?",
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
    public static Cursor getAllUsers(MyDbHelper dbHelper,int id){
        SQLiteDatabase dblite=dbHelper.getReadableDatabase();
        String[] projection = {
                MyDbContract.FeedEntry2.COLUMN_NAME_ENTRY_ID,
                MyDbContract.FeedEntry2.COLUMN_NAME_NAME_USER,
                MyDbContract.FeedEntry2.COLUMN_NAME_LAST_NAME_USER,
                MyDbContract.FeedEntry2.COLUMN_NAME_LOGIN_USER,
                MyDbContract.FeedEntry2.COLUMN_NAME_ROLE_USER
        };
        Cursor cursor=dblite.query(
                MyDbContract.FeedEntry2.TABLE_NAME,
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
