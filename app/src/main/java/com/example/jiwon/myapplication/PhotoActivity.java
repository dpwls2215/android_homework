package com.example.jiwon.myapplication;

import android.app.FragmentManager;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class PhotoActivity extends AppCompatActivity
        implements OnMapReadyCallback, View.OnClickListener,GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {


    //지도에 관광지 표시 변수
    public double v_pos;
    public double v1_pos;
    public Button Roadbtn;
    public List<Address> list = null;
    public TextView tv;
    public Geocoder geocoder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        tv = (TextView) findViewById(R.id.address);
        geocoder = new Geocoder(this);
        v_pos = 37.553802;
        v1_pos = 126.969598;

        Roadbtn = (Button) findViewById(R.id.roadbtn);
        Roadbtn.setOnClickListener(this);

        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment) fragmentManager
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        change_road();


    }

    //위도_경도 변환
    public  void change_road(){
        try {

            list = geocoder.getFromLocation(
                    v_pos, // 위도
                    v1_pos, // 경도
                    10); // 얻어올 값의 개수
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("test", "입출력 오류 - 서버에서 주소변환시 에러발생");
        }
        if (list != null) {
            if (list.size() == 0) {
                tv.setText("해당되는 주소 정보는 없습니다");
            } else {

                tv.setText(list.get(0).getAddressLine(0));
            }
        }
    }



    @Override
    public void onMapReady(final GoogleMap map) {

        LatLng SEOUL = new LatLng(v_pos, v1_pos);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        map.addMarker(markerOptions);
        map.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        map.animateCamera(CameraUpdateFactory.zoomTo(15));
    }

    @Override
    public void onClick(View view) {
        String urlplus = "http://maps.google.com/maps?f=d&saddr=출발지주소&daddr="+list.get(0).getAddressLine(0)+"&hl=ko";
        Uri uri = Uri.parse(urlplus);
        Intent it = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(it);
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}