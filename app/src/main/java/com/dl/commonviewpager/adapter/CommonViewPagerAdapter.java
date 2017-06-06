package com.dl.commonviewpager.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.dl.commonviewpager.interfaces.ViewPagerHolder;
import com.dl.commonviewpager.interfaces.ViewPagerHolderCreator;

import java.util.List;

/**
 * 重写ViewPager的adapter
 * Created by dl on 2017/6/5.
 */
public class CommonViewPagerAdapter<T> extends PagerAdapter{

    private List<T> mDatas;
    private ViewPagerHolderCreator mCreator;//ViewPagerHolder的生成器

    public CommonViewPagerAdapter(List<T> datas,ViewPagerHolderCreator creator){
        mDatas = datas;
        mCreator = creator;
    }
    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //不再把布局写死，而是用接口提供的布局
        //不在这里绑定数据，数据绑定交给api的调用者。
        View view = getView(position,null,container);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    /**
     * 获取ViewPager页面展示view
     * @param position
     * @param view
     * @param container
     * @return
     */
    private View getView(int position, View view, ViewGroup container){
        ViewPagerHolder holder;
        if(view==null){
            holder = mCreator.crateViewHolder();
            view = holder.createView(container.getContext());
            view.setTag(holder);
//            view.setTag(R.id.common_view_pager_item_tag,holder);
        }else{
//            holder = (ViewPagerHolder) view.getTag(R.id.common_view_pager_item_tag);
            holder = (ViewPagerHolder) view.getTag();
        }
        if(holder!=null&&mDatas!=null&&!mDatas.isEmpty()){
            //数据绑定
            holder.onBind(container.getContext(),position,mDatas.get(position),mDatas);
        }
        return view;
    }
}
