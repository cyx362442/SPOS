package com.duowei.spos.bean;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.duowei.spos.app.App;
import com.duowei.spos.greendao.gen.JGSZDao;
import com.duowei.spos.utils.MyStringRequest;
import com.duowei.spos.utils.Net;
import com.duowei.spos.utils.ToastUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2017-08-03.
 */
@Entity
public class JGSZ {
    /**
     * BMBH : 00002
     * BMMC : 厦门店
     * PY : XMD
     * LXDH : 18876522091
     * WXZFID : 75
     * ZFBAPPID : 75
     * type : 2
     * id : 1
     * overdue_date : 1718699188
     * state : 1
     * yysj : 7
     */
    private String BMBH;
    private String BMMC;
    private String PY;
    private String LXDH;
    private String WXZFID;
    private String ZFBAPPID;
    private String type;
    private String id;
    private String overdue_date;
    private String state;
    private String yysj;

    private static JGSZ singleton = null;
    public static JGSZ getInstance() {
        if (singleton == null) {
            singleton = new JGSZ();
        }
        return singleton;
    }
    @Transient
    public final String sql = "select BMBH, FBMBH, BMMC, PY, DZ, LXDH, SFJM, SFPSZX, " +
            "WXZFID, WXFDMC, ZFBAPPID, ZFFWQDZ, WXGZH, WXYSID, WXFDBH, YHYFWQDZ, type, id, " +
            "overdue_date, state, yysj from jgsz where state = 1|";
    @Generated(hash = 1831465782)
    public JGSZ(String BMBH, String BMMC, String PY, String LXDH, String WXZFID, String ZFBAPPID, String type,
            String id, String overdue_date, String state, String yysj) {
        this.BMBH = BMBH;
        this.BMMC = BMMC;
        this.PY = PY;
        this.LXDH = LXDH;
        this.WXZFID = WXZFID;
        this.ZFBAPPID = ZFBAPPID;
        this.type = type;
        this.id = id;
        this.overdue_date = overdue_date;
        this.state = state;
        this.yysj = yysj;
    }

    @Generated(hash = 1541315812)
    public JGSZ() {
    }
    public MyStringRequest getRequest(){
        MyStringRequest request = new MyStringRequest(Request.Method.POST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Type type = new TypeToken<List<JGSZ>>() {
                }.getType();
                List<JGSZ> listJgsz = gson.fromJson(response, type);
                JGSZDao jgszDao = App.getDaoSession().getJGSZDao();
                jgszDao.deleteAll();
                jgszDao.insertInTx(listJgsz);
                List<JGSZ> jgszList = App.getDaoSession().getJGSZDao().loadAll();
                Net.bmbh=jgszList.get(0).getBMBH();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, sql);
        return request;
    }

    public String getBMBH() {
        return BMBH;
    }

    public void setBMBH(String BMBH) {
        this.BMBH = BMBH;
    }

    public String getBMMC() {
        return BMMC;
    }

    public void setBMMC(String BMMC) {
        this.BMMC = BMMC;
    }

    public String getPY() {
        return PY;
    }

    public void setPY(String PY) {
        this.PY = PY;
    }

    public String getLXDH() {
        return LXDH;
    }

    public void setLXDH(String LXDH) {
        this.LXDH = LXDH;
    }

    public String getWXZFID() {
        return WXZFID;
    }

    public void setWXZFID(String WXZFID) {
        this.WXZFID = WXZFID;
    }

    public String getZFBAPPID() {
        return ZFBAPPID;
    }

    public void setZFBAPPID(String ZFBAPPID) {
        this.ZFBAPPID = ZFBAPPID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOverdue_date() {
        return overdue_date;
    }

    public void setOverdue_date(String overdue_date) {
        this.overdue_date = overdue_date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getYysj() {
        return yysj;
    }

    public void setYysj(String yysj) {
        this.yysj = yysj;
    }
}
