package com.yshi.hive.jdbc;

import org.apache.commons.dbutils.DbUtils;

import java.sql.*;

public class ImpalaClient {

    private static final String DFT_URL = "jdbc:hive2://nightly510-unsecure-2.gce.cloudera.com:21050/;auth=noSasl";
    private static final String DFT_USER = "impala";
    private static final String DFT_PSWD = "";

    public static void main (String args[]) throws SQLException, ClassNotFoundException {

        Class.forName("org.apache.hive.jdbc.HiveDriver");

        String url = DFT_URL;
        if (args.length > 0) {
            url = args[0];
        }

        String user = DFT_USER;
        if (args.length > 1) {
            user = args[1];
        }

        String password = DFT_PSWD;
        if (args.length > 2) {
            password = args[2];
        }

        Connection db = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            db = DriverManager.getConnection(url, user, password);
            stmt = db.createStatement();
            rs = stmt.executeQuery("describe default.sample_07");

            ResultSetMetaData metaData = rs.getMetaData();
            while (rs.next()) {
                for (int i = 1; i <=metaData.getColumnCount(); i++) {
                    System.out.print(metaData.getColumnName(i) + ":" + rs.getString(i) + '\t');
                }
                System.out.println();
            }
        } finally {
            DbUtils.closeQuietly(db, stmt, rs);
        }
    }
}
