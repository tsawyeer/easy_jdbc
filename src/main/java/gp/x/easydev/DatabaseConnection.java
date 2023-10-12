package gp.x.easydev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private String dbDriver;
    private String dbConnectionUrl;
    private String dbUserName;
    private String dbPassword;
    private String dbName;
    private Connection dbConnection;

    public DatabaseConnection() {
    }

    public Connection connect() {
        String iteratorStr = ":";
        if (this.dbDriver.equals("org.postgresql.Driver")) {
        }

        iteratorStr = "/";

        try {
            Class.forName(this.dbDriver);
        } catch (ClassNotFoundException var5) {
            System.out.println("1* " + var5.getMessage());
        }

        try {
            Connection dbConnection = DriverManager.getConnection(this.dbConnectionUrl + iteratorStr + this.dbName, this.dbUserName, this.dbPassword);
            return dbConnection;
        } catch (SQLException var4) {
            System.out.println("2* " + var4.getMessage());
            return null;
        }
    }

    public String getDbName() {
        return this.dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public void disconnect() {
    }

    public String getDbDriver() {
        return this.dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        byte var3 = -1;
        switch (dbDriver.hashCode()) {
            case -2105481388:
                if (dbDriver.equals("postgresql")) {
                    var3 = 1;
                }
                break;
            case -1008861826:
                if (dbDriver.equals("oracle")) {
                    var3 = 0;
                }
        }

        switch (var3) {
            case 0:
                this.dbDriver = "oracle.jdbc.driver.OracleDriver";
                break;
            case 1:
                this.dbDriver = "org.postgresql.Driver";
                break;
            default:
                this.dbDriver = dbDriver;
        }

    }

    public String getDbConnectionUrl() {
        return this.dbConnectionUrl;
    }

    public void setDbConnectionUrl(String dbConnectionUrl) {
        this.dbConnectionUrl = dbConnectionUrl;
    }

    public String getDbUserName() {
        return this.dbUserName;
    }

    public void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }

    public String getDbPassword() {
        return this.dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String toString() {
        return "DatabaseConnection{dbDriver='" + this.dbDriver + '\'' + ", dbConnectionUrl='" + this.dbConnectionUrl + '\'' + ", dbUserName='" + this.dbUserName + '\'' + ", dbPassword='" + this.dbPassword + '\'' + ", dbName='" + this.dbName + '\'' + ", dbConnection=" + this.dbConnection + '}';
    }
}