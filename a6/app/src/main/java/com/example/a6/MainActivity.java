package com.example.a6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LocationListener {
    TextView latitude, longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        latitude = findViewById(R.id.latitude);
        longitude = findViewById(R.id.longitude);
        LocationManager locationManager =  (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) this);

    }
    @Override
    public void onLocationChanged(Location location) {
        latitude.setText(Double.toString(location.getLatitude()));
        longitude.setText(Double.toString(location.getLongitude()));
    }
    public void onSubmitBtnClick(View v){
        EditText editText = (EditText) findViewById(R.id.locationInput);
        try {
            Geocoder geocoder = new Geocoder(MainActivity.this);
            List<Address> list = geocoder.getFromLocationName(editText.getEditableText().toString(), 1);
            if(list!=null && list.size()>0){
                Address adr=list.get(0);
                latitude.setText(Double.toString(adr.getLatitude()));
                longitude.setText(Double.toString(adr.getLongitude()));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}