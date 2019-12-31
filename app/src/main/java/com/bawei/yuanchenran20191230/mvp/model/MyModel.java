package com.bawei.yuanchenran20191230.mvp.model;

import com.bawei.yuanchenran20191230.NetUilt;

public class MyModel {
   public void getData(String path, NetUilt.CallBack callBack){
       NetUilt instance = NetUilt.getInstance();
       instance.doGet(path,callBack);
   }


}
