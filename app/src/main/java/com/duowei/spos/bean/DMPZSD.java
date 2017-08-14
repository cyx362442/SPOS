package com.duowei.spos.bean;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.duowei.spos.app.App;
import com.duowei.spos.greendao.gen.DMPZSDDao;
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
public class DMPZSD {
    @Transient
    public final String sql = "select PZBM, XMBH, NR, PY, DYCP, PXH, LX, PPMC, " +
            "price, id from Dmpzsd where dycp='1'|";
    /**
     * PZBM : 00057
     * NR : 三分熟
     * DYCP : 1
     * PXH : 1
     * LX : 成熟度
     * price : 0
     * id : 57
     */
    @Id
    private Long _id;
    private String PZBM;
    private String XMBH;
    private String NR;
    private String DYCP;
    private String PXH;
    private String LX;
    private String PPMC;
    private String price;
    private String id;
    @Transient
    private boolean isSelect=false;

    private DMPZSD() {
    }
    @Generated(hash = 962416002)
    public DMPZSD(Long _id, String PZBM, String XMBH, String NR, String DYCP,
            String PXH, String LX, String PPMC, String price, String id) {
        this._id = _id;
        this.PZBM = PZBM;
        this.XMBH = XMBH;
        this.NR = NR;
        this.DYCP = DYCP;
        this.PXH = PXH;
        this.LX = LX;
        this.PPMC = PPMC;
        this.price = price;
        this.id = id;
    }
    private static DMPZSD singleton = null;
    public static DMPZSD getInstance() {
        if (singleton == null) {
            singleton = new DMPZSD();
        }
        return singleton;
    }
    public MyStringRequest getRequest(){
        MyStringRequest request = new MyStringRequest(Request.Method.POST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        Type type = new TypeToken<List<DMPZSD>>(){}.getType();
                        List<DMPZSD> listDmpzsd = gson.fromJson(response, type);
                        DMPZSDDao dmpzsdDao = App.getDaoSession().getDMPZSDDao();
                        dmpzsdDao.deleteAll();
                        dmpzsdDao.insertInTx(listDmpzsd);
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
    public String getNR() {
        return this.NR;
    }
    public void setNR(String NR) {
        this.NR = NR;
    }
    public String getDYCP() {
        return this.DYCP;
    }
    public void setDYCP(String DYCP) {
        this.DYCP = DYCP;
    }
    public String getPXH() {
        return this.PXH;
    }
    public void setPXH(String PXH) {
        this.PXH = PXH;
    }
    public String getLX() {
        return this.LX;
    }
    public void setLX(String LX) {
        this.LX = LX;
    }
    public String getPPMC() {
        return this.PPMC;
    }
    public void setPPMC(String PPMC) {
        this.PPMC = PPMC;
    }
    public String getPrice() {
        return this.price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public boolean isSelect() {
        return isSelect;
    }
    public void setSelect(boolean select) {
        isSelect = select;
    }
}
