package com.example.shree.btechproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParkingPlaces extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_places);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        new GetAllLocations().execute(new LocationConnector());
    }

    public void LocationsAre(final JSONArray jsonArray) {
        String s = "";
        Bundle bundle = getIntent().getExtras();
        Double Lat = bundle.getDouble("Lat");
        Double Lng = bundle.getDouble("Lng");
        LatLng latlng=new LatLng(Lat,Lng);
        mMap.addMarker(new MarkerOptions().position(latlng).title("You are here!"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng,10.2f));
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = null;

            try {

                jsonObject = jsonArray.getJSONObject(i);
                Double latitude=Double.valueOf(jsonObject.getString("Latitude"));
                Double longitude=Double.valueOf(jsonObject.getString("Longitude"));
                String LocName=jsonObject.getString("LocationName");
                String LocId=jsonObject.getString("LocationId");
                /*Toast toast = Toast.makeText(getApplicationContext(), jsonObject.getString("Latitude"), Toast.LENGTH_LONG);
                toast.show();
                Toast toast1 = Toast.makeText(getApplicationContext(), jsonObject.getString("Longitude"), Toast.LENGTH_LONG);
                toast1.show();
                Toast toast2 = Toast.makeText(getApplicationContext(), jsonObject.getString("LocationId"), Toast.LENGTH_LONG);
                toast2.show();
                Toast toast3 = Toast.makeText(getApplicationContext(), jsonObject.getString("LocationName"), Toast.LENGTH_LONG);
                toast3.show();*/
                LatLng latLng=new LatLng(latitude,longitude);
                mMap.addMarker(new MarkerOptions().position(latLng).title(LocName).snippet(LocId).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,10.2f));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent1 = new Intent(ParkingPlaces.this, ParkHere.class);
                String title = marker.getTitle();
                intent1.putExtra("markertitle", title);
                startActivity(intent1);
            }
        });
    }

    public class GetAllLocations extends AsyncTask<LocationConnector, Long, JSONArray> {
        @Override
        protected JSONArray doInBackground(LocationConnector... params) {
            return params[0].getAllData();
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            LocationsAre(jsonArray);
        }
    }
}
