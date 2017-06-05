package com.dl.commonviewpager.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.dl.commonviewpager.R;
import com.dl.commonviewpager.adapter.CommonViewPagerAdapter;
import com.dl.commonviewpager.interfaces.ViewPagerHolderCreator;

import java.util.List;

/**
 * Created by dl on 2017/6/5.
 */
public class CommonViewPager<T> extends RelativeLayout {

    private ViewPager mViewPager;
    private CommonViewPagerAdapter mAdapter;


    public CommonViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.viewpager_layout,this,true);
        mViewPager = (ViewPager) view.findViewById(R.id.common_view_pager);
    }

    //设置数据
    public void setPages(List<T> data, ViewPagerHolderCreator creator){
        mAdapter = new CommonViewPagerAdapter(data,creator);
    }
}
