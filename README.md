# RetrofitDownload
断点续传与多线程下载

   final List<DownLoadEntity> list = new ArrayList<>();
                DownLoadEntity downLoadModel = new DownLoadEntity();
                downLoadModel.url = "http://dlsw.baidu.com/sw-search-sp/soft/80/10547/QQMusicForYQQ_12.57.3805.413_setup.1460617481.exe";
                downLoadModel.saveName = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "qq.exe";
                list.add(downLoadModel);
                DownLoadEntity downLoadModel2 = new DownLoadEntity();
                downLoadModel2.url = "http://dlsw.baidu.com/sw-search-sp/soft/70/17456/BaiduAn_Setup_8.1.0.7141.1459396875.exe";
                downLoadModel2.saveName = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "baidu.exe";
                list.add(downLoadModel2);

                DownLoadManager.getInstance().downLoad(list, "1", new DownLoadBackListener() {

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
