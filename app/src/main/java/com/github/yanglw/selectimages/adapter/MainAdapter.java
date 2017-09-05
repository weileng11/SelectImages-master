package com.github.yanglw.selectimages.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.yanglw.selectimages.R;
import com.github.yanglw.selectimages.bean.Photo;
import com.github.yanglw.selectimages.utils.ImageManager;

import java.util.List;

/**
 * 首页图片已经选择的图片列表。<br/>
 * <br/>
 * Created by yanglw on 2014/8/17.
 */
public class MainAdapter extends MyBaseAdapter<Photo>
{
    public MainAdapter(Context context, List<Photo> list)
    {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ImageView imageView;
        if (convertView == null)
        {
            imageView = (ImageView) mInflater.inflate(R.layout.i_main, parent, false);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        ImageManager.imageLoader.displayImage("file:///" + mList.get(position).path,
                                              imageView,
                                              ImageManager.options);
        return imageView;
    }
}
