package com.example.lorrynwinsh.Custom;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.TrackInfo;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class Gallery {
	
	public static int videoCameraResultCode = 1;
	public static int videoGalleryResultCode = 3;
	
	public static int imageCameraResultCode = 2;
	public static int imageGalleryResultCode = 4;
	
	public static int employeeProfileImageCameraResultCode = 5;
	public static int employeeProfileImageGalleryResultCode = 6;
	
	static ProgressDialog progress;
	
	public final static int width = 128;
	public final static int height = 128;



	public static File getDownloadVideoFile(File url, Activity activity){
		
		File mediaStorageDir = new File(Environment.getExternalStorageDirectory()
	              + "/Android/data/"
	              + activity.getPackageName()
	              + "/Videos/"
	              + url.getParentFile().getName()
				); 
		if (! mediaStorageDir.exists()){
			if (! mediaStorageDir.mkdirs()){
				return null;
	        }
	    } 
		File mediaFile;
		String mImageName = url.getName();
		mediaFile = new File(mediaStorageDir.getPath() + File.separator + mImageName);
		mediaFile.delete();
		return mediaFile;
	}

	public static void downloadVideo(Activity activity, String url, File out){
		try{
			DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
			request.setDescription("Downloading video");
			request.setTitle("Cabbie");
			// in order for this if to run, you must use the android 3.2 to compile your app 
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			    request.allowScanningByMediaScanner();
			    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
			} 
			//request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "video.mp4");
			request.setDestinationUri(Uri.fromFile(out));
			// get download service and enqueue file 
			DownloadManager manager = (DownloadManager) activity.getSystemService(Context.DOWNLOAD_SERVICE);
			manager.enqueue(request);
		}
		catch(Exception e){
			Toast.makeText(activity, "Could not download file!", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
	}
	
	public static File getOutputImageFile(Activity activity){
		File mediaStorageDir = new File(Environment.getExternalStorageDirectory()
	              + "/Android/data/"
	              + activity.getPackageName()
	              + "/Files"); 
		if (! mediaStorageDir.exists()){
			if (! mediaStorageDir.mkdirs()){
				return null;
	        }
	    } 
		File mediaFile;
		String mImageName="HT_DP"+".png";
		mediaFile = new File(mediaStorageDir.getPath() + File.separator + mImageName);
		mediaFile.delete();
		return mediaFile;
	}
		  
	public static void ShowProgressDialog(Activity activity){
		HideProgressDialog();
		progress = ProgressDialog.show(activity, "", "Please wait...");
	}
	
	public static void ShowCustomProgressDialog(Activity activity, String text){
		HideProgressDialog();
		progress = ProgressDialog.show(activity, "", text);
	}
	
	public static void HideProgressDialog(){
		if(progress != null){
			progress.dismiss();
			progress = null;
		}
	}
	
	public static File getOutputVideoFile(Activity activity){
		File mediaStorageDir = new File(Environment.getExternalStorageDirectory()
	              + "/Android/data/"
	              + activity.getPackageName()
	              + "/Files"); 
		if (! mediaStorageDir.exists()){
			if (! mediaStorageDir.mkdirs()){
				return null;
	        }
	    } 
		File mediaFile;
		String mImageName;
		if(isKitKatAndAbove()){
			mImageName="HT_DP"+".mp4";
		}
		else {
			mImageName="HT_DP"+".3gp";
		}
		mediaFile = new File(mediaStorageDir.getPath() + File.separator + mImageName);
		mediaFile.delete();
		return mediaFile;
	}

	private static boolean isKitKatAndAbove() {
		int currentapiVersion = Build.VERSION.SDK_INT;
		if (currentapiVersion > Build.VERSION_CODES.JELLY_BEAN_MR2) {
			return true;
		}
		return false;
	}

	@SuppressLint("NewApi")
	public static String getImagePath(Activity activity, Uri uri)
    { 
		int sdk_level = Build.VERSION.SDK_INT;
		if(sdk_level >= 19){
			 String filePath = "";
		        String wholeID = DocumentsContract.getDocumentId(uri);
		 
		         // Split at colon, use second item in the array 
		         String id = wholeID.split(":")[1];
		 
		         String[] column = { MediaStore.Images.Media.DATA };
		 
		         // where id is equal to              
		         String sel = MediaStore.Images.Media._ID + "=?";
		 
		         Cursor cursor = activity.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
		                                   column, sel, new String[]{ id }, null);
		 
		         int columnIndex = cursor.getColumnIndex(column[0]);
		 
		         if (cursor.moveToFirst()) {
		             filePath = cursor.getString(columnIndex);
		         }    
		         cursor.close();
		         return filePath;
		}
		else if(sdk_level > 10 && sdk_level < 19 ){

	          String[] proj = { MediaStore.Images.Media.DATA };
	          String result = null;
	 
	          CursorLoader cursorLoader = new CursorLoader(
	        		  activity, 
	            uri, proj, null, null, null);        
	          Cursor cursor = cursorLoader.loadInBackground();
	 
	          if(cursor != null){
	           int column_index = 
	             cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
	           cursor.moveToFirst();
	           result = cursor.getString(column_index);
	          } 
	          return result; 
		}
		else{
			  String[] proj = { MediaStore.Images.Media.DATA };
               Cursor cursor = activity.getContentResolver().query(uri, proj, null, null, null);
               int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
               cursor.moveToFirst();
               return cursor.getString(column_index);
		}
    }
	
	@SuppressLint("NewApi")
	public static String getVideoPath(Activity activity, Uri uri)
    { 
		int sdk_level = Build.VERSION.SDK_INT;
		if(sdk_level >= 19){
			 String filePath = "";
		        String wholeID = DocumentsContract.getDocumentId(uri);
		 
		         // Split at colon, use second item in the array 
		         String id = wholeID.split(":")[1];
		 
		         String[] column = { MediaStore.Video.Media.DATA };
		 
		         // where id is equal to              
		         String sel = MediaStore.Video.Media._ID + "=?";
		 
		         Cursor cursor = activity.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
		                                   column, sel, new String[]{ id }, null);
		 
		         int columnIndex = cursor.getColumnIndex(column[0]);
		 
		         if (cursor.moveToFirst()) {
		             filePath = cursor.getString(columnIndex);
		         }    
		         cursor.close();
		         return filePath;
		}
		else if(sdk_level > 10 && sdk_level < 19 ){

	          String[] proj = { MediaStore.Video.Media.DATA };
	          String result = null;
	 
	          CursorLoader cursorLoader = new CursorLoader(
	        		  activity, 
	            uri, proj, null, null, null);        
	          Cursor cursor = cursorLoader.loadInBackground();
	 
	          if(cursor != null){
	           int column_index = 
	             cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
	           cursor.moveToFirst();
	           result = cursor.getString(column_index);
	          } 
	          return result; 
		}
		else{
			  String[] proj = { MediaStore.Video.Media.DATA };
               Cursor cursor = activity.getContentResolver().query(uri, proj, null, null, null);
               int column_index = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
               cursor.moveToFirst();
               return cursor.getString(column_index);
		}
    }
	
    public static String getMonthName(String MonthNum){
		if(MonthNum.equals("01")){
			return "Jan";
		}
		else if(MonthNum.equals("02")){
			return "Feb";
		}
		else if(MonthNum.equals("03")){
			return "Mar";
		}
		else if(MonthNum.equals("04")){
			return "Apr";
		}
		else if(MonthNum.equals("05")){
			return "May";
		}
		else if(MonthNum.equals("06")){
			return "Jun";
		}
		else if(MonthNum.equals("07")){
			return "Jul";
		}
		else if(MonthNum.equals("08")){
			return "Aug";
		}
		else if(MonthNum.equals("09")){
			return "Sep";
		}
		else if(MonthNum.equals("10")){
			return "Oct";
		}
		else if(MonthNum.equals("11")){
			return "Nov";
		}
		else if(MonthNum.equals("12")){
			return "Dec";
		}
		else{
			return "Jan";
		}
		
	}

	public static void CopyFile(File src, File dst, Activity activity) throws IOException {
		InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);
     
        // Transfer bytes from in to out
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
        if(dst.exists()){
        	MediaScannerConnection.scanFile(activity, new String[] { dst.getPath() }, null, null);
    	}

