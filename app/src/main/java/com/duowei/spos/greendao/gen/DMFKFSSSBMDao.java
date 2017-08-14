package com.duowei.spos.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.duowei.spos.bean.DMFKFSSSBM;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DMFKFSSSBM".
*/
public class DMFKFSSSBMDao extends AbstractDao<DMFKFSSSBM, Void> {

    public static final String TABLENAME = "DMFKFSSSBM";

    /**
     * Properties of entity DMFKFSSSBM.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property XH = new Property(0, String.class, "XH", false, "XH");
        public final static Property BMBH = new Property(1, String.class, "BMBH", false, "BMBH");
        public final static Property BM = new Property(2, String.class, "BM", false, "BM");
        public final static Property NR = new Property(3, String.class, "NR", false, "NR");
        public final static Property Id = new Property(4, String.class, "id", false, "ID");
    }


    public DMFKFSSSBMDao(DaoConfig config) {
        super(config);
    }
    
    public DMFKFSSSBMDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DMFKFSSSBM\" (" + //
                "\"XH\" TEXT," + // 0: XH
                "\"BMBH\" TEXT," + // 1: BMBH
                "\"BM\" TEXT," + // 2: BM
                "\"NR\" TEXT," + // 3: NR
                "\"ID\" TEXT);"); // 4: id
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DMFKFSSSBM\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DMFKFSSSBM entity) {
        stmt.clearBindings();
 
        String XH = entity.getXH();
        if (XH != null) {
            stmt.bindString(1, XH);
        }
 
        String BMBH = entity.getBMBH();
        if (BMBH != null) {
            stmt.bindString(2, BMBH);
        }
 
        String BM = entity.getBM();
        if (BM != null) {
            stmt.bindString(3, BM);
        }
 
        String NR = entity.getNR();
        if (NR != null) {
            stmt.bindString(4, NR);
        }
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(5, id);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DMFKFSSSBM entity) {
        stmt.clearBindings();
 
        String XH = entity.getXH();
        if (XH != null) {
            stmt.bindString(1, XH);
        }
 
        String BMBH = entity.getBMBH();
        if (BMBH != null) {
            stmt.bindString(2, BMBH);
        }
 
        String BM = entity.getBM();
        if (BM != null) {
            stmt.bindString(3, BM);
        }
 
        String NR = entity.getNR();
        if (NR != null) {
            stmt.bindString(4, NR);
        }
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(5, id);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public DMFKFSSSBM readEntity(Cursor cursor, int offset) {
        DMFKFSSSBM entity = new DMFKFSSSBM( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // XH
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // BMBH
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // BM
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // NR
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // id
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DMFKFSSSBM entity, int offset) {
        entity.setXH(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setBMBH(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setBM(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setNR(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setId(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(DMFKFSSSBM entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(DMFKFSSSBM entity) {
        return null;
    }

    @Override
    public boolean hasKey(DMFKFSSSBM entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
