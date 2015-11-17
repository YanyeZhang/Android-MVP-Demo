package utils;

import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import application.FreeWalkerApplication;

/**
 * Created by zhangyanye on 2015/8/23
 * Description:工具集合
 *             1.toast
 *             2.Log
 */
public class Util{

    public static void showToast(String content, int time) {
        Toast.makeText(FreeWalkerApplication.getApp(), content, time).show();
    }

    public static void showToast(String content) {
        showToast(content, Toast.LENGTH_SHORT);
    }

    public static void showLog(String content) {
        Log.e("zyy",content);
    }
}
