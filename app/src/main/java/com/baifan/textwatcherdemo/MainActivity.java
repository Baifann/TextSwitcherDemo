package com.baifan.textwatcherdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

/**
 * 用于滚动 文字 textswitcher普通用法
 */
public class MainActivity extends AppCompatActivity {
    private TextSwitcher mTsText;
    private Button mBtnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initEvents();
    }

    /**
     * 初始化事件
     */
    private void initEvents() {
        mTsText.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                final TextView textView = new TextView(MainActivity.this);
                textView.setSingleLine(true);
                textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                textView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textView.setSelected(true);
                    }
                }, 1478);
                return textView;
            }
        });
        mTsText.setInAnimation(this, android.R.anim.fade_in);
        mTsText.setOutAnimation(this, android.R.anim.fade_out);

        mBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTsText.setText(getResources().getString(R.string.text));
            }
        });
    }

    /**
     * 初始化控件
     */
    private void initViews() {
        mBtnClick = (Button) findViewById(R.id.btn_click);
        mTsText = (TextSwitcher) findViewById(R.id.ts_text);
    }
}
