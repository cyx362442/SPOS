package com.duowei.spos.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.duowei.spos.bean.DMFKFS;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DMFKFS".
*/
public class DMFKFSDao extends AbstractDao<DMFKFS, Void> {

    public static final String TABLENAME = "DMFKFS";

    /**
     * Properties of entity DMFKFS.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property BM = new Property(0, String.class, "BM", false, "BM");
        public final static Property NR = new Property(1, String.class, "NR", false, "NR");
        public final static Property FKLB = new Property(2, String.class, "FKLB", false, "FKLB");
        public final static Property XGSJ = new Property(3, String.class, "XGSJ", false, "XGSJ");
        public final static Property FKFS = new Property(4, String.class, "FKFS", false, "FKFS");
        public final static Property DYQMZ = new Property(5, String.class, "DYQMZ", false, "DYQMZ");
        public final static Property XL = new Property(6, String.class, "XL", false, "XL");
        public final static Property JWSJYYSR = new Property(7, String.class, "JWSJYYSR", false, "JWSJYYSR");
        public final static Property Id = new Property(8, String.class, "id", false, "ID");
        public final static Property BY4 = new Property(9, String.class, "BY4", false, "BY4");
    }


    public DMFKFSDao(DaoConfig config) {
        super(config);
    }
    
    public DMFKFSDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DMFKFS\" (" + //
                "\"BM\" TEXT," + // 0: BM
                "\"NR\" TEXT," + // 1: NR
                "\"FKLB\" TEXT," + // 2: FKLB
                "\"XGSJ\" TEXT," + // 3: XGSJ
                "\"FKFS\" TEXT," + // 4: FKFS
                "\"DYQMZ\" TEXT," + // 5: DYQMZ
                "\"XL\" TEXT," + // 6: XL
                "\"JWSJYYSR\" TEXT," + // 7: JWSJYYSR
                "\"ID\" TEXT," + // 8: id
                "\"BY4\" TEXT);"); // 9: BY4
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DMFKFS\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DMFKFS entity) {
        stmt.clearBindings();
 
        String BM = entity.getBM();
        if (BM != null) {
            stmt.bindString(1, BM);
        }
 
        String NR = entity.getNR();
        if (NR != null) {
            stmt.bindString(2, NR);
        }
 
        String FKLB = entity.getFKLB();
        if (FKLB != null) {
            stmt.bindString(3, FKLB);
        }
 
        String XGSJ = entity.getXGSJ();
        if (XGSJ != null) {
            stmt.bindString(4, XGSJ);
        }
 
        String FKFS = entity.getFKFS();
        if (FKFS != null) {
            stmt.bindString(5, FKFS);
        }
 
        String DYQMZ = entity.getDYQMZ();
        if (DYQMZ != null) {
            stmt.bindString(6, DYQMZ);
        }
 
        String XL = entity.getXL();
        if (XL != null) {
            stmt.bindString(7, XL);
        }
 
        String JWSJYYSR = entity.getJWSJYYSR();
        if (JWSJYYSR != null) {
            stmt.bindString(8, JWSJYYSR);
        }
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(9, id);
        }
 
        String BY4 = entity.getBY4();
        if (BY4 != null) {
            stmt.bindString(10, BY4);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DMFKFS entity) {
        stmt.clearBindings();
 
        String BM = entity.getBM();
        if (BM != null) {
            stmt.bindString(1, BM);
        }
 
        String NR = entity.getNR();
        if (NR != null) {
            stmt.bindString(2, NR);
        }
 
        String FKLB = entity.getFKLB();
        if (FKLB != null) {
            stmt.bindString(3, FKLB);
        }
 
        String XGSJ = entity.getXGSJ();
        if (XGSJ != null) {
            stmt.bindString(4, XGSJ);
        }
 
        String FKFS = entity.getFKFS();
        if (FKFS != null) {
            stmt.bindString(5, FKFS);
        }
 
        String DYQMZ = entity.getDYQMZ();
        if (DYQMZ != null) {
            stmt.bindString(6, DYQMZ);
        }
 
        String XL = entity.getXL();
        if (XL != null) {
            stmt.bindString(7, XL);
        }
 
        String JWSJYYSR = entity.getJWSJYYSR();
        if (JWSJYYSR != null) {
            stmt.bindString(8, JWSJYYSR);
        }
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(9, id);
        }
 
        String BY4 = entity.getBY4();
        if (BY4 != null) {
            stmt.bindString(10, BY4);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public DMFKFS readEntity(Cursor cursor, int offset) {
        DMFKFS entity = new DMFKFS( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // BM
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // NR
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // FKLB
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // XGSJ
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // FKFS
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // DYQMZ
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // XL
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // JWSJYYSR
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // id
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9) // BY4
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DMFKFS entity, int offset) {
        entity.setBM(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setNR(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setFKLB(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setXGSJ(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setFKFS(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setDYQMZ(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setXL(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setJWSJYYSR(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setId(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setBY4(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(DMFKFS entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(DMFKFS entity) {
        return null;
    }

    @Override
    public boolean hasKey(DMFKFS entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
