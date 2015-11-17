package model.Impl;


import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import net.ResponseListener;
import net.VolleyListener;
import net.VolleyRequest;

import application.FreeWalkerApplication;
import model.CommonModel;
import model.entity.User;
import model.entity.WebApp;
import presenter.listen.OnWebAppListener;
import utils.Util;

/**
 * Created by zhangyanye on 2015/8/23
 * Description:
 */
public class WebAppModelImpl implements CommonModel {


    @Override
    public void load(String userId, final OnWebAppListener listener, String tag) {
        /*数据层操作*/
        VolleyRequest.RequestGet(Request.Method.GET, 0, "http://192.168.40.98:8080/FreeWalker/hello/2", "test",
                new VolleyListener(FreeWalkerApplication.getApp(), new ResponseListener<User>() {
                    @Override
                    public void OnSuccess(User result) {
                           Util.showToast(result.toString());
                    }

                    @Override
                    public void OnError(VolleyError error) {
                        Util.showToast(error.toString());
                        Util.showLog(error.toString());
                    }
                }));
    }
}
