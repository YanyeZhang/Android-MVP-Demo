package net;

import android.util.ArrayMap;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangyanye on 2015/8/24
 * Description:
 */
public class RequestFactory {


    /**
     * @param method   选择请求方式 get:0 ; post:1
     * @param type     选择请求类型 string:0 ; jsonObject: 1;jsonArray: 3 ;
     * @param url
     * @param url
     * @param params
     * @param listener
     * @return
     */
    public static Request<?> setRequest(int method, int type, String url, final ArrayMap<String, String> params, VolleyListener listener, ArrayList<JSONObject> arrayList) {
        switch (type) {
            case 0:
                if (method == 0)
                    return new StringRequest(method, url, listener.sucessListener(type), listener.errorListener());
                else if (method == 1)
                    return new StringRequest(method, url, listener.sucessListener(type), listener.errorListener()) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            return params;
                        }
                    };
                break;
            case 1:
                if (method == 0)
                    return new JsonObjectRequest(method, url, null, listener.sucessListener(type), listener.errorListener());
                else if (method == 1) {
                    JSONObject jsonObject = new JSONObject(params);
                    return new JsonObjectRequest(method, url, jsonObject, listener.sucessListener(type), listener.errorListener());
                }
                break;
            case 2:
                if (method == 0)
                    return new JsonArrayRequest(method, url, null, listener.sucessListener(type), listener.errorListener());
                else if (method == 1) {
                    JSONArray jsonArray = new JSONArray(arrayList);
                    return new JsonArrayRequest(method, url, jsonArray, listener.sucessListener(type), listener.errorListener());
                }
                break;

        }
        return null;
    }
}
