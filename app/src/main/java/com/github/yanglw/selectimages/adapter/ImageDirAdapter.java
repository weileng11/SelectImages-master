package com.github.yanglw.selectimages.adapter;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.yanglw.selectimages.R;
import com.github.yanglw.selectimages.bean.Dir;
import com.github.yanglw.selectimages.utils.ImageManager;

import java.util.List;

/**
 * Created by yanglw on 2014/8/17.
 */
public class ImageDirAdapter extends MyBaseAdapter<Dir>
{
    public ImageDirAdapter(Context context, List<Dir> list)
    {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Holder holder;
        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.i_imagedir, parent, false);
            holder = new Holder();
            holder.mImageView = (ImageView) convertView.findViewById(R.id.iv);
            holder.mTextView = (TextView) convertView.findViewById(R.id.path);
            holder.mNameTextView = (TextView) convertView.findViewById(R.id.name);

            convertView.setTag(holder);
        }
        else
        {
            holder = (Holder) convertView.getTag();
        }

        Dir dir = mList.get(position);
        holder.mTextView.setText(dir.text);
        holder.mNameTextView.setText(Html.fromHtml(dir.name + " <font color=\"#999999\">(" + dir.length + ")</font>"));
        ImageManager.imageLoader.displayImage("file:///" + dir.path,
                                              holder.mImageView,
                                              ImageManager.options);
        return convertView;
    }

    private class Holder
    {
        public TextView mTextView, mNameTextView;
        public ImageView mImageView;
    }

}
