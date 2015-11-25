package application;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by zhangyanye on 2015/8/21
 * Description:数据缓存,通信,初始化等
 */
public class FreeWalkerApplication extends Application {

    private static RequestQueue mRequestqueues;
    private static FreeWalkerApplication mFreeWalkerApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mRequestqueues = Volley.newRequestQueue(getApplicationContext());
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    public static RequestQueue getRequestQueues() {
        return mRequestqueues;
    }

    public static Context getApp() {
        return mFreeWalkerApplication;
    }
    
}
