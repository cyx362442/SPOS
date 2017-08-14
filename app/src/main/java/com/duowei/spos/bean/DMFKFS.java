package com.duowei.spos.bean;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.duowei.spos.app.App;
import com.duowei.spos.greendao.gen.DMFKFSDao;
import com.duowei.spos.utils.MyStringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2017-08-01.
 */
@Entity
public class DMFKFS {
    @Transient
    private  final String sql = "select BM, NR, FKLB, BZ, XGSJ, FKFS, DYQMZ, XL, " +
            "JWSJYYSR, BY1, BY2, BY3, BY4, BY5, BY6, id from Dmfkfs|";
    /**
     * BM : 1
     * NR : 支付宝支付
     * FKLB : 2
     * XGSJ : 1496228903
     * FKFS : 2
     * DYQMZ : 0.00
     * XL : 3
     * JWSJYYSR : 0
     * id : 1
     * BY4 : 20.0000
     */

    private String BM;
    private String NR;
    private String FKLB;
    private String XGSJ;
    private String FKFS;
    private String DYQMZ;
    private String XL;
    private String JWSJYYSR;
    private String id;
    private String BY4;

    private DMFKFS() {
    }

    @Generated(hash = 529716489)
    public DMFKFS(String BM, String NR, String FKLB, String XGSJ, String FKFS,
            String DYQMZ, String XL, String JWSJYYSR, String id, String BY4) {
        this.BM = BM;
        this.NR = NR;
        this.FKLB = FKLB;
        this.XGSJ = XGSJ;
        this.FKFS = FKFS;
        this.DYQMZ = DYQMZ;
        this.XL = XL;
        this.JWSJYYSR = JWSJYYSR;
        this.id = id;
        this.BY4 = BY4;
    }
    private static DMFKFS singleton = null;

    public static DMFKFS getInstance() {
        if (singleton == null) {
            singleton = new DMFKFS();
        }
        return singleton;
    }

    public MyStringRequest getRequest(){
        MyStringRequest request = new MyStringRequest(Request.Method.POST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        Type type = new TypeToken<List<DMFKFS>>(){}.getType();
                        List<DMFKFS> listDmfkfs = gson.fromJson(response, type);
                        DMFKFSDao dmfkfsDao = App.getDaoSession().getDMFKFSDao();
                        dmfkfsDao.deleteAll();
                        dmfkfsDao.insertInTx(listDmfkfs);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        },sql);
        return request;
    }

    public String getBM() {
        return this.BM;
    }

    public void setBM(String BM) {
        this.BM = BM;
    }

    public String getNR() {
        return this.NR;
    }

    public void setNR(String NR) {
        this.NR = NR;
    }

    public String getFKLB() {
        return this.FKLB;
    }

    public void setFKLB(String FKLB) {
        this.FKLB = FKLB;
    }

    public String getXGSJ() {
        return this.XGSJ;
    }

    public void setXGSJ(String XGSJ) {
        this.XGSJ = XGSJ;
    }

    public String getFKFS() {
        return this.FKFS;
    }

    public void setFKFS(String FKFS) {
        this.FKFS = FKFS;
    }

    public String getDYQMZ() {
        return this.DYQMZ;
    }

    public void setDYQMZ(String DYQMZ) {
        this.DYQMZ = DYQMZ;
    }

    public String getXL() {
        return this.XL;
    }

    public void setXL(String XL) {
        this.XL = XL;
    }

    public String getJWSJYYSR() {
        return this.JWSJYYSR;
    }

    public void setJWSJYYSR(String JWSJYYSR) {
        this.JWSJYYSR = JWSJYYSR;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBY4() {
        return this.BY4;
    }

    public void setBY4(String BY4) {
        this.BY4 = BY4;
    }
}
