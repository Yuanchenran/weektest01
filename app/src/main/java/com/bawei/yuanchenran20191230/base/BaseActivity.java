package com.bawei.yuanchenran20191230.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int id = initlayoutId();
        setContentView(id);
        initVier();
        initListener();
        initData();
    }

    protected abstract int initlayoutId();
    protected abstract void initVier();
    protected abstract void initListener();
    protected abstract void initData();
}
