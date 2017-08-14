package com.duowei.spos.bean;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.duowei.spos.app.App;
import com.duowei.spos.greendao.gen.YHJBQKDao;
import com.duowei.spos.utils.MyStringRequest;
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
public class YHJBQK{
    /**
     * YHBH : 19_11
     * YHMC : 收银员A
     * YHMM : 11
     * QTXXQX : 1
     * CDCQX : 2
     * MDBBQX : 1
     * TDQX : 1
     * ZPQX : 2
     * XTJSQX : 1
     * BY15 : 2
     * BY23 : 2
     * BY25 : 2
     * BY28 : 2
     * BY32 : 2
     * BY33 : 2
     * BY54 : 2
     * BY60 : 2
     * BY95 : 2
     * BY100 : 2
     * BY101 : 2
     * BY108 : 2
     * BY112 : 2
     * BY114 : 2
     * BY115 : 2
     * BY116 : 2
     * BY117 : 2
     * BY118 : 2
     * BY120 : 2
     * BY129 : 2
     * BY130 : 2
     * BY138 : 2
     * BY148 : 2
     * id : 1
     */
    private String YHBH;
    private String YHMC;
    private String YHMM;
    private String QTXXQX;
    private String CDCQX;
    private String MDBBQX;
    private String TDQX;
    private String ZPQX;
    private String XTJSQX;
    private String BY15;
    private String BY23;
    private String BY25;
    private String BY28;
    private String BY32;
    private String BY33;
    private String BY54;
    private String BY60;
    private String BY95;
    private String BY100;
    private String BY101;
    private String BY108;
    private String BY112;
    private String BY114;
    private String BY115;
    private String BY116;
    private String BY117;
    private String BY118;
    private String BY120;
    private String BY129;
    private String BY130;
    private String BY138;
    private String BY148;
    private String id;
    @Transient
    private boolean isBorder = false;

    public boolean isBorder() {
        return isBorder;
    }

    public YHJBQK(boolean isBorder) {
        this.isBorder = isBorder;
    }

    public YHJBQK(String YHMC, String YHBH,String YHMM) {
        this.YHMC = YHMC;
        this.YHBH=YHBH;
        this.YHMM = YHMM;
    }

    public YHJBQK() {
    }

    @Generated(hash = 881905959)
    public YHJBQK(String YHBH, String YHMC, String YHMM, String QTXXQX, String CDCQX, String MDBBQX,
            String TDQX, String ZPQX, String XTJSQX, String BY15, String BY23, String BY25, String BY28,
            String BY32, String BY33, String BY54, String BY60, String BY95, String BY100, String BY101,
            String BY108, String BY112, String BY114, String BY115, String BY116, String BY117,
            String BY118, String BY120, String BY129, String BY130, String BY138, String BY148,
            String id) {
        this.YHBH = YHBH;
        this.YHMC = YHMC;
        this.YHMM = YHMM;
        this.QTXXQX = QTXXQX;
        this.CDCQX = CDCQX;
        this.MDBBQX = MDBBQX;
        this.TDQX = TDQX;
        this.ZPQX = ZPQX;
        this.XTJSQX = XTJSQX;
        this.BY15 = BY15;
        this.BY23 = BY23;
        this.BY25 = BY25;
        this.BY28 = BY28;
        this.BY32 = BY32;
        this.BY33 = BY33;
        this.BY54 = BY54;
        this.BY60 = BY60;
        this.BY95 = BY95;
        this.BY100 = BY100;
        this.BY101 = BY101;
        this.BY108 = BY108;
        this.BY112 = BY112;
        this.BY114 = BY114;
        this.BY115 = BY115;
        this.BY116 = BY116;
        this.BY117 = BY117;
        this.BY118 = BY118;
        this.BY120 = BY120;
        this.BY129 = BY129;
        this.BY130 = BY130;
        this.BY138 = BY138;
        this.BY148 = BY148;
        this.id = id;
    }
    private static YHJBQK yhjbqk=null;
    public static YHJBQK getInstance(){
        if(yhjbqk==null){
            yhjbqk=new YHJBQK();
        }
        return yhjbqk;
    }

