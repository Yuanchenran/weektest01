package com.bawei.yuanchenran20191230;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawei.yuanchenran20191230.base.BaseActivity;

public class MainActivity extends BaseActivity {


    @Override
    protected int initlayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initVier() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        String path="http://blog.zhaoliang5156.cn/api/news/smsbak.json";
    }
}
