package com.duowei.spos.app;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.duowei.spos.R;
import com.duowei.spos.bean.DMFKFS;
import com.duowei.spos.bean.DMFKFSSSBM;
import com.duowei.spos.bean.DMJYXMSSLB;
import com.duowei.spos.bean.DMKWDYDP;
import com.duowei.spos.bean.DMPZSD;
import com.duowei.spos.bean.JGSZ;
import com.duowei.spos.bean.JYXMSZ;
import com.duowei.spos.bean.TCSD;
import com.duowei.spos.bean.YHJBQK;
import com.duowei.spos.fragment.CartFragment;
import com.duowei.spos.fragment.EmployerFragment;
import com.duowei.spos.fragment.LandInputFragment;
import com.duowei.spos.utils.MyVolley;

public class LoginActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frame1,new EmployerFragment()).commit();
        fm.beginTransaction().replace(R.id.frame2,new LandInputFragment()).commit();
        MyVolley.queue.add(JGSZ.getInstance().getRequest());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, Menu.FIRST+1, 0, "下载");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==Menu.FIRST+1){
            MyVolley.queue.add(YHJBQK.getInstance().getRequest());
            MyVolley.queue.add(JYXMSZ.getInstance().getRequest());
            MyVolley.queue.add(DMFKFS.getInstance().getRequest());
            MyVolley.queue.add(DMFKFSSSBM.getInstance().getRequest());
            MyVolley.queue.add(DMJYXMSSLB.getInstance().getRequest());
            MyVolley.queue.add(TCSD.getInstance().getRequest());
            MyVolley.queue.add(DMPZSD.getInstance().getRequest());
            MyVolley.queue.add(DMKWDYDP.getInstance().getRequest());
        }
        return true;
    }
}
