package application;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.easemob.chat.EMChat;

import java.util.Iterator;
import java.util.List;

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
        mFreeWalkerApplication=this;
        int pid = android.os.Process.myPid();
        String processAppName = getAppName(pid);
        if (processAppName == null || !processAppName.equalsIgnoreCase("com.zhangyanye.freewalker")) {
            return;
        }
        EMChat.getInstance().setAutoLogin(true);
        EMChat.getInstance().init(this);
        EMChat.getInstance().setDebugMode(true);//在做打包混淆时，要关闭debug模式，如果未被关闭，则会出现程序无法运行问题
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

    private String getAppName(int pID) {
        String processName = null;
        ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = this.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == pID) {
                    CharSequence c = pm.getApplicationLabel(pm.getApplicationInfo(info.processName, PackageManager.GET_META_DATA));
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
            }
        }
        return processName;
    }
}
