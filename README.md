# RetrofitDownload
断点续传与多线程下载

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
