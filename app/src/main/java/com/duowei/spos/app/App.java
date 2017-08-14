package com.duowei.spos.app;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.duowei.spos.greendao.gen.DaoMaster;
import com.duowei.spos.greendao.gen.DaoSession;
import com.duowei.spos.utils.MyVolley;


import java.io.File;

/**
 * Created by Administrator on 2017-07-31.
 */

public class App extends Application {
    private static Context context;
    private static DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        setUpdateDataBase();
        MyVolley.getQueue(this);
    }

    public static Context getContext() {
        return context;
    }

    private void setUpdateDataBase() {
        File dbPath = new File(Environment.getExternalStorageDirectory(), "/.SPOS/spos.db");
        if (!dbPath.getParentFile().exists()) {
            //noinspection ResultOfMethodCallIgnored
            dbPath.getParentFile().mkdirs();
        }
        DaoMaster.DevOpenHelper devOpenHelper = new
                DaoMaster.DevOpenHelper(this, dbPath.getAbsolutePath());
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        mDaoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession() {
        return mDaoSession;
    }
}
