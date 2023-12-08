package com.example.sltravelguide;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.sltravelguide.databinding.ActivityKandyMapsBinding;

public class kandyMapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private ActivityKandyMapsBinding binding;
    private static final int LOCATION_PERMISSION_CODE = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityKandyMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (isLocationPermissionGranted()) {
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }else {
            //request location permission
            requestLocationPermission();
        }
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng kandy = new LatLng(7.296756965457324, 80.64105810810207);
        mMap.addMarker(new MarkerOptions().position(kandy).title("Kandy"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kandy,18.0f));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED){
            mMap.setMyLocationEnabled(true);
        }
    }
    //check the location permission_Granted or not
    private boolean isLocationPermissionGranted(){
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED){
            return true;
        }else {
            return false;
        }
    }
    //request location permission
    private void requestLocationPermission(){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                LOCATION_PERMISSION_CODE);
    }
}