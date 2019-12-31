package com.bawei.yuanchenran20191230.mvp.presenter;

import com.bawei.yuanchenran20191230.NetUilt;
import com.bawei.yuanchenran20191230.mvp.model.MyModel;
import com.bawei.yuanchenran20191230.mvp.view.MyView;

public class MyPresenter {
    private final MyModel myModel;
    private MyView myView;


    public MyPresenter(MyView myView) {
        this.myView = myView;
        myModel = new MyModel();
    }
    public void getData(String path){
        myModel.getData(path, new NetUilt.CallBack() {
            @Override
            public void jsonOk(String json) {
                 myView.jsonOk(json);
            }

            @Override
            public void jsonNo(String msg) {
                   myView.jsonNo(msg);
            }
        });

    }
}
