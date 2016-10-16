package edu.indiana.cs.assignment_7;

import android.*;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Address;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;

//import com.google.android.gms.identity.intents.Address;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.vision.text.Text;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class MapsActivity extends FragmentActivity implements
        OnMapReadyCallback,
        SensorEventListener {

    private static final String TOUCH_TEST = "";
    private GoogleMap mMap;
    private SensorManager mySensorManager;

    //Step Counting relate variable
    private boolean isStep = false;
    private boolean isCount = false;

    //Current Location relate Variables
    private LocationManager locationManager;
    private LocationListener locationListener;
    private Button onbutton;
    LatLng currLoc;

    //Sensor relate Variables
    private HashMap<Integer, String> sensorTypes = new HashMap<Integer, String>();

    {
        sensorTypes.put(Sensor.TYPE_STEP_COUNTER, "TYPE_STEP_COUNTER");
    }


    //Double Tab relate variables
    int startCount = 0;
    boolean activityRunning;

    TextView textView;

    Location currLocation;

    CountDownTimer timer = new CountDownTimer(2500, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
        }

        @Override
        public void onFinish() {
            startCount = 0;
        }
    };

    CountDownTimer stepTimer = new CountDownTimer(1000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
        }

        @Override
        public void onFinish() {
            isCount = true;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        textView = (TextView) findViewById(R.id.textView_TouchAction);

        //-----------------------
        //Current Location
        onbutton = (Button) findViewById(R.id.btn_Reset);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                //Toast.makeText(this, "" + location.getLongitude() + " " + location.getLatitude(), Toast.LENGTH_LONG).show();
                //x = new LatLng(location.getLatitude(), location.getLongitude());
                currLoc = new LatLng(location.getLatitude(), location.getLongitude());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[] {
                            Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.INTERNET
                 }, 10);
                return;
            } else {
                configureButton();
            }

        }

        //-----------------------

        RelativeLayout myLayout = (RelativeLayout) findViewById(R.id.mainActivityTouchingLayout);
        myLayout.setOnTouchListener(new RelativeLayout.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                handleUserTouch(event);

                return true;
            }

            private void handleUserTouch(MotionEvent event) {
                int x = (int) event.getX();
                int y = (int) event.getY();
                String actionString;
                int action = event.getActionMasked();

                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        actionString = "DOWN";
                        Log.v(TOUCH_TEST, "ACTION WAS DOWN");
                        startCount++;
                        break;
                    case MotionEvent.ACTION_POINTER_DOWN:
                        actionString = "POINTER_DOWN";
                        Log.v(TOUCH_TEST, "ACTION WAS POINTER_DOWN");
                        break;
                    case MotionEvent.ACTION_UP:
                        actionString = "UP";
                        Log.v(TOUCH_TEST, "ACTION WAS UP");
                        break;
                    case MotionEvent.ACTION_POINTER_UP:
                        actionString = "POINTER_UP";
                        Log.v(TOUCH_TEST, "ACTION WAS POINTER UP");
                        break;
                    case MotionEvent.ACTION_SCROLL:
                        actionString = "SCROLL";
                        Log.v(TOUCH_TEST, "ACTION WAS SCROLL");
                        startCount = 2;
                        break;
                    case MotionEvent.AXIS_TILT:
                        actionString = "AXIS_TILT";
                        Log.v(TOUCH_TEST, "ACTION WAS AXIS TILT");
                        startCount = 2;
                        break;
                    default:
                        actionString = "NONE";
                        Log.v(TOUCH_TEST, "ACTION WAS NONE");
                        break;
                }
                String touchStatus = "Action " + actionString + " X: " + x + " , Y: " + y + " count: " + startCount;
                textView.setText(touchStatus);

                if (startCount == 1) {
                    timer.start();
                }
                if (startCount == 2) {
                    timer.cancel();
                    startCount = 0;
                    textView.setText("Double Tabbed!");
                    mySensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
                    isStep = !isStep;

                }
                if(isStep)
                    if(isCount)
                        stepCounting();

            }


        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void stepCounting() {
        isCount = false;
        stepTimer.start();
        locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 5000, (float)0.1, locationListener);
        currLoc = new LatLng(39.165341, -86.523567);
        mMap.addMarker(new MarkerOptions().position(currLoc));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(currLoc));

    }

    private void configureButton() {
        onbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 5000, (float)0.1, locationListener);
            }
        });
    }


    private Circle drawCircle(LatLng latLng) {

        CircleOptions options = new CircleOptions()
                .center(latLng)
                .radius(200)
                .fillColor(0x25880000)
                .strokeColor(Color.BLUE)
                .strokeWidth(3);
        return mMap.addCircle(options);
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

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 10);
            }
            return;
        }
        mMap.setMyLocationEnabled(true);
        UiSettings mapSettings = mMap.getUiSettings();
        mapSettings.setCompassEnabled(true);
        mapSettings.setAllGesturesEnabled(false);



        //Toast.makeText(this, currLocation.toString(), Toast.LENGTH_SHORT).show();

        goToLocationZoon(39.165341, -86.523567, 16);

        //goToLocation(39.165341, -86.523567);
        //goToLocationZoon(39.165341, -86.523567, 16);

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


        //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myLoc, 16));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 10: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
    }

    private void goToLocationZoon(double lat, double lng, int zoom) {
        LatLng place = new LatLng(lat, lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(place, zoom);
        mMap.moveCamera(update);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (activityRunning) {
            textView.setText(String.valueOf(event.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }


    //----------------
    // Changing location



    //----------------

}
