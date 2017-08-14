package com.duowei.spos.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.duowei.spos.app.App;
import com.duowei.spos.greendao.gen.JYXMSZDao;
import com.duowei.spos.utils.MyStringRequest;
import com.duowei.spos.utils.Net;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2017-07-31.
 */
@Entity
public class JYXMSZ implements Parcelable{
    @Transient
    private int mData;
    @Transient
    private  final String sql = "select XMBH, XMMC, PY, TM, DW, LBBM, LBMC, SFTC, " +
            "CBJG, SFZDJS, SFQX, XGSJ, TCZXGS, SFYHQ, ZDBDZ, BY1, BY2, BY3, BY4, BY5, BY6, BY7, " +
            "BY8, DYJBH, SFTY, XL, BCYZDDZ, GYSBH, BY9, BY10, BY11, BY12, BY13, pic, id, XSJG, LBXL from Jyxmsz " +
            "where XMBH in (select XMBH from jyxmmx where bmbh='"+ Net.bmbh+"')|";
    /**
     * XMBH : 11
     * XMMC : 柚子
     * PY : Z
     * TM : 00011
     * LBBM : 5
     * LBMC : 水果类
     * CBJG : 6.00
     * SFQX : 2
     * XGSJ : 1496197427
     * BY2 : 2
     * BY5 : 2
     * SFTY : 2
     * XL : 16
     * BCYZDDZ : 2
     * BY9 : 1
     * id : 11
     * XSJG : 1.00
     * LBXL : 5
     */
    private String XMBH;
    private String XMMC;
    private String PY;
    private String TM;
    private String DW;
    private String LBBM;
    private String LBMC;
    private String SFTC;
    private String CBJG;
    private String SFQX;
    private String XGSJ;
    private String BY2;
    private String BY5;
    private String SFTY;
    private float XL;
    private String BCYZDDZ;
    private String BY9;
    private String id;
    private float XSJG;
    private String LBXL;

    private JYXMSZ(){}

    @Generated(hash = 2088060570)
    public JYXMSZ(String XMBH, String XMMC, String PY, String TM, String DW, String LBBM, String LBMC, String SFTC,
            String CBJG, String SFQX, String XGSJ, String BY2, String BY5, String SFTY, float XL, String BCYZDDZ,
            String BY9, String id, float XSJG, String LBXL) {
        this.XMBH = XMBH;
        this.XMMC = XMMC;
        this.PY = PY;
        this.TM = TM;
        this.DW = DW;
        this.LBBM = LBBM;
        this.LBMC = LBMC;
        this.SFTC = SFTC;
        this.CBJG = CBJG;
        this.SFQX = SFQX;
        this.XGSJ = XGSJ;
        this.BY2 = BY2;
        this.BY5 = BY5;
        this.SFTY = SFTY;
        this.XL = XL;
        this.BCYZDDZ = BCYZDDZ;
        this.BY9 = BY9;
        this.id = id;
        this.XSJG = XSJG;
        this.LBXL = LBXL;
    }
    private static JYXMSZ jyxmsz=null;

    protected JYXMSZ(Parcel in) {
        mData = in.readInt();
        XMBH = in.readString();
        XMMC = in.readString();
        PY = in.readString();
        TM = in.readString();
        DW = in.readString();
        LBBM = in.readString();
        LBMC = in.readString();
        SFTC = in.readString();
        CBJG = in.readString();
        SFQX = in.readString();
        XGSJ = in.readString();
        BY2 = in.readString();
        BY5 = in.readString();
        SFTY = in.readString();
        XL = in.readFloat();
        BCYZDDZ = in.readString();
        BY9 = in.readString();
        id = in.readString();
        XSJG = in.readFloat();
        LBXL = in.readString();
    }

    public static final Creator<JYXMSZ> CREATOR = new Creator<JYXMSZ>() {
        @Override
        public JYXMSZ createFromParcel(Parcel in) {
            return new JYXMSZ(in);
        }

        @Override
        public JYXMSZ[] newArray(int size) {
            return new JYXMSZ[size];
        }
    };

