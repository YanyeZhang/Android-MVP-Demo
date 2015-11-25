package com.zhangyanye.freewalker;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import presenters.impl.StringPresenter;
import views.impl.StringView;

public class MainActivity extends Activity implements StringView {

    private TextView textView;
    private StringPresenter stringPresenter;
    private Dialog dialog;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        stringPresenter = new StringPresenter(this);
        textView = (TextView) findViewById(R.id.txt);
        dialog = new Dialog(this);
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringPresenter.setUrl("http://wwww.baidu.com/");
            }
        });

    }


    @Override
    public void showString(String result) {
        textView.setText(result);
    }

    @Override
    public void showLoding() {
        dialog.show();
    }

    @Override
    public void hideLoding() {
        dialog.hide();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
