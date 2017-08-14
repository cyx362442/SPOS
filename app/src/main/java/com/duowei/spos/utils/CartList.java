package com.duowei.spos.utils;

import android.content.Context;
import android.support.annotation.NonNull;

import com.duowei.spos.app.App;
import com.duowei.spos.bean.DMFKFS;
import com.duowei.spos.bean.JYXMSZ;
import com.duowei.spos.bean.POS;
import com.duowei.spos.bean.TCSD;
import com.duowei.spos.bean.WMLSB;
import com.duowei.spos.event.Order;
import com.duowei.spos.event.UpdateOrder;
import com.duowei.spos.greendao.gen.WMLSBDao;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.greendao.annotation.Entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017-08-05.
 */

public class CartList {
    private static Context context;

    private CartList() {
    }
    private static CartList singleton = null;
    public static CartList getInstance() {
        if (singleton == null) {
            singleton = new CartList();
        }
        context= App.getContext();
        return singleton;
    }
    public void cartAdd(JYXMSZ jyxmsz){
        WMLSB wmlsb = new WMLSB();
        wmlsb.setWmdbh(POS.wmdbh);//单据编号
        wmlsb.setXmbh(jyxmsz.getXMBH());//单品编号
        wmlsb.setXmmc(jyxmsz.getXMMC());//单品名称
        wmlsb.setTm(jyxmsz.getTM());//单品内部编号
        wmlsb.setBy2(jyxmsz.getLBBM());//单品类别编码
        wmlsb.setDw(jyxmsz.getDW());//单位
        wmlsb.setSl(1);//数量
        wmlsb.setDwsl(1);//单位数量
        wmlsb.setYsjg(jyxmsz.getXSJG());//原始价格
        wmlsb.setDj(jyxmsz.getXSJG());//销售价格
        wmlsb.setXj(wmlsb.getDj()*wmlsb.getSl());//小计
        wmlsb.setPz("");//口味备注
//        wmlsb.setXszt(jyxmsz.getSfmypc());//是否时价单品
        wmlsb.setSyyxm("");//点单员姓名
        wmlsb.setLbmc(jyxmsz.getLBMC());
        App.getDaoSession().getWMLSBDao().insert(wmlsb);
        EventBus.getDefault().post(new Order(POS.wmdbh));
    }

    public void cartAdd(JYXMSZ jyxmsz, List<TCSD> tcsdList){
        WMLSB wmlsb = new WMLSB();
        String orderTime = DateTimes.getInstance().getTime();
        wmlsb.setWmdbh(POS.wmdbh);//单据编号
        wmlsb.setXmbh(jyxmsz.getXMBH());//单品编号
        wmlsb.setXmmc(jyxmsz.getXMMC());//单品名称
        wmlsb.setTm(jyxmsz.getTM());//单品内部编号
        wmlsb.setBy2(jyxmsz.getLBBM());//单品类别编码
        wmlsb.setDw(jyxmsz.getDW());//单位
        wmlsb.setSl(1);//数量
        wmlsb.setDwsl(1);//单位数量
        wmlsb.setYsjg(jyxmsz.getXSJG());//原始价格
        wmlsb.setDj(jyxmsz.getXSJG());//销售价格
        wmlsb.setXj(wmlsb.getDj()*wmlsb.getSl());//小计
        wmlsb.setPz("");//口味备注
//        wmlsb.setXszt(jyxmsz.getSfmypc());//是否时价单品
        wmlsb.setSyyxm("");//点单员姓名
        wmlsb.setLbmc(jyxmsz.getLBMC());
        wmlsb.setBy15("A");
        wmlsb.setTcbh(orderTime);
        App.getDaoSession().getWMLSBDao().insert(wmlsb);
        for (TCSD item : tcsdList) {
            WMLSB subWmlsb = new WMLSB();
            subWmlsb.setWmdbh(POS.wmdbh);
            subWmlsb.setXmbh(item.getXMBH1());
            subWmlsb.setXmmc("  " + item.getXMMC1());
            subWmlsb.setTm(item.getNBBM());
            subWmlsb.setSl(item.getSL());
            subWmlsb.setDwsl(item.getSL());
            subWmlsb.setDj(item.getDJ());
            subWmlsb.setYsjg(item.getDJ());
            subWmlsb.setXj(item.getSL()*item.getDJ());
            subWmlsb.setBy15(item.getTM());
            subWmlsb.setTcbh(orderTime);
            App.getDaoSession().getWMLSBDao().insert(subWmlsb);
        }
        EventBus.getDefault().post(new Order(POS.wmdbh));
    }

    public void orderUpdate(WMLSB wmlsb,float num){
        float sl = wmlsb.getSl();
        float dj = wmlsb.getDj();
        if(num<0&&-num>=sl){//删除一项
            App.getDaoSession().getWMLSBDao().delete(wmlsb);

            if("A".equals(wmlsb.getBy15())){//套餐
                List<WMLSB> subList = App.getDaoSession().getWMLSBDao().queryBuilder().
                        where(WMLSBDao.Properties.Tcbh.eq(wmlsb.getTcbh()), WMLSBDao.Properties.By15.notEq("A")).list();
                App.getDaoSession().getWMLSBDao().deleteInTx(subList);
            }
        }else{//更新数量
            wmlsb.setSl(sl+num);
            wmlsb.setXj(wmlsb.getSl()*dj);
            App.getDaoSession().getWMLSBDao().update(wmlsb);

            if("A".equals(wmlsb.getBy15())){//套餐
                List<WMLSB> subList = App.getDaoSession().getWMLSBDao().queryBuilder().
                        where(WMLSBDao.Properties.Tcbh.eq(wmlsb.getTcbh()), WMLSBDao.Properties.By15.notEq("A")).list();
                for(WMLSB w:subList){
                    float sl1 = w.getSl();
                    float dj1 = w.getDj();
                    float dwsl = w.getDwsl();
                    w.setSl(sl1+dwsl*num);
                    w.setXj(dj1*w.getSl());
                    App.getDaoSession().getWMLSBDao().update(w);
                }
            }
        }
        EventBus.getDefault().post(new UpdateOrder());
    }
}
