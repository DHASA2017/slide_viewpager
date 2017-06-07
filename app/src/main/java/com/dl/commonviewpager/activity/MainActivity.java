package com.dl.commonviewpager.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dl.commonviewpager.R;
import com.dl.commonviewpager.interfaces.ViewPagerHolder;
import com.dl.commonviewpager.interfaces.ViewPagerHolderCreator;
import com.dl.commonviewpager.widget.CommonViewPager;
import com.dl.commonviewpager.widget.StatusBarUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CommonViewPager mCommonViewPager;
    private Integer[] mData = {R.drawable.first,R.drawable.second,R.drawable.third,R.drawable.fourth};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        StatusBarUtils.setFullScreen(this);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        initView();
    }

    private void initView() {
        mCommonViewPager = (CommonViewPager) findViewById(R.id.activity_common_view_pager);
        //设置数据
        List<Integer> mList = Arrays.asList(mData);
        mCommonViewPager.setPages(mList, new ViewPagerHolderCreator() {
            @Override
            public ViewPagerHolder crateViewHolder() {
                return new ViewImageHolder();
            }
        });
    }

    /**
     * 提供ViewPager展示的ViewHolder
     * 用于提供布局和绑定数据
     */
    public static class ViewImageHolder implements ViewPagerHolder<Integer>{

        private ImageView mImageView;
        private TextView goto_login;

        @Override
        public View createView(Context context) {
            //返回ViewPager页面展示的布局
            View view = LayoutInflater.from(context).inflate(R.layout.item_viewpage,null);
            mImageView = (ImageView) view.findViewById(R.id.viewPager_item_image);
            goto_login = (TextView) view.findViewById(R.id.goto_login);
            return view;
        }

        @Override
        public void onBind(final Context context, int position, Integer data,List<Integer> datas) {
            //数据绑定，自己绑定数据灵活性大
            mImageView.setImageResource(data);
            if(datas.size()-1==position){
                goto_login.setVisibility(View.VISIBLE);
                goto_login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,"登录成功",Toast.LENGTH_SHORT).show();
                    }
                });
            }else{
                goto_login.setVisibility(View.GONE);
            }
        }
    }

}
