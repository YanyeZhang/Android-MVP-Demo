package model.Impl;


import com.android.volley.Request;
import com.android.volley.VolleyError;

import net.ResponseListener;
import net.VolleyListener;
import net.VolleyRequest;

import application.FreeWalkerApplication;
import de.greenrobot.event.EventBus;
import event.StringEvent;
import model.CommonModel;
import presenters.listen.OnStringListener;

/**
 * Created by zhangyanye on 2015/8/23
 * Description:数据层，可以处理所需要的数据
 */
public class StringModleImpl implements CommonModel {


    @Override
    public void load(String url, final OnStringListener listener) {
        /*数据层操作 */
        VolleyRequest.RequestGet(Request.Method.GET, 0, url, "test",
                new VolleyListener(FreeWalkerApplication.getApp(), new ResponseListener<String>() {
                    @Override
                    public void OnSuccess(String result) {
                        listener.onSuccess(result);
                    }

                    @Override
                    public void OnError(VolleyError error) {
                        listener.onError(error);
                    }
                }));
    }

    @Override
    public void load(String url) {
         /*数据层操作 */
        VolleyRequest.RequestGet(Request.Method.GET, 0, url, "test",
                new VolleyListener(FreeWalkerApplication.getApp(), new ResponseListener<String>() {
                    @Override
                    public void OnSuccess(String result) {
                        EventBus.getDefault().post(new StringEvent(result));
                    }

                    @Override
                    public void OnError(VolleyError error) {
                        EventBus.getDefault().post(new StringEvent("失败"));
                    }
                }));
    }
}
