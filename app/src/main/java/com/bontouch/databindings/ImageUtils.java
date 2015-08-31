package com.bontouch.databindings;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Christoffer Hirsimaa on 31/08/15.
 */
public class ImageUtils {

	@BindingAdapter("bind:loadImage")
	public static void loadImage(ImageView view, String url){
		ImageLoader.getInstance().displayImage(url, view);
	}
}
