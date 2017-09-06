package com.example.lorrynwinsh.Constants;

import android.net.Uri;
import android.widget.ImageView;

/**
 * Created by macbookpro on 31/07/2017.
 */

public class Constants {

    public static String uploadImagePath = null;
    public static boolean isCameraSelected = false;

    public static ImageView currentProfileImage = null;
    public static Uri userProfileImageLink = null;

    public static String kMapKeyGoogleApi = "AIzaSyAnoolaLzx8Nqf54DfolZVCe61PiEEg4Y8";//"AIzaSyCzDpTj8BDMz3iO6c8dVmNGKSkJBbt5oH0";
    public static String kMapURLNearby ="https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
    public static String kMapURLLive ="https://maps.googleapis.com/maps/api/place/textsearch/json?query=";
    public static String kMapURLGeocode ="https://maps.googleapis.com/maps/api/geocode/json?address=";
    public static String kMapURLDirection ="https://maps.googleapis.com/maps/api/directions/json?origin=";
    public int kNearbyServiceAreaDistanceInMeters =200;

}
