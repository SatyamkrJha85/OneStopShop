package com.one.stop.shop.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.OracleConnection;

public class ConnectionProvider {

    private static OracleConnection oconn;

    public static Connection getConnection() {
        try {
            if (oconn == null) {
                // Load the Oracle JDBC driver class
                Class.forName("oracle.jdbc.OracleDriver");

                // Create a connection
                oconn = (OracleConnection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SYSTEM", "DATABASE");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return oconn;
    }
}
