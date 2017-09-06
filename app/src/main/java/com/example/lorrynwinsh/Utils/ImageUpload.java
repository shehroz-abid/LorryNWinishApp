package com.example.lorrynwinsh.Utils;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Base64;

import com.example.lorrynwinsh.Constants.Constants;
import com.example.lorrynwinsh.Custom.Helper;

import java.io.ByteArrayOutputStream;
import java.io.File;

/**
 * Created by Ali on 9/22/2016.
 */

public class ImageUpload extends IntentService {

    public ImageUpload() {
        super("ReminderService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int index = intent.getIntExtra("index", 0);
        String path = null;
        if (android.os.Build.MANUFACTURER.equalsIgnoreCase("samsung") && Constants.isCameraSelected){
            Constants.isCameraSelected = false;
            path = Constants.uploadImagePath;
        }
        else {
            path = intent.getStringExtra("path");
            if (path == null) return;
        }
        if (intent == null) return;
        String name = intent.getStringExtra("name");
        File orignalFile = new File(path);
        File decodedFile = null;
        long fileSizeInBytes = orignalFile.length();
        // Convert the bytes to Kilobytes (1 KB = 1024 Bytes)
        long fileSizeInKB = fileSizeInBytes / 1024;
        if (fileSizeInKB > 500) {
            decodedFile = Helper.decodeFile(path);
        }
        Bitmap bm = null;
        if (decodedFile == null) {
            bm = BitmapFactory.decodeFile(orignalFile.getAbsolutePath());
        } else {
            bm = BitmapFactory.decodeFile(decodedFile.getAbsolutePath());
        }
        if (bm == null) {
            Intent i = new Intent("com.app.theonefinderapp.IMAGE_UPLOADED");
            i.putExtra("error", "error occured");
            i.putExtra("path", path);
            i.putExtra("index", index);
            LocalBroadcastManager.getInstance(this).sendBroadcastSync(i);
            return;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
        byte[] byteArrayImage = baos.toByteArray();
        String encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);

    }
}
