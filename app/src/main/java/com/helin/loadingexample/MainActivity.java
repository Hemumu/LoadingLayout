package com.helin.loadingexample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.helin.loadinglayout.LoadingLayout;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1, btn2, btn3, btn4;
    private LoadingLayout mLoading;
    private ListView mListView;
    private List<String> mData = new ArrayList<String>();

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==2000){
                mLoading.showState("加载失败，点击重试！");
            }else{
                mLoading.showContent();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mLoading = (LoadingLayout) findViewById(R.id.loading_layout);
        mListView = (ListView) findViewById(R.id.list_view);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        mLoading.showContent();
        mData.add("11111");
        mData.add("2222");
        mData.add("3333");
        mData.add("4444");
        mListView.setAdapter(new CommonAdapter<String>(MainActivity.this, R.layout.list_item, mData) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
                viewHolder.setText(R.id.text_item,mData.get(position));
            }
        });
        mLoading.setStateClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoading.showLoading();
                mLoading.postDelayed(new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        //模拟网络请求
                        mHandler.sendEmptyMessage(1000);
                    }
                },1000);
            }
        });
//        mLoading.setViewOncClickListener(R.id.text_item, new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"1111",Toast.LENGTH_SHORT).show();
//            }
//        });
//        mLoading.setViewText(R.id.text_item,"2222");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                mLoading.showLoading();
                break;
            case R.id.btn2:
                mLoading.showState();
                break;
            case R.id.btn3:
                mLoading.showEmpty();
                break;
            case R.id.btn4:
                mLoading.showLoading();
                mLoading.postDelayed(new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        //模拟网络请求
                        mHandler.sendEmptyMessage(2000);
                    }
                },1000);
                break;
        }
    }
}