//        FileOutputStream out = new FileOutputStream(dst);
//        ObjectOutputStream fout = new ObjectOutputStream(out);
//
//        fout.writeObject(src);
//        fout.close();
//        out.close();
        //activity.sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://"+ Environment.getExternalStorageDirectory())));
	} 

    public static String getFormatedDate(String dateIn){
    	String out = dateIn;
    	String parts[] = dateIn.toString().split("-");
    	out = parts[2] + "-" + getMonthName(parts[1]) + "-" + parts[0];
    	return out;
    }
	
    
	public static File ResizeImage(File in){
		//File out = new File("/storage/emulated/0/Img_resize.png");
		File out = new File(in.getParent() + "/Img_resize.png");
		try{
			BitmapFactory.Options options = new BitmapFactory.Options();
		    options.inJustDecodeBounds = true;
		    Bitmap src = BitmapFactory.decodeFile(in.getAbsolutePath(), options );
		    
		    
		    ExifInterface ei = new ExifInterface(in.getAbsolutePath());
		    int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
		    int rotation = 0;
		    
		    switch(orientation) {
		    	case ExifInterface.ORIENTATION_ROTATE_90:
		            rotation = 90; 
		            break; 
		        case ExifInterface.ORIENTATION_ROTATE_180:
		            rotation = 180; 
		            break; 
		        case ExifInterface.ORIENTATION_ROTATE_270:
		            rotation = 270; 
		            break; 
		        // etc. 
		    } 
		    Matrix mat = new Matrix();
		    
		    mat.postRotate(rotation);
		    
		    if(rotation == 0 || rotation == 180){
		    	float xFactor = (float)width;
			    float yFactor = (float)height;
				if(xFactor > yFactor){
		    		options.outWidth = (int)((float)((float)options.outWidth * yFactor));
		    		options.outHeight = (int)((float)((float)options.outHeight * yFactor));
		    		mat.postScale(yFactor, yFactor);
				}
			    else{
			    	options.outWidth = (int)((float)((float)options.outWidth * xFactor));
		    		options.outHeight = (int)((float)((float)options.outHeight * xFactor));
		    		mat.postScale(xFactor, xFactor);
				}
			}
		    else{
		    	float xFactor = (float)width/(float)options.outHeight;
			    float yFactor = (float)height/(float)options.outWidth;
				if(xFactor > yFactor){
					options.outWidth = (int)((float)((float)options.outHeight * yFactor));
		    		options.outHeight = (int)((float)((float)options.outWidth * yFactor));
		    		mat.postScale(yFactor, yFactor);
			    }
			    else{
			    	options.outWidth = (int)((float)((float)options.outHeight * xFactor));
		    		options.outHeight = (int)((float)((float)options.outWidth * xFactor));
		    		mat.postScale(xFactor, xFactor);
				}
			}
		    options.inJustDecodeBounds = false;
		    
		    src = BitmapFactory.decodeFile(in.getAbsolutePath(), options );
    		
		    src = Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), mat, false);
		    
		    int newWidth = src.getWidth();
		    int newHeight = src.getHeight();
		    float factor = 1;
		    
		    if(src.getWidth() > src.getHeight()){
		    	factor = src.getHeight()/height;
		    	newHeight = height;
		    	newWidth = (int) ((src.getWidth()/factor));
		    }
		    else {
		    	factor = src.getWidth()/width;
		    	newWidth = width;
		    	newHeight = (int) ((src.getHeight()/factor));
		    }
		    
		    Bitmap scaledBmp = Bitmap.createScaledBitmap(src, newWidth, newHeight, false);
    		
