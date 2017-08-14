package com.duowei.spos.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Administrator on 2017-08-05.
 */
@Entity
public class WMLSB {
    @Id(autoincrement = true)
    private Long id;
    private int xh;
    private String wmdbh;
    private String xmbh;
    private String xmmc;
    private String tm;
    private String by2;
    private String dw;
    private float sl;
    private float ysjg;
    private float dj;
    /** dj*sl */
    private float xj;
    private String pz;
    private String sfyxd;
    private String xszt;
    private String syyxm;
    private String sfxs;
    private String by5;
    private String tcbh;
    private String tcxmbh;
    private String by15;
    private String by13;
    private String sfzs;
    private String zssj;
    private String sqrxm;
    private String by12;
    private String by3;
    private float dwsl;
    private String by17;
    private String by21;
    private String by1;
    private float kwjj;//口味加价
    // 原来的表没有，自己建的字段，单品类别名称 by zjn
    private String lbmc;
    @Generated(hash = 1128099465)
    public WMLSB(Long id, int xh, String wmdbh, String xmbh, String xmmc, String tm,
            String by2, String dw, float sl, float ysjg, float dj, float xj,
            String pz, String sfyxd, String xszt, String syyxm, String sfxs,
            String by5, String tcbh, String tcxmbh, String by15, String by13,
            String sfzs, String zssj, String sqrxm, String by12, String by3,
            float dwsl, String by17, String by21, String by1, float kwjj,
            String lbmc) {
        this.id = id;
        this.xh = xh;
        this.wmdbh = wmdbh;
        this.xmbh = xmbh;
        this.xmmc = xmmc;
        this.tm = tm;
        this.by2 = by2;
        this.dw = dw;
        this.sl = sl;
        this.ysjg = ysjg;
        this.dj = dj;
        this.xj = xj;
        this.pz = pz;
        this.sfyxd = sfyxd;
        this.xszt = xszt;
        this.syyxm = syyxm;
        this.sfxs = sfxs;
        this.by5 = by5;
        this.tcbh = tcbh;
        this.tcxmbh = tcxmbh;
        this.by15 = by15;
        this.by13 = by13;
        this.sfzs = sfzs;
        this.zssj = zssj;
        this.sqrxm = sqrxm;
        this.by12 = by12;
        this.by3 = by3;
        this.dwsl = dwsl;
        this.by17 = by17;
        this.by21 = by21;
        this.by1 = by1;
        this.kwjj = kwjj;
        this.lbmc = lbmc;
    }
    @Generated(hash = 2080435628)
    public WMLSB() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getXh() {
        return this.xh;
    }
    public void setXh(int xh) {
        this.xh = xh;
    }
    public String getWmdbh() {
        return this.wmdbh;
    }
    public void setWmdbh(String wmdbh) {
        this.wmdbh = wmdbh;
    }
    public String getXmbh() {
        return this.xmbh;
    }
    public void setXmbh(String xmbh) {
        this.xmbh = xmbh;
    }
    public String getXmmc() {
        return this.xmmc;
    }
    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }
    public String getTm() {
        return this.tm;
    }
    public void setTm(String tm) {
        this.tm = tm;
    }
    public String getBy2() {
        return this.by2;
    }
    public void setBy2(String by2) {
        this.by2 = by2;
    }
    public String getDw() {
        return this.dw;
    }
    public void setDw(String dw) {
        this.dw = dw;
    }
    public float getSl() {
        return this.sl;
    }
    public void setSl(float sl) {
        this.sl = sl;
    }
    public float getYsjg() {
        return this.ysjg;
    }
    public void setYsjg(float ysjg) {
        this.ysjg = ysjg;
    }
    public float getDj() {
        return this.dj;
    }
    public void setDj(float dj) {
        this.dj = dj;
    }
    public float getXj() {
        return this.xj;
    }
    public void setXj(float xj) {
        this.xj = xj;
    }
    public String getPz() {
        return this.pz;
    }
    public void setPz(String pz) {
        this.pz = pz;
    }
    public String getSfyxd() {
        return this.sfyxd;
    }
    public void setSfyxd(String sfyxd) {
        this.sfyxd = sfyxd;
    }
    public String getXszt() {
        return this.xszt;
    }
    public void setXszt(String xszt) {
        this.xszt = xszt;
    }
    public String getSyyxm() {
        return this.syyxm;
    }
    public void setSyyxm(String syyxm) {
        this.syyxm = syyxm;
    }
    public String getSfxs() {
        return this.sfxs;
    }
    public void setSfxs(String sfxs) {
        this.sfxs = sfxs;
    }
    public String getBy5() {
        return this.by5;
    }
    public void setBy5(String by5) {
        this.by5 = by5;
    }
    public String getTcbh() {
        return this.tcbh;
    }
    public void setTcbh(String tcbh) {
        this.tcbh = tcbh;
    }
    public String getTcxmbh() {
        return this.tcxmbh;
    }
    public void setTcxmbh(String tcxmbh) {
        this.tcxmbh = tcxmbh;
    }
    public String getBy15() {
        return this.by15;
    }
    public void setBy15(String by15) {
        this.by15 = by15;
    }
    public String getBy13() {
        return this.by13;
    }
    public void setBy13(String by13) {
        this.by13 = by13;
    }
    public String getSfzs() {
        return this.sfzs;
    }
    public void setSfzs(String sfzs) {
        this.sfzs = sfzs;
    }
    public String getZssj() {
        return this.zssj;
    }
    public void setZssj(String zssj) {
        this.zssj = zssj;
    }
    public String getSqrxm() {
        return this.sqrxm;
    }
    public void setSqrxm(String sqrxm) {
        this.sqrxm = sqrxm;
    }
    public String getBy12() {
        return this.by12;
    }
    public void setBy12(String by12) {
        this.by12 = by12;
    }
    public String getBy3() {
        return this.by3;
    }
    public void setBy3(String by3) {
        this.by3 = by3;
    }
    public float getDwsl() {
        return this.dwsl;
    }
    public void setDwsl(float dwsl) {
        this.dwsl = dwsl;
    }
    public String getBy17() {
        return this.by17;
    }
    public void setBy17(String by17) {
        this.by17 = by17;
    }
    public String getBy21() {
        return this.by21;
    }
    public void setBy21(String by21) {
        this.by21 = by21;
    }
    public String getBy1() {
        return this.by1;
    }
    public void setBy1(String by1) {
        this.by1 = by1;
    }
    public float getKwjj() {
        return this.kwjj;
    }
    public void setKwjj(float kwjj) {
        this.kwjj = kwjj;
    }
    public String getLbmc() {
        return this.lbmc;
    }
    public void setLbmc(String lbmc) {
        this.lbmc = lbmc;
    }
}
