package com.one.stop.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OraclePreparedStatement;

public class LastProductID {

    private OracleConnection oconn;
    private OraclePreparedStatement ops;

//    Constructor
    public LastProductID(OracleConnection oconn) {
        this.oconn = oconn;
    }

    //    To get the last value in the men table
    public String lastMen() {
        String id = "No ID found";
        try {
            //user ---> database
            String query = "SELECT p_id FROM (SELECT p_id FROM men ORDER BY p_id DESC) WHERE ROWNUM = 1";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet set = ops.executeQuery();
            if (set.next()) {
                id = set.getString("p_id");
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    //    To get the last value in the women table
    public String lastWomen() {
        String id = "No ID found";
        try {
            //user ---> database
            String query = "SELECT p_id FROM (SELECT p_id FROM women ORDER BY p_id DESC) WHERE ROWNUM = 1";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet set = ops.executeQuery();
            if (set.next()) {
                id = set.getString("p_id");
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    //    To get the last value in the footwear table
    public String lastFootwear() {
        String id = "No ID found";
        try {
            //user ---> database
            String query = "SELECT p_id FROM (SELECT p_id FROM footwear ORDER BY p_id DESC) WHERE ROWNUM = 1";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet set = ops.executeQuery();
            if (set.next()) {
                id = set.getString("p_id");
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    //    To get the last value in the jewellery table
    public String lastJewellery() {
        String id = "No ID found";
        try {
            //user ---> database
            String query = "SELECT p_id FROM (SELECT p_id FROM jewellery ORDER BY p_id DESC) WHERE ROWNUM = 1";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet set = ops.executeQuery();
            if (set.next()) {
                id = set.getString("p_id");
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    //    To get the last value in the home and living table
    public String lastHomeAndLiving() {
        String id = "No ID found";
        try {
            //user ---> database
            String query = "SELECT p_id FROM (SELECT p_id FROM homeandliving ORDER BY p_id DESC) WHERE ROWNUM = 1";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet set = ops.executeQuery();
            if (set.next()) {
                id = set.getString("p_id");
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    //    To get the last value in the electronics table
    public String lastElectronics() {
        String id = "No ID found";
        try {
            //user ---> database
            String query = "SELECT p_id FROM (SELECT p_id FROM electronics ORDER BY p_id DESC) WHERE ROWNUM = 1";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet set = ops.executeQuery();
            if (set.next()) {
                id = set.getString("p_id");
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }
}
