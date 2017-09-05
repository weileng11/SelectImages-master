package com.github.yanglw.selectimages.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class MyBaseAdapter<T> extends BaseAdapter
{
    protected Context mContext;
    protected List<T> mList;
    protected LayoutInflater mInflater;

    public MyBaseAdapter(Context context, List<T> list)
    {
        mContext = context;
        mList = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount()
    {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    public List<T> getList()
    {
        return mList;
    }

    public void setList(List<T> list)
    {
        mList = list;
    }
}
