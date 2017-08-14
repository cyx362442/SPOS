package com.duowei.spos.bean;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.duowei.spos.app.App;
import com.duowei.spos.greendao.gen.DMKWDYDPDao;
import com.duowei.spos.utils.MyStringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2017-08-12.
 */
@Entity
public class DMKWDYDP {
    @Transient
    public final String sql = "select PZBM, XMBH, XH, XMMC, DW, id, TM from Dmkwdydp|";
    /**
     * PZBM : 00002
     * XMBH : 20
     * XH : 29
     * XMMC : 绿茶
     * id : 29
     * TM : 00020
     */
    @Id
    private Long _id;
    private String PZBM;
    private String XMBH;
    private String XH;
    private String DW;
    private String XMMC;
    private String id;
    private String TM;


    private DMKWDYDP() {
    }
    @Generated(hash = 304112790)
    public DMKWDYDP(Long _id, String PZBM, String XMBH, String XH, String DW, String XMMC,
            String id, String TM) {
        this._id = _id;
        this.PZBM = PZBM;
        this.XMBH = XMBH;
        this.XH = XH;
        this.DW = DW;
        this.XMMC = XMMC;
        this.id = id;
        this.TM = TM;
    }
    private static DMKWDYDP singleton = null;
    public static DMKWDYDP getInstance() {
        if (singleton == null) {
            singleton = new DMKWDYDP();
        }
        return singleton;
    }
    public MyStringRequest getRequest(){
        MyStringRequest request = new MyStringRequest(Request.Method.POST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        Type type = new TypeToken<List<DMKWDYDP>>(){}.getType();
                        List<DMKWDYDP> listDmkwdydp = gson.fromJson(response, type);
                        DMKWDYDPDao dmkwdydpDao = App.getDaoSession().getDMKWDYDPDao();
                        dmkwdydpDao.deleteAll();
                        dmkwdydpDao.insertInTx(listDmkwdydp);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        },sql);
        return request;
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public String getPZBM() {
        return this.PZBM;
    }
    public void setPZBM(String PZBM) {
        this.PZBM = PZBM;
    }
    public String getXMBH() {
        return this.XMBH;
    }
    public void setXMBH(String XMBH) {
        this.XMBH = XMBH;
    }
    public String getXH() {
        return this.XH;
    }
    public void setXH(String XH) {
        this.XH = XH;
    }
    public String getDW() {
        return this.DW;
    }
    public void setDW(String DW) {
        this.DW = DW;
    }
    public String getXMMC() {
        return this.XMMC;
    }
    public void setXMMC(String XMMC) {
        this.XMMC = XMMC;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTM() {
        return this.TM;
    }
    public void setTM(String TM) {
        this.TM = TM;
    }
}