    public static JYXMSZ getInstance(){
        if(jyxmsz==null){
            jyxmsz=new JYXMSZ();
        }
        return jyxmsz;
    }

    public MyStringRequest getRequest(){
        MyStringRequest request = new MyStringRequest(Request.Method.POST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        Type type = new TypeToken<List<JYXMSZ>>(){}.getType();
                        List<JYXMSZ> listJyxmsz = gson.fromJson(response, type);
                        JYXMSZDao jyxmszDao = App.getDaoSession().getJYXMSZDao();
                        jyxmszDao.deleteAll();
                        jyxmszDao.insertInTx(listJyxmsz);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        },sql);
        return request;
    }

    public String getXMBH() {
        return this.XMBH;
    }

    public void setXMBH(String XMBH) {
        this.XMBH = XMBH;
    }

    public String getXMMC() {
        return this.XMMC;
    }

    public void setXMMC(String XMMC) {
        this.XMMC = XMMC;
    }

    public String getPY() {
        return this.PY;
    }

    public void setPY(String PY) {
        this.PY = PY;
    }

    public String getTM() {
        return this.TM;
    }

    public void setTM(String TM) {
        this.TM = TM;
    }

    public String getDW() {
        return this.DW;
    }

    public void setDW(String DW) {
        this.DW = DW;
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

    public String getCBJG() {
        return this.CBJG;
    }

    public void setCBJG(String CBJG) {
        this.CBJG = CBJG;
    }

    public String getSFQX() {
        return this.SFQX;
    }

    public void setSFQX(String SFQX) {
        this.SFQX = SFQX;
    }

    public String getXGSJ() {
        return this.XGSJ;
    }

    public void setXGSJ(String XGSJ) {
        this.XGSJ = XGSJ;
    }

    public String getBY2() {
        return this.BY2;
    }

    public void setBY2(String BY2) {
        this.BY2 = BY2;
    }

    public String getBY5() {
        return this.BY5;
    }

    public void setBY5(String BY5) {
        this.BY5 = BY5;
    }

    public String getSFTY() {
        return this.SFTY;
    }

    public void setSFTY(String SFTY) {
        this.SFTY = SFTY;
    }

    public float getXL() {
        return this.XL;
    }

    public void setXL(float XL) {
        this.XL = XL;
    }

    public String getBCYZDDZ() {
        return this.BCYZDDZ;
    }

    public void setBCYZDDZ(String BCYZDDZ) {
        this.BCYZDDZ = BCYZDDZ;
    }

    public String getBY9() {
        return this.BY9;
    }

    public void setBY9(String BY9) {
        this.BY9 = BY9;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getXSJG() {
        return this.XSJG;
    }

    public void setXSJG(float XSJG) {
        this.XSJG = XSJG;
    }

    public String getLBXL() {
        return this.LBXL;
    }

    public void setLBXL(String LBXL) {
        this.LBXL = LBXL;
    }

    public String getSFTC() {
        return this.SFTC;
    }

    public void setSFTC(String SFTC) {
        this.SFTC = SFTC;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mData);
        parcel.writeString(sql);
        parcel.writeString(XMBH);
        parcel.writeString(XMMC);
        parcel.writeString(PY);
        parcel.writeString(TM);
        parcel.writeString(DW);
        parcel.writeString(LBBM);
        parcel.writeString(LBMC);
        parcel.writeString(SFTC);
        parcel.writeString(CBJG);
        parcel.writeString(SFQX);
        parcel.writeString(XGSJ);
        parcel.writeString(BY2);
        parcel.writeString(BY5);
        parcel.writeString(SFTY);
        parcel.writeFloat(XL);
        parcel.writeString(BCYZDDZ);
        parcel.writeString(BY9);
        parcel.writeString(id);
        parcel.writeFloat(XSJG);
        parcel.writeString(LBXL);
    }
}
