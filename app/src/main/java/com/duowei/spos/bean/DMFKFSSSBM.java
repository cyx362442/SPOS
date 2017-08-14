package com.duowei.spos.bean;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.duowei.spos.app.App;
import com.duowei.spos.greendao.gen.DMFKFSSSBMDao;
import com.duowei.spos.utils.MyStringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Transient;

import java.lang.reflect.Type;
import java.util.List;

/**
 * 付款方式对应门店
 * Created by Administrator on 2017-08-01.
 */
@Entity
public class DMFKFSSSBM {
    @Transient
    private final String sql = "select XH, BMBH, BM, NR, FKLB, BZ, FKFS, DYQMZ, " +
            "BY1, BY2, BY3, BY4, BY5, id from Dmfkfsssbm|";
    /**
     * XH : 258
     * BMBH : 004
     * BM : 3
     * NR : 5元抵用券
     * id : 258
     */
    private String XH;
    private String BMBH;
    private String BM;
    private String NR;
    private String id;

    private DMFKFSSSBM() {
    }
    @Generated(hash = 284051967)
    public DMFKFSSSBM(String XH, String BMBH, String BM, String NR, String id) {
        this.XH = XH;
        this.BMBH = BMBH;
        this.BM = BM;
        this.NR = NR;
        this.id = id;
    }
    private static DMFKFSSSBM singleton = null;
    public static DMFKFSSSBM getInstance() {
        if (singleton == null) {
            singleton = new DMFKFSSSBM();
        }
        return singleton;
    }
    public MyStringRequest getRequest(){
        MyStringRequest request = new MyStringRequest(Request.Method.POST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        Type type = new TypeToken<List<DMFKFSSSBM>>(){}.getType();
                        List<DMFKFSSSBM> listDmfkfsssbm = gson.fromJson(response, type);
                        DMFKFSSSBMDao dmfkfsssbmDao = App.getDaoSession().getDMFKFSSSBMDao();
                        dmfkfsssbmDao.deleteAll();
                        dmfkfsssbmDao.insertInTx(listDmfkfsssbm);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        },sql);
        return request;
    }
    public String getXH() {
        return this.XH;
    }
    public void setXH(String XH) {
        this.XH = XH;
    }
    public String getBMBH() {
        return this.BMBH;
    }
    public void setBMBH(String BMBH) {
        this.BMBH = BMBH;
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
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
