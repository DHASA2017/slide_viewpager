package com.dl.commonviewpager.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
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
    private CircleIndicatorView mCircleIndicatorView;

    public CommonViewPager(Context context) {
        super(context);
        init();
    }

    public CommonViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CommonViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CommonViewPager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.viewpager_layout,this,true);
        mViewPager = (ViewPager) view.findViewById(R.id.common_view_pager);
        mCircleIndicatorView = (CircleIndicatorView) view.findViewById(R.id.common_view_pager_indicator_view);
        mCircleIndicatorView.setRadius(DisplayUtils.dpToPx(4));
        mCircleIndicatorView.setSpace(DisplayUtils.dpToPx(5));
        mCircleIndicatorView.setEnableClickSwitch(true);
    }

    //设置数据
    public void setPages(List<T> data, ViewPagerHolderCreator creator){
        mAdapter = new CommonViewPagerAdapter(data,creator);
        mViewPager.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        mCircleIndicatorView.setUpWithViewPager(mViewPager);
    }

    public void setCurrentItem(int currentItem){
        mViewPager.setCurrentItem(currentItem);
    }

    public int getCurrentItem(){
        return mViewPager.getCurrentItem();
    }

    public void setOffScreenPageLimit(int limit){
        mViewPager.setOffscreenPageLimit(limit);
    }

    /**
     * 设置切换动画
     * @param reverseDrawingOrder
     * @param transformer
     */
    public void setPageTransformer(boolean reverseDrawingOrder,ViewPager.PageTransformer transformer){
        mViewPager.setPageTransformer(reverseDrawingOrder,transformer);
    }

    public void addOnPageChangeListener(ViewPager.OnPageChangeListener listener){
        mViewPager.addOnPageChangeListener(listener);
    }

    /**
     * 设置是否显示Indicator
     * @param visible
     */
    private void setIndicatorVisible(boolean visible){
        if(visible){
            mCircleIndicatorView.setVisibility(VISIBLE);
        }else{
            mCircleIndicatorView.setVisibility(GONE);
        }

    }

    public ViewPager getmViewPager(){
        return mViewPager;
    }
}
