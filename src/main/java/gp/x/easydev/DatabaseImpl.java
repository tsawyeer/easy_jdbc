package gp.x.easydev;


import com.sun.rowset.CachedRowSetImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.sql.rowset.CachedRowSet;

public class DatabaseImpl implements Database {
    private DatabaseConnection db = new DatabaseConnection();

    public CachedRowSet select(String queryStr, Object... args) {
        Connection connection = this.db.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        CachedRowSetImpl rows = null;

        try {
            ps = connection.prepareStatement(queryStr);

            for (int i = 0; i < args.length; ++i) {
                System.out.println(args[i].getClass());
                if (args[i] instanceof String) {
                    ps.setString(i + 1, String.valueOf(args[i]));
                }

                if (args[i] instanceof Integer) {
                    ps.setInt(i + 1, (Integer) args[i]);
                }

                if (args[i] instanceof Date) {
                    ps.setDate(i + 1, (Date) args[i]);
                }

                if (args[i] instanceof Timestamp) {
                    ps.setTimestamp(i + 1, (Timestamp) args[i]);
                }
            }

            rs = ps.executeQuery();
            rows = new CachedRowSetImpl();
            rows.populate(rs);
        } catch (SQLException var9) {
            var9.printStackTrace();
        }

        try {
            ps.close();
            rs.close();
            connection.close();
        } catch (SQLException var8) {
            var8.printStackTrace();
        }

        return rows;
    }

    public void insert(String queryStr, Object... args) {
        Connection connection = this.db.connect();
        PreparedStatement ps = null;
        Object var5 = null;

        try {
            ps = connection.prepareStatement(queryStr);

            for (int i = 0; i < args.length; ++i) {
                if (args[i] instanceof String) {
                    ps.setString(i + 1, String.valueOf(args[i]));
                }

                if (args[i] instanceof Integer) {
                    ps.setInt(i + 1, (Integer) args[i]);
                }

                if (args[i] instanceof Date) {
                    ps.setDate(i + 1, (Date) args[i]);
                }
            }

            ps.executeUpdate();
        } catch (SQLException var8) {
            var8.printStackTrace();
        }

        try {
            ps.close();
            connection.close();
        } catch (SQLException var7) {
            var7.printStackTrace();
        }

    }

    public DatabaseImpl(String propertyPathStr) {
        PropertiesReader propertiesReader = new PropertiesReader(propertyPathStr);
        this.db.setDbConnectionUrl(propertiesReader.getValue("DB_CONNECTION"));
        this.db.setDbDriver(propertiesReader.getValue("DB_DRIVER"));
        this.db.setDbUserName(propertiesReader.getValue("DB_USER"));
        this.db.setDbPassword(propertiesReader.getValue("DB_PASSWORD"));
        this.db.setDbName(propertiesReader.getValue("DB_NAME"));
    }
    public DatabaseImpl(String DB_CONNECTION,String DB_DRIVER,String DB_USER,String DB_PASSWORD,String DB_NAME) {
        this.db.setDbConnectionUrl(DB_CONNECTION);
        this.db.setDbDriver(DB_DRIVER);
        this.db.setDbUserName(DB_USER);
        this.db.setDbPassword(DB_PASSWORD);
        this.db.setDbName(DB_NAME);
    }
}