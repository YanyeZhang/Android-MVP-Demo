package net;

import com.android.volley.VolleyError;

/**
 * Created by zhangyanye on 2015/8/28
 * Description:
 */
public interface ResponseListener<T> {
    public void OnSuccess(T result);
    public void OnError(VolleyError error);
}
