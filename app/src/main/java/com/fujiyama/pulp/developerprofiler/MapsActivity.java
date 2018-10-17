package com.fujiyama.pulp.developerprofiler;

import android.content.Context;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.fujiyama.pulp.developerprofiler.config.DeveloperProfiler;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = MapsActivity.class.getSimpleName();
    private SupportMapFragment mapFragment;
    private GoogleMap map;
    private String userLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        userLocation = DeveloperProfiler.getUser().getLocation();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;

        try {
            boolean success = googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.mapstyle));

            if(!success) {
                Log.w(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: " + e);
        }

        LatLng location = getLatLongFromLocation(this, userLocation);

        map.addMarker(new MarkerOptions().position(location).title("Marker in " + userLocation));
        map.moveCamera(CameraUpdateFactory.newLatLng(location));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 13));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(location)
                .zoom(12)
                .build();

        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    public LatLng getLatLongFromLocation(Context context, String location) {
        Geocoder geocoder = new Geocoder(context);
        List<Address> address;
        LatLng locationPoint = null;

        try {
            address = geocoder.getFromLocationName(location, 5);

            if(address == null) {
                return null;
            }

            Address targetAddress = address.get(0);

            locationPoint = new LatLng(targetAddress.getLatitude(), targetAddress.getLongitude());
        } catch (IOException e) {
            Log.e(TAG, "Failed to get lat long values. Error: " + e);
        }

        return locationPoint;
    }
}
