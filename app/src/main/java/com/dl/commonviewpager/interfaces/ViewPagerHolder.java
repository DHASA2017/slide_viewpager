package com.dl.commonviewpager.interfaces;

import android.content.Context;
import android.view.View;

import java.util.List;

/**
 * 给adapter提供布局和绑定数据
 * Created by dl on 2017/6/5.
 */
public interface ViewPagerHolder<T> {

    /**
     * 创建view,提供布局
     * @param context
     * @return
     */
    View createView(Context context);

    /**
     * 绑定数据
     * @param context
     * @param position
     * @param data
     */
    void onBind(Context context,int position,T data,List<T> datas);
}
