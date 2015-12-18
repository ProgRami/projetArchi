package com.projects.ahmozz.myfirstgooglemapapp;

import android.provider.BaseColumns;

/**
 * Created by ahmozz on 14/12/15.
 */
public final class MyDbContract {

    public MyDbContract() {}

    /* Inner class that defines the table contents */
    public static abstract class FeedEntry  {
        public static final String TABLE_NAME = "pointCollecte";
        public static final String COLUMN_NAME_ENTRY_ID = "id_pointCollecte";
        public static final String COLUMN_NAME_NAME_POINT_COLLECTE = "name_pointCollecte";
        public static final String COLUMN_NAME_LAT = "lat_pointCollecte";
        public static final String COLUMN_NAME_LNG = "lng_pointCollecte";
        public static final String COLUMN_NAME_ADDRESS = "address_pointCollecte";
        public static final String COLUMN_NAME_CAPACITY = "capacity_pointCollecte";
        public static final String COLUMN_NAME_AVAILABILITY = "availability_pointCollecte";
        public static final String COLUMN_NAME_TYPE = "type_pointCollecte";
    }
    public static abstract class FeedEntry1  {
        public static final String TABLE_NAME = "collecte";
        public static final String COLUMN_NAME_ENTRY_ID = "id_collecte";
        public static final String COLUMN_NAME_USER_ID = "user_id";
        public static final String COLUMN_NAME_pointCollecte_ID = "pointCollecte_id";
        public static final String COLUMN_NAME_DATE = "date_collecte";
    }
    public static abstract class FeedEntry2  {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME_ENTRY_ID = "id_user";
        public static final String COLUMN_NAME_NAME_USER = "name_user";
        public static final String COLUMN_NAME_LAST_NAME_USER = "lastName_user";
        public static final String COLUMN_NAME_LOGIN_USER = "login_user";
        public static final String COLUMN_NAME_ROLE_USER = "role_user";
    }
}