package com.duowei.spos.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.duowei.spos.bean.YHJBQK;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "YHJBQK".
*/
public class YHJBQKDao extends AbstractDao<YHJBQK, Void> {

    public static final String TABLENAME = "YHJBQK";

    /**
     * Properties of entity YHJBQK.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property YHBH = new Property(0, String.class, "YHBH", false, "YHBH");
        public final static Property YHMC = new Property(1, String.class, "YHMC", false, "YHMC");
        public final static Property YHMM = new Property(2, String.class, "YHMM", false, "YHMM");
        public final static Property QTXXQX = new Property(3, String.class, "QTXXQX", false, "QTXXQX");
        public final static Property CDCQX = new Property(4, String.class, "CDCQX", false, "CDCQX");
        public final static Property MDBBQX = new Property(5, String.class, "MDBBQX", false, "MDBBQX");
        public final static Property TDQX = new Property(6, String.class, "TDQX", false, "TDQX");
        public final static Property ZPQX = new Property(7, String.class, "ZPQX", false, "ZPQX");
        public final static Property XTJSQX = new Property(8, String.class, "XTJSQX", false, "XTJSQX");
        public final static Property BY15 = new Property(9, String.class, "BY15", false, "BY15");
        public final static Property BY23 = new Property(10, String.class, "BY23", false, "BY23");
        public final static Property BY25 = new Property(11, String.class, "BY25", false, "BY25");
        public final static Property BY28 = new Property(12, String.class, "BY28", false, "BY28");
        public final static Property BY32 = new Property(13, String.class, "BY32", false, "BY32");
        public final static Property BY33 = new Property(14, String.class, "BY33", false, "BY33");
        public final static Property BY54 = new Property(15, String.class, "BY54", false, "BY54");
        public final static Property BY60 = new Property(16, String.class, "BY60", false, "BY60");
        public final static Property BY95 = new Property(17, String.class, "BY95", false, "BY95");
        public final static Property BY100 = new Property(18, String.class, "BY100", false, "BY100");
        public final static Property BY101 = new Property(19, String.class, "BY101", false, "BY101");
        public final static Property BY108 = new Property(20, String.class, "BY108", false, "BY108");
        public final static Property BY112 = new Property(21, String.class, "BY112", false, "BY112");
        public final static Property BY114 = new Property(22, String.class, "BY114", false, "BY114");
        public final static Property BY115 = new Property(23, String.class, "BY115", false, "BY115");
        public final static Property BY116 = new Property(24, String.class, "BY116", false, "BY116");
        public final static Property BY117 = new Property(25, String.class, "BY117", false, "BY117");
        public final static Property BY118 = new Property(26, String.class, "BY118", false, "BY118");
        public final static Property BY120 = new Property(27, String.class, "BY120", false, "BY120");
        public final static Property BY129 = new Property(28, String.class, "BY129", false, "BY129");
        public final static Property BY130 = new Property(29, String.class, "BY130", false, "BY130");
        public final static Property BY138 = new Property(30, String.class, "BY138", false, "BY138");
        public final static Property BY148 = new Property(31, String.class, "BY148", false, "BY148");
        public final static Property Id = new Property(32, String.class, "id", false, "ID");
    }


    public YHJBQKDao(DaoConfig config) {
        super(config);
    }
    
    public YHJBQKDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"YHJBQK\" (" + //
                "\"YHBH\" TEXT," + // 0: YHBH
                "\"YHMC\" TEXT," + // 1: YHMC
                "\"YHMM\" TEXT," + // 2: YHMM
                "\"QTXXQX\" TEXT," + // 3: QTXXQX
                "\"CDCQX\" TEXT," + // 4: CDCQX
                "\"MDBBQX\" TEXT," + // 5: MDBBQX
                "\"TDQX\" TEXT," + // 6: TDQX
                "\"ZPQX\" TEXT," + // 7: ZPQX
                "\"XTJSQX\" TEXT," + // 8: XTJSQX
                "\"BY15\" TEXT," + // 9: BY15
                "\"BY23\" TEXT," + // 10: BY23
                "\"BY25\" TEXT," + // 11: BY25
                "\"BY28\" TEXT," + // 12: BY28
                "\"BY32\" TEXT," + // 13: BY32
                "\"BY33\" TEXT," + // 14: BY33
                "\"BY54\" TEXT," + // 15: BY54
                "\"BY60\" TEXT," + // 16: BY60
                "\"BY95\" TEXT," + // 17: BY95
                "\"BY100\" TEXT," + // 18: BY100
                "\"BY101\" TEXT," + // 19: BY101
                "\"BY108\" TEXT," + // 20: BY108
                "\"BY112\" TEXT," + // 21: BY112
                "\"BY114\" TEXT," + // 22: BY114
                "\"BY115\" TEXT," + // 23: BY115
                "\"BY116\" TEXT," + // 24: BY116
                "\"BY117\" TEXT," + // 25: BY117
                "\"BY118\" TEXT," + // 26: BY118
                "\"BY120\" TEXT," + // 27: BY120
                "\"BY129\" TEXT," + // 28: BY129
                "\"BY130\" TEXT," + // 29: BY130
                "\"BY138\" TEXT," + // 30: BY138
                "\"BY148\" TEXT," + // 31: BY148
                "\"ID\" TEXT);"); // 32: id
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"YHJBQK\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, YHJBQK entity) {
        stmt.clearBindings();
 
        String YHBH = entity.getYHBH();
        if (YHBH != null) {
            stmt.bindString(1, YHBH);
        }
 
        String YHMC = entity.getYHMC();
        if (YHMC != null) {
            stmt.bindString(2, YHMC);
        }
 
        String YHMM = entity.getYHMM();
        if (YHMM != null) {
            stmt.bindString(3, YHMM);
        }
 
        String QTXXQX = entity.getQTXXQX();
        if (QTXXQX != null) {
            stmt.bindString(4, QTXXQX);
        }
 
        String CDCQX = entity.getCDCQX();
        if (CDCQX != null) {
            stmt.bindString(5, CDCQX);
        }
 
        String MDBBQX = entity.getMDBBQX();
        if (MDBBQX != null) {
            stmt.bindString(6, MDBBQX);
        }
 
        String TDQX = entity.getTDQX();
        if (TDQX != null) {
            stmt.bindString(7, TDQX);
        }
 
        String ZPQX = entity.getZPQX();
        if (ZPQX != null) {
            stmt.bindString(8, ZPQX);
        }
 
        String XTJSQX = entity.getXTJSQX();
        if (XTJSQX != null) {
            stmt.bindString(9, XTJSQX);
        }
 
        String BY15 = entity.getBY15();
        if (BY15 != null) {
            stmt.bindString(10, BY15);
        }
 
        String BY23 = entity.getBY23();
        if (BY23 != null) {
            stmt.bindString(11, BY23);
        }
 
        String BY25 = entity.getBY25();
        if (BY25 != null) {
            stmt.bindString(12, BY25);
        }
 
        String BY28 = entity.getBY28();
        if (BY28 != null) {
            stmt.bindString(13, BY28);
        }
 
        String BY32 = entity.getBY32();
        if (BY32 != null) {
            stmt.bindString(14, BY32);
        }
 
        String BY33 = entity.getBY33();
        if (BY33 != null) {
            stmt.bindString(15, BY33);
        }
 
        String BY54 = entity.getBY54();
        if (BY54 != null) {
            stmt.bindString(16, BY54);
        }
 
        String BY60 = entity.getBY60();
        if (BY60 != null) {
            stmt.bindString(17, BY60);
        }
 
        String BY95 = entity.getBY95();
        if (BY95 != null) {
            stmt.bindString(18, BY95);
        }
 
        String BY100 = entity.getBY100();
        if (BY100 != null) {
            stmt.bindString(19, BY100);
        }
 
        String BY101 = entity.getBY101();
        if (BY101 != null) {
            stmt.bindString(20, BY101);
        }
 
        String BY108 = entity.getBY108();
        if (BY108 != null) {
            stmt.bindString(21, BY108);
        }
 
        String BY112 = entity.getBY112();
        if (BY112 != null) {
            stmt.bindString(22, BY112);
        }
 
        String BY114 = entity.getBY114();
        if (BY114 != null) {
            stmt.bindString(23, BY114);
        }
 
        String BY115 = entity.getBY115();
        if (BY115 != null) {
            stmt.bindString(24, BY115);
        }
 
        String BY116 = entity.getBY116();
        if (BY116 != null) {
            stmt.bindString(25, BY116);
        }
 
        String BY117 = entity.getBY117();
        if (BY117 != null) {
            stmt.bindString(26, BY117);
        }
 
        String BY118 = entity.getBY118();
        if (BY118 != null) {
            stmt.bindString(27, BY118);
        }
 
        String BY120 = entity.getBY120();
        if (BY120 != null) {
            stmt.bindString(28, BY120);
        }
 
        String BY129 = entity.getBY129();
        if (BY129 != null) {
            stmt.bindString(29, BY129);
        }
 
        String BY130 = entity.getBY130();
        if (BY130 != null) {
            stmt.bindString(30, BY130);
        }
 
        String BY138 = entity.getBY138();
        if (BY138 != null) {
            stmt.bindString(31, BY138);
        }
 
        String BY148 = entity.getBY148();
        if (BY148 != null) {
            stmt.bindString(32, BY148);
        }
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(33, id);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, YHJBQK entity) {
        stmt.clearBindings();
 
        String YHBH = entity.getYHBH();
        if (YHBH != null) {
            stmt.bindString(1, YHBH);
        }
 
        String YHMC = entity.getYHMC();
        if (YHMC != null) {
            stmt.bindString(2, YHMC);
        }
 
        String YHMM = entity.getYHMM();
        if (YHMM != null) {
            stmt.bindString(3, YHMM);
        }
 
        String QTXXQX = entity.getQTXXQX();
        if (QTXXQX != null) {
            stmt.bindString(4, QTXXQX);
        }
 
        String CDCQX = entity.getCDCQX();
        if (CDCQX != null) {
            stmt.bindString(5, CDCQX);
        }
 
        String MDBBQX = entity.getMDBBQX();
        if (MDBBQX != null) {
            stmt.bindString(6, MDBBQX);
        }
 
        String TDQX = entity.getTDQX();
        if (TDQX != null) {
            stmt.bindString(7, TDQX);
        }
 
        String ZPQX = entity.getZPQX();
        if (ZPQX != null) {
            stmt.bindString(8, ZPQX);
        }
 
        String XTJSQX = entity.getXTJSQX();
        if (XTJSQX != null) {
            stmt.bindString(9, XTJSQX);
        }
 
        String BY15 = entity.getBY15();
        if (BY15 != null) {
            stmt.bindString(10, BY15);
        }
 
        String BY23 = entity.getBY23();
        if (BY23 != null) {
            stmt.bindString(11, BY23);
        }
 
        String BY25 = entity.getBY25();
        if (BY25 != null) {
            stmt.bindString(12, BY25);
        }
 
        String BY28 = entity.getBY28();
        if (BY28 != null) {
            stmt.bindString(13, BY28);
        }
 
        String BY32 = entity.getBY32();
        if (BY32 != null) {
            stmt.bindString(14, BY32);
        }
 
        String BY33 = entity.getBY33();
        if (BY33 != null) {
            stmt.bindString(15, BY33);
        }
 
        String BY54 = entity.getBY54();
        if (BY54 != null) {
            stmt.bindString(16, BY54);
        }
 
        String BY60 = entity.getBY60();
        if (BY60 != null) {
            stmt.bindString(17, BY60);
        }
 
        String BY95 = entity.getBY95();
        if (BY95 != null) {
            stmt.bindString(18, BY95);
        }
 
        String BY100 = entity.getBY100();
        if (BY100 != null) {
            stmt.bindString(19, BY100);
        }
 
        String BY101 = entity.getBY101();
        if (BY101 != null) {
            stmt.bindString(20, BY101);
        }
 
        String BY108 = entity.getBY108();
        if (BY108 != null) {
            stmt.bindString(21, BY108);
        }
 
        String BY112 = entity.getBY112();
        if (BY112 != null) {
            stmt.bindString(22, BY112);
        }
 
        String BY114 = entity.getBY114();
        if (BY114 != null) {
            stmt.bindString(23, BY114);
        }
 
        String BY115 = entity.getBY115();
        if (BY115 != null) {
            stmt.bindString(24, BY115);
        }
 
        String BY116 = entity.getBY116();
        if (BY116 != null) {
            stmt.bindString(25, BY116);
        }
 
        String BY117 = entity.getBY117();
        if (BY117 != null) {
            stmt.bindString(26, BY117);
        }
 
        String BY118 = entity.getBY118();
        if (BY118 != null) {
            stmt.bindString(27, BY118);
        }
 
        String BY120 = entity.getBY120();
        if (BY120 != null) {
            stmt.bindString(28, BY120);
        }
 
        String BY129 = entity.getBY129();
        if (BY129 != null) {
            stmt.bindString(29, BY129);
        }
 
        String BY130 = entity.getBY130();
        if (BY130 != null) {
            stmt.bindString(30, BY130);
        }
 
        String BY138 = entity.getBY138();
        if (BY138 != null) {
            stmt.bindString(31, BY138);
        }
 
        String BY148 = entity.getBY148();
        if (BY148 != null) {
            stmt.bindString(32, BY148);
        }
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(33, id);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public YHJBQK readEntity(Cursor cursor, int offset) {
        YHJBQK entity = new YHJBQK( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // YHBH
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // YHMC
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // YHMM
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // QTXXQX
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // CDCQX
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // MDBBQX
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // TDQX
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // ZPQX
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // XTJSQX
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // BY15
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // BY23
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // BY25
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // BY28
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // BY32
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // BY33
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // BY54
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // BY60
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // BY95
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // BY100
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // BY101
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // BY108
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), // BY112
            cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22), // BY114
            cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23), // BY115
            cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24), // BY116
            cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25), // BY117
            cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26), // BY118
            cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27), // BY120
            cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28), // BY129
            cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29), // BY130
            cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30), // BY138
            cursor.isNull(offset + 31) ? null : cursor.getString(offset + 31), // BY148
            cursor.isNull(offset + 32) ? null : cursor.getString(offset + 32) // id
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, YHJBQK entity, int offset) {
        entity.setYHBH(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setYHMC(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setYHMM(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setQTXXQX(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCDCQX(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setMDBBQX(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setTDQX(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setZPQX(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setXTJSQX(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setBY15(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setBY23(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setBY25(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setBY28(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setBY32(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setBY33(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setBY54(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setBY60(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setBY95(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setBY100(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setBY101(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setBY108(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setBY112(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setBY114(cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22));
        entity.setBY115(cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23));
        entity.setBY116(cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24));
        entity.setBY117(cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25));
        entity.setBY118(cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26));
        entity.setBY120(cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27));
        entity.setBY129(cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28));
        entity.setBY130(cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29));
        entity.setBY138(cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30));
        entity.setBY148(cursor.isNull(offset + 31) ? null : cursor.getString(offset + 31));
        entity.setId(cursor.isNull(offset + 32) ? null : cursor.getString(offset + 32));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(YHJBQK entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(YHJBQK entity) {
        return null;
    }

    @Override
    public boolean hasKey(YHJBQK entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
