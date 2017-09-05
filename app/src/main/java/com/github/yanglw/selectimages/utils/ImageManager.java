package com.github.yanglw.selectimages.utils;

import android.graphics.Bitmap;
import android.widget.AbsListView;

import com.github.yanglw.selectimages.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.PauseOnScrollListener;

/**
 * 图片加载工具类。<br/>
 * <br/>
 * Created by yanglw on 2014/8/15.
 */
public class ImageManager
{
    public static ImageLoader imageLoader;
    public static DisplayImageOptions options;
    public static AbsListView.OnScrollListener pauseScrollListener;

    public static void init()
    {
        imageLoader = ImageLoader.getInstance();

        options = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.drawable.sample)
                .showImageOnFail(R.drawable.sample)
                .showImageOnLoading(R.drawable.sample)
                .cacheInMemory(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();

        pauseScrollListener = new PauseOnScrollListener(imageLoader, true, true);
    }
}
