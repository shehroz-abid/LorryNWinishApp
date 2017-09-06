package com.example.lorrynwinsh.Fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lorrynwinsh.Gui.DisplayRoute;
import com.example.lorrynwinsh.R;
import com.example.lorrynwinsh.Utils.GPSTracker;
import com.example.lorrynwinsh.Utils.LocationUtils;
import com.example.lorrynwinsh.Utils.PermissionUtils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by macbookpro on 07/06/2017.
 */

public class HomeFragment extends Fragment implements OnMapReadyCallback, ActivityCompat.OnRequestPermissionsResultCallback, View.OnClickListener {
    private GoogleMap mMap;
    private UiSettings mUiSettings;
    SupportMapFragment mapFragment;
    private View v;
    GPSTracker gps;
    int initial_flag = 0;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private static final int COARSE_LOCATION_PERMISSION_REQUEST_CODE = 2;
    private boolean mPermissionDenied = false;

    private String currentCountryName, currentCity = "";
    private LatLng currentLatLng;
    Marker currentMarker = null;
    ImageView myLocationImg, destinationCancelImg, searchImageIcon;
    Button pickUpLocationBtn, requestRideBtn;
    RelativeLayout estimatedTimeLayout, priceLayout, promoCodeLayout, pickup_address_rl, pickup1_address_rl, destination_address_rl;
    TextView estimatedPickuptime_tv, priceValue_tv, promoStatus_tv, firstAddress_lbl, pickup_address_value;
    TextView pickupAddress1_lbl, pickup1_address_value, destinationAddress1_lbl, destination1_address_value;
    CardView pickupAddressLayout, pickupAndDestinationLayout;

    public static HomeFragment newInstance(){
        HomeFragment f = new HomeFragment();

        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try{
            ((DisplayRoute)getActivity()).toolBarTitleTextView.setText("Book Ride");
            v = inflater.inflate(R.layout.fragment_home,container,false);
            mapFragment = (SupportMapFragment) getChildFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

            myLocationImg = (ImageView) v.findViewById(R.id.mylocation_img);
            myLocationImg.setOnClickListener(this);
            gps = new GPSTracker(getActivity());

            findViews(v);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return v;
    }

    private void findViews(View v){
        pickUpLocationBtn = (Button) v.findViewById(R.id.pickthislocationBtn);
        requestRideBtn = (Button) v.findViewById(R.id.requestRideBtn);

        estimatedTimeLayout = (RelativeLayout) v.findViewById(R.id.estimatedTimeLayout);
        priceLayout = (RelativeLayout) v.findViewById(R.id.priceLayout);
        promoCodeLayout = (RelativeLayout) v.findViewById(R.id.promoCodeLayout);
        pickup_address_rl = (RelativeLayout) v.findViewById(R.id.pickup_address_rl);
        pickup1_address_rl = (RelativeLayout) v.findViewById(R.id.pickup1_address_rl);
        destination_address_rl = (RelativeLayout) v.findViewById(R.id.destination_address_rl);

        estimatedPickuptime_tv = (TextView)  v.findViewById(R.id.estimatedPickuptime_tv);
        priceValue_tv = (TextView)  v.findViewById(R.id.priceValue_tv);
        promoStatus_tv = (TextView)  v.findViewById(R.id.promoStatus_tv);
        firstAddress_lbl = (TextView)  v.findViewById(R.id.firstAddress_lbl);
        pickup_address_value = (TextView)  v.findViewById(R.id.pickup_address_value);
        pickupAddress1_lbl = (TextView)  v.findViewById(R.id.pickupAddress1_lbl);
        pickup1_address_value = (TextView)  v.findViewById(R.id.pickup1_address_value);
        destinationAddress1_lbl = (TextView)  v.findViewById(R.id.destinationAddress1_lbl);
        destination1_address_value = (TextView)  v.findViewById(R.id.destination1_address_value);

        pickupAddressLayout = (CardView) v.findViewById(R.id.pickupAddressLayout);
        pickupAndDestinationLayout = (CardView) v.findViewById(R.id.pickupAndDestinationLayout);

        destinationCancelImg = (ImageView) v.findViewById(R.id.crossimg1);
        searchImageIcon = (ImageView) v.findViewById(R.id.searchimg);

        pickUpLocationBtn.setOnClickListener(this);
        requestRideBtn.setOnClickListener(this);
        pickup_address_rl.setOnClickListener(this);
        destinationCancelImg.setOnClickListener(this);
        searchImageIcon.setOnClickListener(this);
        firstAddress_lbl.setOnClickListener(this);
        pickup_address_value.setOnClickListener(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mUiSettings = mMap.getUiSettings();
        mUiSettings.setZoomControlsEnabled(false);
        mUiSettings.setCompassEnabled(false);
        mUiSettings.setMyLocationButtonEnabled(false);
        mUiSettings.setMapToolbarEnabled(false);
        enableMyLocation();

        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (getActivity() != null)
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    setUpMapsAndCurrentLocation();
                                }
                            });
                    }
                }, 1000 * 1);

            }
        });

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                if (currentMarker != null) {
                    currentMarker.remove();
                    currentMarker = null;
                }
                if (currentMarker == null && mMap != null) {
                    currentMarker = mMap.addMarker(new MarkerOptions().position(latLng).draggable(true));
                    setUpAddress(latLng);
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                }

            }
        });

        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {

            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                String text = setUpAddress(marker.getPosition());
                marker.setTitle(text);
            }
        });

        mMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
            double previousZoom=-1.0;
            final int ZOOM_LIMIT=16;
            @Override
            public void onCameraChange(CameraPosition position) {
                if (position.zoom>ZOOM_LIMIT && (previousZoom<=ZOOM_LIMIT || previousZoom==-1.0)) {
//                    Toast.makeText(getActivity(), "one", Toast.LENGTH_SHORT).show();
                }
                else if (position.zoom<=ZOOM_LIMIT && (previousZoom>ZOOM_LIMIT || previousZoom==-1.0)) {
//                    Toast.makeText(getActivity(), "two", Toast.LENGTH_SHORT).show();
                    setUpAddress(position.target);
                }
            }
        });

