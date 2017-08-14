package com.duowei.spos.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.duowei.spos.app.App;
import com.duowei.spos.greendao.gen.DMJYXMSSLBDao;
import com.duowei.spos.utils.MyStringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Transient;

import java.lang.reflect.Type;
import java.util.List;

/**
 * 单品类别
 * 代码经营项目所属类别
 * Created by Administrator on 2017-08-01.
 */
@Entity
public class DMJYXMSSLB implements Parcelable {
    @Transient
    private int mData;
    @Transient
    public final String sql = "select LBBM, LBMC, PY, FLBBM, XGSJ, SFXS, SFTY, " +
            "XL, PPMC, id from Dmjyxmsslb|";
    /**
     * LBBM : 2993
     * LBMC : 外卖
     * PY : WM
     * FLBBM : 0
     * XGSJ : 1501488943
     * SFXS : 2
     * SFTY : 2
     * XL : 11
     * id : 2993
     */
    private String LBBM;
    private String LBMC;
    private String PY;
    private String FLBBM;
    private String XGSJ;
    private String SFXS;
    private String SFTY;
    private String XL;
    private String id;

    private DMJYXMSSLB() {
    }

    @Generated(hash = 860823344)
    public DMJYXMSSLB(String LBBM, String LBMC, String PY, String FLBBM,
            String XGSJ, String SFXS, String SFTY, String XL, String id) {
        this.LBBM = LBBM;
        this.LBMC = LBMC;
        this.PY = PY;
        this.FLBBM = FLBBM;
        this.XGSJ = XGSJ;
        this.SFXS = SFXS;
        this.SFTY = SFTY;
        this.XL = XL;
        this.id = id;
    }

    protected DMJYXMSSLB(Parcel in) {
        mData = in.readInt();
        LBBM = in.readString();
        LBMC = in.readString();
        PY = in.readString();
        FLBBM = in.readString();
        XGSJ = in.readString();
        SFXS = in.readString();
        SFTY = in.readString();
        XL = in.readString();
        id = in.readString();
    }

    public static final Creator<DMJYXMSSLB> CREATOR = new Creator<DMJYXMSSLB>() {
        @Override
        public DMJYXMSSLB createFromParcel(Parcel in) {
            return new DMJYXMSSLB(in);
        }

        @Override
        public DMJYXMSSLB[] newArray(int size) {
            return new DMJYXMSSLB[size];
        }
    };

    private static DMJYXMSSLB singleton = null;
    public static DMJYXMSSLB getInstance() {
        if (singleton == null) {
            singleton = new DMJYXMSSLB();
        }
        return singleton;
    }

    public MyStringRequest getRequest(){
        MyStringRequest request = new MyStringRequest(Request.Method.POST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        Type type = new TypeToken<List<DMJYXMSSLB>>(){}.getType();
                        List<DMJYXMSSLB> listDmjyxmsslb = gson.fromJson(response, type);
                        DMJYXMSSLBDao dmjyxmsslbDao = App.getDaoSession().getDMJYXMSSLBDao();
                        dmjyxmsslbDao.deleteAll();
                        dmjyxmsslbDao.insertInTx(listDmjyxmsslb);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        },sql);
        return request;
    }

    public String getLBBM() {
        return this.LBBM;
    }

    public void setLBBM(String LBBM) {
        this.LBBM = LBBM;
    }

    public String getLBMC() {
        return this.LBMC;
    }

    public void setLBMC(String LBMC) {
        this.LBMC = LBMC;
    }

    public String getPY() {
        return this.PY;
    }

    public void setPY(String PY) {
        this.PY = PY;
    }

    public String getFLBBM() {
        return this.FLBBM;
    }

    public void setFLBBM(String FLBBM) {
        this.FLBBM = FLBBM;
    }

    public String getXGSJ() {
        return this.XGSJ;
    }

    public void setXGSJ(String XGSJ) {
        this.XGSJ = XGSJ;
    }

    public String getSFXS() {
        return this.SFXS;
    }

    public void setSFXS(String SFXS) {
        this.SFXS = SFXS;
    }

    public String getSFTY() {
        return this.SFTY;
    }

    public void setSFTY(String SFTY) {
        this.SFTY = SFTY;
    }

    public String getXL() {
        return this.XL;
    }

    public void setXL(String XL) {
        this.XL = XL;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mData);
        parcel.writeString(sql);
        parcel.writeString(LBBM);
        parcel.writeString(LBMC);
        parcel.writeString(PY);
        parcel.writeString(FLBBM);
        parcel.writeString(XGSJ);
        parcel.writeString(SFXS);
        parcel.writeString(SFTY);
        parcel.writeString(XL);
        parcel.writeString(id);
    }
}
