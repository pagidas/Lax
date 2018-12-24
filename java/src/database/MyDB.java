package database;

import java.sql.ResultSet;

public class MyDB {

    /*
     * These fields are put for a specific Database
     * with a specific admin -- root:root (username:password)
     *
     * * --A Static Class-- *
     */
    private static final String DB_URL = "localhost:3306";
    private static final String DB_NAME = "lax_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWD = "root";

    private static Database aDB = new Database();

    //private default constructor
    private MyDB() {}

    public static <T> T connectAndExecute(String query, byte type) {
        switch(type) {
            case 0:
                return (T) (ResultSet)aDB.Database(DB_URL, DB_NAME, DB_USER, DB_PASSWD, query);
            case 1:
                return (T) Integer.valueOf(aDB.Database(DB_URL, DB_NAME, DB_USER, DB_PASSWD, query, (byte)1));
        }
        return null;
    }

    public static Database getDB() {
        return aDB;
    }
}