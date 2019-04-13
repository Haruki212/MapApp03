package com.example.dojo.mapapp03;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // シドニーの緯度経度を設定して、そこにマーカーを設置
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //日本のどこかの緯度経度を設定して、そこにマーカーを設置
        LatLng japan=new LatLng(40.834038, 140.725922);
        mMap.addMarker(new MarkerOptions().position(japan).title("Marker in japan"));


        //北米のどこかの緯度経度を設定して、そこにマーカーを設置
        LatLng canada=new LatLng(53.546170, -113.494681);
        mMap.addMarker(new MarkerOptions().position(canada).title("Marker in canada"));

        //カメラの位置とズームを設定
        LatLng center=new LatLng(31.849963, -167.768752);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center, 2));
    }
}
