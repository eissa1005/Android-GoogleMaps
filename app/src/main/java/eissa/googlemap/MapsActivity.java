package com.example.eissa.googlemap;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap mMap;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (mMap != null) {

            // Al Nadi Street latitude 30.78784 and longitude 31.00120
            LatLng alNadi = new LatLng(30.795191, 30.985731);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(alNadi, 8));
            Marker marker = mMap.addMarker(new MarkerOptions().position(alNadi).title("Al Nadi").snippet("Al Nadi Street  Street in Tanta"));

            // infoWindow show latitude and longitude on Map
            marker.showInfoWindow();

            // Create Marker different Code
            LatLng Sa3deldeen = new LatLng(30.788127, 30.996525);
            mMap.addMarker(new MarkerOptions().position(Sa3deldeen).title("Sa3d eldeen").snippet("Sa3d eldeen Street in Tanta"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Sa3deldeen));

           // Create Line between Two  Marker
            Polygon polygon=mMap.addPolygon(new PolygonOptions()
                    // Said Street latitude 30.78784 and longitude 31.00120
            .add(new LatLng(30.788127, 30.996525),
                    new LatLng(30.795191, 30.985731)));


            // on event setOnMapClickListener show latitude and longitude
            final  Context c =this;
            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    Toast.makeText(c,latLng.latitude+"_"+latLng.longitude, Toast.LENGTH_SHORT).show();
                }
            });

            // Show on MapUI Zoom in and zoom out
            mMap.getUiSettings().setZoomControlsEnabled(true);
            // Show Rotate
            mMap.getUiSettings().setRotateGesturesEnabled(true);
            mMap.getUiSettings().setScrollGesturesEnabled(true);
            mMap.getUiSettings().setTiltGesturesEnabled(false);

        }else {
            mMap.getUiSettings().setZoomControlsEnabled(false);
            mMap.getUiSettings().setRotateGesturesEnabled(true);
            mMap.getUiSettings().setScrollGesturesEnabled(true);
            mMap.getUiSettings().setTiltGesturesEnabled(true);
        }

    }
}