    @Transient
    public final String sql = "select YHBH, YHMC, YHMM, HYMMQR, QTXXQX, CDCQX, " +
            " SDQX, MDBBQX, TDQX, ZKQX, ZRQX, ZPQX, XTJSQX, YHGLQX, JYXMLBSZQX, JYXMSZQX, BYJJE, " +
            " CDCJE, CNBZSZQX, JCZLSZ, QYJBXX, YHGL, DPXXSZ, DPPFSZ, XSLBBCX, YLJXCTJB, XSQJMLTJ," +
            " QJLRFX, WLKCGL, FSH, YLCGJCX, YLTHJCX, YLSHJCX, KCTZYY, YLKCTZJCX, YLPC, KHGXGL, " +
            " GYSSZ, CGFKJCX, CGFKSH, HYKSZ, HYJDJCX, QCLSSJ, BY1, BY2, BY3, BY4, BY5, BY6, BY7, " +
            " BY8, BY9, BY10, BY11, BY12, BY13, BY14, BY15, BY16, BY17, BY18, BY19, BY20, BY21, " +
            " BY22, BY23, BY24, BY25, BY26, BY27, BY28, BY29, BY30, BY31, BY32, BY33, BY34, BY35," +
            " BY36, BY37, BY38, BY39, BY40, BY41, BY42, BY43, BY44, BY45, BY46, BY47, BY48, BY49," +
            " BY50, BY51, BY52, BY53, BY54, BY55, BY56, BY57, BY58, BY59, BY60, BY61, BY62, BY63, " +
            " BY64, BY65, BY66, BY67, BY68, BY69, BY70, BY71, BY72, BY73, BY74, BY75, BY76, BY77," +
            " BY78, BY79, BY80, BY81, BY82, BY83, BY84, BY85, BY86, BY87, BY88, BY89, BY90, BY91, " +
            " BY92, BY93, BY94, BY95, BY96, BY97, BY98, BY99, BY100, BY101, BY102, BY103, BY104, " +
            " BY105, BY106, BY107, BY108, BY109, BY110, BY111, BY112, BY113, BY114, BY115, BY116," +
            " BY117, BY118, BY119, BY120, BY121, BY122, BY123, BY124, BY125, BY126, BY127, BY128," +
            " BY129, BY130, BY131, BY132, BY133, BY134, BY135, BY136, BY137, BY138, BY139, BY140, " +
            " BY141, BY142, BY143, BY144, BY145, BY146, BY147, BY148, BY149, BY150, id from Yhjbqk|";
    public MyStringRequest getRequest(){
        MyStringRequest request = new MyStringRequest(Request.Method.POST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        Type type = new TypeToken<List<YHJBQK>>() {
                        }.getType();
                        List<YHJBQK> listYhjbqk = gson.fromJson(response, type);
                        YHJBQKDao yhjbqkDao = App.getDaoSession().getYHJBQKDao();
                        yhjbqkDao.deleteAll();
                        yhjbqkDao.insertInTx(listYhjbqk);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        },sql);
        return request;
    }

    public String getYHBH() {
        return YHBH;
    }

    public void setYHBH(String YHBH) {
        this.YHBH = YHBH;
    }

    public String getYHMC() {
        return YHMC;
    }

    public void setYHMC(String YHMC) {
        this.YHMC = YHMC;
    }

    public String getYHMM() {
        return YHMM;
    }

    public void setYHMM(String YHMM) {
        this.YHMM = YHMM;
    }

    public String getQTXXQX() {
        return QTXXQX;
    }

    public void setQTXXQX(String QTXXQX) {
        this.QTXXQX = QTXXQX;
    }

    public String getCDCQX() {
        return CDCQX;
    }

    public void setCDCQX(String CDCQX) {
        this.CDCQX = CDCQX;
    }

    public String getMDBBQX() {
        return MDBBQX;
    }

    public void setMDBBQX(String MDBBQX) {
        this.MDBBQX = MDBBQX;
    }

    public String getTDQX() {
        return TDQX;
    }

    public void setTDQX(String TDQX) {
        this.TDQX = TDQX;
    }

    public String getZPQX() {
        return ZPQX;
    }

    public void setZPQX(String ZPQX) {
        this.ZPQX = ZPQX;
    }

    public String getXTJSQX() {
        return XTJSQX;
    }

    public void setXTJSQX(String XTJSQX) {
        this.XTJSQX = XTJSQX;
    }

    public String getBY15() {
        return BY15;
    }

    public void setBY15(String BY15) {
        this.BY15 = BY15;
    }

    public String getBY23() {
        return BY23;
    }

    public void setBY23(String BY23) {
        this.BY23 = BY23;
    }

    public String getBY25() {
        return BY25;
    }

    public void setBY25(String BY25) {
        this.BY25 = BY25;
    }

    public String getBY28() {
        return BY28;
    }

    public void setBY28(String BY28) {
        this.BY28 = BY28;
    }

    public String getBY32() {
        return BY32;
    }

    public void setBY32(String BY32) {
        this.BY32 = BY32;
    }

    public String getBY33() {
        return BY33;
    }

    public void setBY33(String BY33) {
        this.BY33 = BY33;
    }

    public String getBY54() {
        return BY54;
    }

    public void setBY54(String BY54) {
        this.BY54 = BY54;
    }

    public String getBY60() {
        return BY60;
    }

    public void setBY60(String BY60) {
        this.BY60 = BY60;
    }

    public String getBY95() {
        return BY95;
    }

    public void setBY95(String BY95) {
        this.BY95 = BY95;
    }

    public String getBY100() {
        return BY100;
    }

    public void setBY100(String BY100) {
        this.BY100 = BY100;
    }

    public String getBY101() {
        return BY101;
    }

    public void setBY101(String BY101) {
        this.BY101 = BY101;
    }

    public String getBY108() {
        return BY108;
    }

    public void setBY108(String BY108) {
        this.BY108 = BY108;
    }

    public String getBY112() {
        return BY112;
    }

    public void setBY112(String BY112) {
        this.BY112 = BY112;
    }

    public String getBY114() {
        return BY114;
    }

    public void setBY114(String BY114) {
        this.BY114 = BY114;
    }

    public String getBY115() {
        return BY115;
    }

    public void setBY115(String BY115) {
        this.BY115 = BY115;
    }

    public String getBY116() {
        return BY116;
    }

    public void setBY116(String BY116) {
        this.BY116 = BY116;
    }

    public String getBY117() {
        return BY117;
    }

    public void setBY117(String BY117) {
        this.BY117 = BY117;
    }

    public String getBY118() {
        return BY118;
    }

    public void setBY118(String BY118) {
        this.BY118 = BY118;
    }

    public String getBY120() {
        return BY120;
    }

    public void setBY120(String BY120) {
        this.BY120 = BY120;
    }

    public String getBY129() {
        return BY129;
    }

    public void setBY129(String BY129) {
        this.BY129 = BY129;
    }

    public String getBY130() {
        return BY130;
    }

    public void setBY130(String BY130) {
        this.BY130 = BY130;
    }

    public String getBY138() {
        return BY138;
    }

    public void setBY138(String BY138) {
        this.BY138 = BY138;
    }

    public String getBY148() {
        return BY148;
    }

    public void setBY148(String BY148) {
        this.BY148 = BY148;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
