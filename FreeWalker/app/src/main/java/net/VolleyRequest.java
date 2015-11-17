package net;

import android.content.Context;
import android.util.ArrayMap;
import android.util.SparseArray;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import application.FreeWalkerApplication;

/**
 * Created by zhangyanye on 2015/8/22
 * Description:自定义volley请求
 */
public class VolleyRequest {

    private static Request mRequest;


    public static void RequestGet(int method, int type, String url, String tag, VolleyListener listener) {
        FreeWalkerApplication.getRequestQueues().cancelAll(tag);
        mRequest = RequestFactory.setRequest(method, type, url, null, listener, null);
        mRequest.setTag(tag);
        FreeWalkerApplication.getRequestQueues().add(mRequest);
        FreeWalkerApplication.getRequestQueues().start();
    }

    public static void RequestPost(int method, int type, String url, String tag, ArrayMap<String, String> params, VolleyListener listener, ArrayList<JSONObject> arrayList) {
        FreeWalkerApplication.getRequestQueues().cancelAll(tag);
        mRequest = RequestFactory.setRequest(method, type, url, params, listener, arrayList);
        mRequest.setTag(tag);
        FreeWalkerApplication.getRequestQueues().add(mRequest);
        FreeWalkerApplication.getRequestQueues().start();
    }

    public static void RequestPost(int method, int type, String url, String tag, ArrayMap<String, String> params, VolleyListener listener) {
        RequestPost(method, type, url, tag, params, listener, null);
    }
}
