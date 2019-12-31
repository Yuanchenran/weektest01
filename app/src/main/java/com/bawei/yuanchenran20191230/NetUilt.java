package com.bawei.yuanchenran20191230;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetUilt {
    private static final String TAG = "NetUilt";
    private static NetUilt instance;
    private NetUilt() {
    }

    public static NetUilt getInstance() {
        if (instance==null){
            synchronized (NetUilt.class){
                if (instance == null) {
                    instance=new NetUilt();
                }
            }
        }
        return instance;
    }

    //判断网络状态
    private Boolean ispling(){
        ConnectivityManager connectivityManager= (ConnectivityManager) App.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo!=null){
            return true;
        }
        return false;
    }
    //get请求方式
    public void doGet(final String path, final CallBack callBack){
        new AsyncTask<String,Void,String>(){
            @Override
            protected String doInBackground(String... strings) {
                try {
                    URL url = new URL(path);
                    HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(8000);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode==200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        int len=-1;
                        byte[] bytes = new byte[1024];
                        StringBuffer stringBuffer = new StringBuffer();
                        while ((len=inputStream.read(bytes))!=-1){
                            stringBuffer.append(new String(bytes,0,len));
                        }
                        inputStream.close();
                        String json = stringBuffer.toString();
                        Log.d(TAG, "doInBackground: "+json);

                        return json;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (s!=null){
                    if (callBack != null) {
                        callBack.jsonOk(s);
                    }
                }else {
                    callBack.jsonNo("请求失败");
                }
            }
        }.execute();
    }



    //接口
    public interface CallBack{
        void jsonOk(String json);
        void jsonNo(String msg);
    }
}