//        mMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
//            @Override
//            public void onCameraIdle() {
//                if(initial_flag!=0)
//                {
//                    setUpAddress(currentLatLng);
//                }
//                initial_flag++;
//            }
//        });
    }

    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtils.requestPermission(getActivity(), LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE || requestCode != COARSE_LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                // Permission to access the location is missing.
                PermissionUtils.requestPermission(getActivity(), COARSE_LOCATION_PERMISSION_REQUEST_CODE,
                        Manifest.permission.ACCESS_COARSE_LOCATION, true);
            }
//            enableMyLocation();
        }
        else {
            // Display the missing permission error dialog when the fragments resume.
            mPermissionDenied = true;
        }
        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_COARSE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation();
        }
        else {
            // Display the missing permission error dialog when the fragments resume.
            mPermissionDenied = true;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPermissionDenied) {
            // Permission was not granted, display error dialog.
            showMissingPermissionError();
            mPermissionDenied = false;
        }
        if (mMap != null){
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    setUpMapsAndCurrentLocation();
                }
            }, 1500);
        }
    }

    private boolean checkReady() {
        if (mMap == null) {
            Toast.makeText(getContext(), "Map is not ready yet", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void setUpMapsAndCurrentLocation() {
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (getActivity() == null) return;
                final LatLng latLng = LocationUtils.setUpMapsAndCurrentLocation(getActivity());
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (checkReady() && latLng != null) {
                            if (currentMarker != null) {
                                currentMarker.remove();
                                currentMarker = null;
                            }
                            if (currentMarker == null) {
                                currentMarker = mMap.addMarker(new MarkerOptions().position(latLng)
                                        .draggable(true));
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                                // Zoom in the Google Map
                                mMap.animateCamera(CameraUpdateFactory.zoomTo(15.8f));
                            }
                            setUpAddress(latLng);
                        }
                    }
                });
            }
        });
    }

    String setUpAddress(LatLng latLng) {
//        OneFinderApplication.pref.edit().putFloat(Constants.KEY_LAST_KNOWN_LATITIDE, (float) latLng.latitude).apply();
//        OneFinderApplication.pref.edit().putFloat(Constants.KEY_LAST_KNOWN_LONGITUDE, (float) latLng.longitude).apply();
        Geocoder geocoder;
        List<Address> addresses;
        String addressTosend = "My Location";
        geocoder = new Geocoder(getContext(), Locale.getDefault());
        try {
            addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
            String address = "";
           /* for (int i = 0; i <= addresses.get(0).getMaxAddressLineIndex(); i++) {
                address += addresses.get(0).getAddressLine(i) + " ";
            }*/
            if (addresses.size() == 0){
                return "";
            }
            address += addresses.get(0).getAddressLine(0);
            String city = addresses.get(0).getLocality();
            String state = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String postalCode = addresses.get(0).getPostalCode();
            String knownName = addresses.get(0).getFeatureName();
            String subLocal = addresses.get(0).getSubLocality();
            Log.v("address", "address " + address + "\n"
                    + "subLocal " + subLocal + "\n"
                    + "city " + city + "\n"
                    + "state " + state + "\n"
                    + "country " + country + "\n"
                    + "postalCode " + postalCode + "\n"
                    + "knownName " + knownName);
            currentCountryName = country;
            currentCity = city;
            currentLatLng = latLng;

            firstAddress_lbl.setText(String.format("%s", address));
            pickup_address_value.setText(String.format("%s %s", city,country));
        } catch (IOException e) {

            e.printStackTrace();
        }
        return addressTosend;
    }

    /**
     * Displays a dialog with error message explaining that the location permission is missing.
     */
    private void showMissingPermissionError() {
        PermissionUtils.PermissionDeniedDialog
                .newInstance(true).show(getChildFragmentManager(), "dialog");
    }

    @Override
    public void onDestroyView() {
        if (mapFragment != null) {
            mapFragment = null;
        }
//        if (mMap != null) {
//            mMap.clear();
//            mMap = null;
//        }
        super.onDestroyView();
    }
    private void locateUser(){
        if(gps.canGetLocation()){
            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();
            LatLng LatitudeLong = new LatLng(latitude,longitude);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(LatitudeLong));
        }else{
            gps.showSettingsAlert();
        }
    }

    private void actionPickUpLocation(){
        ((DisplayRoute)getActivity()).homeMenuButton.setVisibility(View.INVISIBLE);
        ((DisplayRoute)getActivity()).homeBackButton.setVisibility(View.VISIBLE);
        ((DisplayRoute)getActivity()).homeBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionDestinationCancel();
            }
        });
        pickupAndDestinationLayout.setVisibility(View.VISIBLE);
        pickupAddressLayout.setVisibility(View.GONE);
        pickUpLocationBtn.setVisibility(View.INVISIBLE);
        requestRideBtn.setVisibility(View.VISIBLE);
        estimatedTimeLayout.setVisibility(View.VISIBLE);
    }

    private void actionRequestRide(){
//        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout1, RideConfirmedFragment.newInstance(), "RideConfirmedFragment").commit();
    }

    private void actionPickupAddress1(){

    }

    public void actionDestinationCancel(){
        ((DisplayRoute)getActivity()).homeMenuButton.setVisibility(View.VISIBLE);
        ((DisplayRoute)getActivity()).homeBackButton.setVisibility(View.GONE);
        pickupAndDestinationLayout.setVisibility(View.GONE);
        pickupAddressLayout.setVisibility(View.VISIBLE);
        pickUpLocationBtn.setVisibility(View.VISIBLE);
        requestRideBtn.setVisibility(View.INVISIBLE);
        estimatedTimeLayout.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        if (v == myLocationImg){
            locateUser();
        }
        else if (v == pickUpLocationBtn){
            //actionPickUpLocation();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout1, OrderHistoryFragment.newInstance(), "OrderHistoryFragment").addToBackStack(null).commit();
        }
        else if (v == requestRideBtn){
            actionRequestRide();
        }
        else if (v == pickup1_address_rl){
            actionPickupAddress1();
        }
        else if (v == destinationCancelImg){
            actionDestinationCancel();
        }
        else if (v == searchImageIcon || v == firstAddress_lbl || v == pickup_address_value){
//            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout1, SearchAddressFragment.newInstance(String.valueOf(gps.getLatitude()),String.valueOf(gps.getLongitude())), "SearchAddressFragment").commit();
        }
    }

}
