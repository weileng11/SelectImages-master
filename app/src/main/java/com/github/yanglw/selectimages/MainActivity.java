package com.github.yanglw.selectimages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TextView;

import com.github.yanglw.selectimages.adapter.MainAdapter;
import com.github.yanglw.selectimages.bean.Photo;
import com.github.yanglw.selectimages.utils.Constan;
import com.github.yanglw.selectimages.utils.ImageManager;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.util.ArrayList;

/**
 * 首页。<br/>
 * <br/>
 * Created by yanglw on 2014/8/17.
 */
public class MainActivity extends ActionBarActivity
{
    private ArrayList<Photo> mList;
    private MainAdapter mAdapter;

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_img_main);

        mTextView = (TextView) findViewById(R.id.tv);
        GridView gridView = (GridView) findViewById(R.id.gridview);
        mTextView.setText(getString(R.string.check_length, 0));

        mList = new ArrayList<Photo>();
        mAdapter = new MainAdapter(this, mList);
        gridView.setAdapter(mAdapter);

        if (!ImageLoader.getInstance().isInited())
        {
            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                    .threadPriority(Thread.NORM_PRIORITY - 2)
                    .threadPoolSize(3)
                    .denyCacheImageMultipleSizesInMemory()
                    .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                    .diskCacheSize(50 * 1024 * 1024) // 50 Mb
                    .tasksProcessingOrder(QueueProcessingType.LIFO)
                    .build();
            ImageLoader.getInstance().init(config);

            ImageManager.init();
        }
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        ImageLoader.getInstance().destroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK)
        {
            if (data != null)
            {
                ArrayList<Photo> list = data.getParcelableArrayListExtra(Constan.RES_PHOTO_LIST);

                mList.clear();
                if (list != null)
                {
                    mList.addAll(list);
                }

                mAdapter.notifyDataSetChanged();
                mTextView.setText(getString(R.string.check_length, mAdapter.getCount()));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.img_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.add)
        {
            Intent intent = new Intent(this, ImageDirActivity.class);
            intent.putExtra(Constan.ARG_PHOTO_LIST, mList);
            startActivityForResult(intent, 1);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
