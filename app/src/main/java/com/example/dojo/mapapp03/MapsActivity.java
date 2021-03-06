package com.example.dojo.mapapp03;

import android.graphics.Color;
import android.icu.lang.UCharacter;
import android.icu.text.RelativeDateTimeFormatter;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

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

//        //線を描く
//        PolylineOptions line=new PolylineOptions();
//        line.add(japan);
//        line.add(canada);
//        //色、太さ、測地線
//        line.color(Color.BLUE);
//        line.width(20);
//        line.geodesic(true);
//        mMap.addPolyline(line);

//        //３地点を結ぶ半透明の三角形を描く
//        PolygonOptions options=new PolygonOptions();
//        options.add(japan,sydney,canada);
//        options.strokeColor(Color.BLUE);
//        options.strokeWidth(5);
//        options.fillColor(Color.argb(100,0,220,100));
//        options.geodesic(true);
//        mMap.addPolygon(options);

        //3地点を中心とする半透明の円を描く（３つの円が重なるように大きさを調整）
        CircleOptions circle=new CircleOptions();
        circle.center(japan);
        circle.center(sydney);
        circle.center(canada);
        circle.strokeColor(Color.BLUE);
        circle.strokeWidth(5);
        circle.fillColor(Color.argb(100,0,220,100));
        circle.radius(500000);


        mMap.addCircle(circle);


    }
}
