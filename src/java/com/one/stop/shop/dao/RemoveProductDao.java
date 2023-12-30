package com.one.stop.shop.dao;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.OraclePreparedStatement;

public class RemoveProductDao {

    private OracleConnection oconn;
    private OraclePreparedStatement ops;

//    Constructor
    public RemoveProductDao(OracleConnection oconn) {
        this.oconn = oconn;
    }

    public void removeProduct(String pid, int cid) {
        try {
            if (cid == 1) {
                String query = "delete from men where p_id = ?";
                ops = (OraclePreparedStatement) oconn.prepareCall(query);
                ops.setString(1, pid);
            } else if (cid == 2) {
                String query = "delete from women where p_id = ?";
                ops = (OraclePreparedStatement) oconn.prepareCall(query);
                ops.setString(1, pid);
            } else if (cid == 3) {
                String query = "delete from footwear where p_id = ?";
                ops = (OraclePreparedStatement) oconn.prepareCall(query);
                ops.setString(1, pid);
            } else if (cid == 4) {
                String query = "delete from jewellery where p_id = ?";
                ops = (OraclePreparedStatement) oconn.prepareCall(query);
                ops.setString(1, pid);
            } else if (cid == 5) {
                String query = "delete from homeandliving where p_id = ?";
                ops = (OraclePreparedStatement) oconn.prepareCall(query);
                ops.setString(1, pid);
            } else if (cid == 6) {
                String query = "delete from electronics where p_id = ?";
                ops = (OraclePreparedStatement) oconn.prepareCall(query);
                ops.setString(1, pid);
            }
            ops.executeUpdate();
            
            String query = "delete from all_products where p_id = ?";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);
            ops.setString(1, pid);
            ops.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
