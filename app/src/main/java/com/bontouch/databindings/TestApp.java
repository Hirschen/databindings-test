package com.bontouch.databindings;

import android.app.Application;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

/**
 * Created by Christoffer Hirsimaa on 31/08/15.
 */
public class TestApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
				.defaultDisplayImageOptions(getDefaultDisplayImageOptions().build())
				.threadPoolSize(2)
				.build();
		ImageLoader.getInstance().init(config);
	}

	public static DisplayImageOptions.Builder getDefaultDisplayImageOptions() {
		return new DisplayImageOptions.Builder()
				.cacheInMemory(true)
				.cacheOnDisk(true)
				.bitmapConfig(Bitmap.Config.ARGB_8888)
				.imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2);
//				.preProcessor(new ContactPhotoPreProcessor())
//				.displayer(new ContactPhotoDisplayer());
	}
}
