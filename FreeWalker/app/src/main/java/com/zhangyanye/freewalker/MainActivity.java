package com.zhangyanye.freewalker;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import net.VolleyListener;
import net.VolleyRequest;

import org.w3c.dom.Text;

import java.lang.reflect.Method;

import model.entity.WebApp;
import presenter.impl.WebAppPresenter;
import ui.base.BaseActivity;
import ui.view.IWebAppView;
import utils.Util;

public class MainActivity extends BaseActivity implements IWebAppView {

    private TextView textView;
    private WebAppPresenter webAppPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findView(R.id.txt);
        webAppPresenter = new WebAppPresenter(this);
        webAppPresenter.getApp("sf");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.x ml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showLoading() {
        Util.showLog("loading");
    }

    @Override
    public void hideLoading() {
        Util.showLog("hideloading");
    }

    @Override
    public void showError() {
        Util.showLog("error");
    }

    @Override
    public void setWebApp(WebApp webApp) {
       // textView.setText(webApp.getName());
    }
}
