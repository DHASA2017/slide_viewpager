package com.dl.commonviewpager.interfaces;

/**
 * 用于生成各种ViewPagerHolder
 * 该类接收一个泛型，但必须是ViewPagerHolder的子类
 * Created by dl on 2017/6/5.
 */
public interface ViewPagerHolderCreator<VH extends ViewPagerHolder> {

    /**
     * 创建ViewPagerHolder
     */
    VH crateViewHolder();
}
