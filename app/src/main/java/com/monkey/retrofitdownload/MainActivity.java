package com.monkey.retrofitdownload;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hly.easyretrofit.download.DownLoadBackListener;
import com.hly.easyretrofit.download.db.DownLoadEntity;
import com.hly.easyretrofit.download.DownLoadManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView mTvDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mTvDown = (TextView) findViewById(R.id.tv_down);

        findViewById(R.id.bt_download).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final List<DownLoadEntity> list = new ArrayList<>();
                DownLoadEntity downLoadModel = new DownLoadEntity();
                downLoadModel.url = "http://dlsw.baidu.com/sw-search-sp/soft/80/10547/QQMusicForYQQ_12.57.3805.413_setup.1460617481.exe";
                downLoadModel.saveName = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "qq.exe";
                list.add(downLoadModel);
                DownLoadEntity downLoadModel2 = new DownLoadEntity();
                downLoadModel2.url = "http://dlsw.baidu.com/sw-search-sp/soft/70/17456/BaiduAn_Setup_8.1.0.7141.1459396875.exe";
                downLoadModel2.saveName = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "baidu.exe";
                list.add(downLoadModel2);

                DownLoadManager.getInstance().downLoad(list, "MainActivity", new DownLoadBackListener() {

                    @Override
                    public void onError(DownLoadEntity downLoadEntity, Throwable throwable) {
                        Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onStart(double percent) {
                        mTvDown.setText(String.valueOf(percent * 100));
                        Toast.makeText(MainActivity.this, "开始下载", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(MainActivity.this, "取消了", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onDownLoading(double percent) {
                        mTvDown.setText(String.valueOf(percent * 100));
                    }

                    @Override
                    public void onCompleted() {
                        Toast.makeText(MainActivity.this, "下完了", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        findViewById(R.id.bt_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownLoadManager.getInstance().cancel("MainActivity");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

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
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
