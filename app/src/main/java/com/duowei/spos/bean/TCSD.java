package com.duowei.spos.bean;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.duowei.spos.app.App;
import com.duowei.spos.greendao.gen.TCSDDao;
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
 * Created by Administrator on 2017-08-10.
 */
@Entity
public class TCSD {
    @Transient
    private  final String sql = "select XH, XMBH, XMBH1, XMMC1, DW1, SL, SFXZ, TM, " +
            "XGSJ, DJ, BZ, LBBM, NBBM, MXBY1, MXBY2, MXBY3, MXBY4, LBMC from tcsd|";

    @Id(autoincrement = true)
    private Long _id;

    private String XH;
    private String XMBH;
    private String XMBH1;
    private String XMMC1;
    private String DW1;
    private float SL;
    private String SFXZ;
    private String TM;
    private String XGSJ;
    private float DJ;
    private String BZ;
    private String LBBM;
    private String NBBM;
    private String MXBY1;
    private String MXBY2;
    private String MXBY3;
    private String MXBY4;
    private String LBMC;

    private TCSD() {
    }
    @Generated(hash = 14402949)
    public TCSD(Long _id, String XH, String XMBH, String XMBH1, String XMMC1, String DW1,
            float SL, String SFXZ, String TM, String XGSJ, float DJ, String BZ, String LBBM,
            String NBBM, String MXBY1, String MXBY2, String MXBY3, String MXBY4,
            String LBMC) {
        this._id = _id;
        this.XH = XH;
        this.XMBH = XMBH;
        this.XMBH1 = XMBH1;
        this.XMMC1 = XMMC1;
        this.DW1 = DW1;
        this.SL = SL;
        this.SFXZ = SFXZ;
        this.TM = TM;
        this.XGSJ = XGSJ;
        this.DJ = DJ;
        this.BZ = BZ;
        this.LBBM = LBBM;
        this.NBBM = NBBM;
        this.MXBY1 = MXBY1;
        this.MXBY2 = MXBY2;
        this.MXBY3 = MXBY3;
        this.MXBY4 = MXBY4;
        this.LBMC = LBMC;
    }
    private static TCSD singleton = null;
    public static TCSD getInstance() {
        if (singleton == null) {
            singleton = new TCSD();
        }
        return singleton;
    }
    public MyStringRequest getRequest(){
        MyStringRequest request = new MyStringRequest(Request.Method.POST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        Type type = new TypeToken<List<TCSD>>(){}.getType();
                        List<TCSD> listTcsd = gson.fromJson(response, type);
                        TCSDDao tcsdDao = App.getDaoSession().getTCSDDao();
                        tcsdDao.deleteAll();
                        tcsdDao.insertInTx(listTcsd);
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
    public String getXH() {
        return this.XH;
    }
    public void setXH(String XH) {
        this.XH = XH;
    }
    public String getXMBH() {
        return this.XMBH;
    }
    public void setXMBH(String XMBH) {
        this.XMBH = XMBH;
    }
    public String getXMBH1() {
        return this.XMBH1;
    }
    public void setXMBH1(String XMBH1) {
        this.XMBH1 = XMBH1;
    }
    public String getXMMC1() {
        return this.XMMC1;
    }
    public void setXMMC1(String XMMC1) {
        this.XMMC1 = XMMC1;
    }
    public String getDW1() {
        return this.DW1;
    }
    public void setDW1(String DW1) {
        this.DW1 = DW1;
    }
    public float getSL() {
        return this.SL;
    }
    public void setSL(float SL) {
        this.SL = SL;
    }
    public String getSFXZ() {
        return this.SFXZ;
    }
    public void setSFXZ(String SFXZ) {
        this.SFXZ = SFXZ;
    }
    public String getTM() {
        return this.TM;
    }
    public void setTM(String TM) {
        this.TM = TM;
    }
    public String getXGSJ() {
        return this.XGSJ;
    }
    public void setXGSJ(String XGSJ) {
        this.XGSJ = XGSJ;
    }
    public float getDJ() {
        return this.DJ;
    }
    public void setDJ(float DJ) {
        this.DJ = DJ;
    }
    public String getBZ() {
        return this.BZ;
    }
    public void setBZ(String BZ) {
        this.BZ = BZ;
    }
    public String getLBBM() {
        return this.LBBM;
    }
    public void setLBBM(String LBBM) {
        this.LBBM = LBBM;
    }
    public String getNBBM() {
        return this.NBBM;
    }
    public void setNBBM(String NBBM) {
        this.NBBM = NBBM;
    }
    public String getMXBY1() {
        return this.MXBY1;
    }
    public void setMXBY1(String MXBY1) {
        this.MXBY1 = MXBY1;
    }
    public String getMXBY2() {
        return this.MXBY2;
    }
    public void setMXBY2(String MXBY2) {
        this.MXBY2 = MXBY2;
    }
    public String getMXBY3() {
        return this.MXBY3;
    }
    public void setMXBY3(String MXBY3) {
        this.MXBY3 = MXBY3;
    }
    public String getMXBY4() {
        return this.MXBY4;
    }
    public void setMXBY4(String MXBY4) {
        this.MXBY4 = MXBY4;
    }
    public String getLBMC() {
        return this.LBMC;
    }
    public void setLBMC(String LBMC) {
        this.LBMC = LBMC;
    }
}
