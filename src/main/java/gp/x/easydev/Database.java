package gp.x.easydev;

import javax.sql.rowset.CachedRowSet;

public interface Database {
    CachedRowSet select(String var1, Object... var2);

    void insert(String var1, Object... var2);
}