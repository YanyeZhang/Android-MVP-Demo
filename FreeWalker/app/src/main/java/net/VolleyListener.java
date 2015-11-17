package net;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.Objects;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;

/**
 * Created by zhangyanye on 2015/8/22
 * Description:封装volleyListener
 */
public class VolleyListener {
    private Context mContext;
    private static Response.Listener mListener;
    private static Response.ErrorListener mErrorListener;
    private ResponseListener  mResponseListener;

    public VolleyListener(Context context,ResponseListener  responseListener) {
        mContext = context;
        mResponseListener=responseListener;
    }


    public Response.Listener sucessListener(int type) {
        switch (type) {
            case 0:
                mListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String result) {
                        mResponseListener.OnSuccess(result);
                    }
                };
                break;
            case 1:
                mListener = new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray result) {
                        mResponseListener.OnSuccess(result);
                    }
                };
                break;
            case 2:
                mListener = new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject result) {
                        mResponseListener.OnSuccess(result);
                    }
                };
                break;
        }
        return mListener;
    }

    public Response.ErrorListener errorListener() {
        mErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mResponseListener.OnError(error);
            }
        };
        return mErrorListener;
    }


}
