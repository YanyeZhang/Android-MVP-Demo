package presenters.listen;

import com.android.volley.VolleyError;

/**
 * 作为数据层的回调，可被事件总线取代
 */
public interface OnStringListener {
    /**
     * 成功时回调
     *
     * @param result
     */
    void onSuccess(String result);

    /**
     * 失败时回调，简单处理，没做什么
     */
    void onError(VolleyError error);
}