package com.bawei.yuanchenran20191230;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.bawei.yuanchenran20191230.adpater.MyAdapter;
import com.bawei.yuanchenran20191230.base.BaseActivity;
import com.bawei.yuanchenran20191230.bean.MyBean;
import com.bawei.yuanchenran20191230.bean.MySmses;
import com.bawei.yuanchenran20191230.mvp.presenter.MyPresenter;
import com.bawei.yuanchenran20191230.mvp.view.MyView;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends BaseActivity implements MyView {
    private static final String TAG = "MainActivity";
    private android.widget.ListView list;


    @Override
    protected int initlayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        list = (ListView) findViewById(R.id.list);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        String path="http://blog.zhaoliang5156.cn/api/news/smsbak.json";
        MyPresenter myPresenter = new MyPresenter(this);
        myPresenter.getData(path);

    }

    @Override
    public void jsonOk(String json) {
        Gson gson = new Gson();
        MyBean myBean = gson.fromJson(json, MyBean.class);
        List<MySmses> smses = myBean.getSmses();
        MyAdapter myAdapter = new MyAdapter(smses,this);
        list.setAdapter(myAdapter);


    }

    @Override
    public void jsonNo(String msg) {

    }


}