//		    Bitmap output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
//			
//		    Canvas c = new Canvas(output);
//		    c.drawColor(Color.BLACK);
		    
//		    Paint filterPaint = new Paint();
//		    filterPaint.setFilterBitmap(true);
//		    filterPaint.setMaskFilter(new BlurMaskFilter(8, BlurMaskFilter.Blur.NORMAL));
		    
//		    c.drawBitmap(scaledBmp, (width - scaledBmp.getWidth())/2, (height - scaledBmp.getHeight())/2, new Paint());
		    
		    FileOutputStream fos = new FileOutputStream(out);
          
		    
		    scaledBmp.compress(Bitmap.CompressFormat.PNG, 100, fos);
          //fos.write(data);
          
          fos.close(); fos = null;
          //c = null;
          src.recycle(); src = null;
          scaledBmp.recycle(); scaledBmp = null;
          //output.recycle(); output = null;
		  ei = null;
          return out;
		}
		catch(Exception e){
			return out;
		}
	}

	public static boolean doesVideoContainsAudio(Context context, Object soundFile)
    {
      boolean result = false;
      MediaPlayer mp = new MediaPlayer();
      try
      {
        Class<? extends Object> currentArgClass = soundFile.getClass();
        if(currentArgClass == Integer.class)
        {
          AssetFileDescriptor afd = context.getResources().openRawResourceFd((Integer)soundFile);
              mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
              
              afd.close();
        }
        else if(currentArgClass == String.class)
        {
          mp.setDataSource((String)soundFile);
        }
        else if(currentArgClass == File.class)
        {
          mp.setDataSource(((File)soundFile).getAbsolutePath());
        }
        mp.prepare();
        for(TrackInfo t: mp.getTrackInfo()){
        	if(t.getTrackType() == (TrackInfo.MEDIA_TRACK_TYPE_AUDIO))
        		result = true;
        }
      }
      catch(Exception e)
      {
      //  Logger.e(e.toString());
      }
      finally
      {
    	mp.reset();
        mp.release();
        mp = null;
      }
      return result;
    }
    
	public static long getDurationOfVideo(Context context, File file)
    {
      int millis = 0;
      MediaPlayer mp = new MediaPlayer();
      try
      {
        mp.setDataSource("file://" + file.getAbsolutePath());
        mp.prepare();
        millis = mp.getDuration();
      }
      catch(Exception e)
      {
    	  try {
			mp.setDataSource(file.getAbsolutePath());
			mp.prepare();
			millis = mp.getDuration();
	    } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
         e.printStackTrace();
      }
      finally
      {
        mp.reset();
        mp.release();
        mp = null;
      }
      return millis;
    }
    public static long getDurationOfSound(Context context, Object soundFile)
    {
      int millis = 0;
      MediaPlayer mp = new MediaPlayer();
      try
      {
        Class<? extends Object> currentArgClass = soundFile.getClass();
        if(currentArgClass == Integer.class)
        {
          AssetFileDescriptor afd = context.getResources().openRawResourceFd((Integer)soundFile);
              mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
              
              afd.close();
        }
        else if(currentArgClass == String.class)
        {
          mp.setDataSource((String)soundFile);
        }
        else if(currentArgClass == File.class)
        {
          mp.setDataSource(((File)soundFile).getAbsolutePath());
        }
        mp.prepare();
        millis = mp.getDuration();
      }
      catch(Exception e)
      {
      //  Logger.e(e.toString());
      }
      finally
      {
    	mp.reset();
        mp.release();
        mp = null;
      }
      return millis;
    }

    /** 
     * @param context used to check the device version and DownloadManager information 
     * @return true if the download manager is available 
     */ 
    public static boolean isDownloadManagerAvailable(Context context) {
        try { 
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD) {
                return false; 
            } 
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.setClassName("com.android.providers.downloads.ui", "com.android.providers.downloads.ui.DownloadList");
            List<ResolveInfo> list = context.getPackageManager().queryIntentActivities(intent,
                    PackageManager.MATCH_DEFAULT_ONLY);
            return list.size() > 0;
        } catch (Exception e) {
            return false; 
        } 
    } 

}
