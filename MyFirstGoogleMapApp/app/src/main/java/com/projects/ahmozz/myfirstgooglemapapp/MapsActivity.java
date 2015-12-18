package com.projects.ahmozz.myfirstgooglemapapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.projects.ahmozz.myfirstgooglemapapp.metiers.CollectionPoint;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private MyDbHelper mBdHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mBdHelper=new MyDbHelper(getApplicationContext());

        CollectionPoint.addCollectionPoint(mBdHelper,3,"Recyclage sousse",10.0,10.0,"Tunisie,Sousse,Kantaoui",1000.0,900.0,"metal");
        CollectionPoint.addCollectionPoint(mBdHelper,4,"Recyclage bizerte",20.0,10.0,"Tunisie,Bizerte,Cité belvédèr",1000.0,900.0,"plastique");

        Cursor cursor=CollectionPoint.getAllPoints(mBdHelper);
        cursor.moveToFirst();

        do{
            Double lat = cursor.getDouble(cursor.getColumnIndexOrThrow(MyDbContract.FeedEntry.COLUMN_NAME_LAT));
            Double lng = cursor.getDouble(cursor.getColumnIndexOrThrow(MyDbContract.FeedEntry.COLUMN_NAME_LNG));
            String address=cursor.getString(cursor.getColumnIndex(MyDbContract.FeedEntry.COLUMN_NAME_ADDRESS));
            String type=cursor.getString(cursor.getColumnIndex(MyDbContract.FeedEntry.COLUMN_NAME_TYPE));
            String name=cursor.getString(cursor.getColumnIndex(MyDbContract.FeedEntry.COLUMN_NAME_NAME_POINT_COLLECTE));
            double capacity=cursor.getDouble(cursor.getColumnIndex(MyDbContract.FeedEntry.COLUMN_NAME_CAPACITY));
            int id=cursor.getInt(cursor.getColumnIndex(MyDbContract.FeedEntry.COLUMN_NAME_ENTRY_ID));

            mMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title(name+" "+address+" "+type+" "+capacity+" "+id));
        }while (cursor.moveToNext());

            mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
        }
}
