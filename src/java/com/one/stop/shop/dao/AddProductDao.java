package com.one.stop.shop.dao;

import java.sql.SQLException;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OraclePreparedStatement;

public class AddProductDao {

    private OracleConnection oconn;
    private OraclePreparedStatement ops;

//    Constructor
    public AddProductDao(OracleConnection oconn) {
        this.oconn = oconn;
    }

    //    Method to insert to database:
    public boolean addMen(String pid, int catid, String pname, String pdetails, int price, String p_one, String p_two, String p_three, String p_four, String image) {
        boolean f = false;
        try {
            //user ---> database
            String query = "INSERT INTO men(p_id, category_id, p_name, p_details, p_price, sleeve, fit, type, fabric, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ops.setString(1, pid);
            ops.setInt(2, catid);
            ops.setString(3, pname);
            ops.setString(4, pdetails);
            ops.setInt(5, price);
            ops.setString(6, p_one);
            ops.setString(7, p_two);
            ops.setString(8, p_three);
            ops.setString(9, p_four);
            ops.setString(10, image);

            ops.executeUpdate();

            f = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return f;
    }

    //    Method to insert to database:
    public boolean addWomen(String pid, int catid, String pname, String pdetails, int price, String p_one, String p_two, String p_three, String p_four, String image) {
        boolean f = false;
        try {
            //user ---> database
            String query = "INSERT INTO women(p_id, category_id, p_name, p_details, p_price, pattern, fit, type, fabric, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ops.setString(1, pid);
            ops.setInt(2, catid);
            ops.setString(3, pname);
            ops.setString(4, pdetails);
            ops.setInt(5, price);
            ops.setString(6, p_one);
            ops.setString(7, p_two);
            ops.setString(8, p_three);
            ops.setString(9, p_four);
            ops.setString(10, image);

            ops.executeUpdate();

            f = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return f;
    }

    //    Method to insert to database:
    public boolean addFootwear(String pid, int catid, String pname, String pdetails, int price, String p_one, String p_two, String p_three, String p_four, String image) {
        boolean f = false;
        try {
            //user ---> database
            String query = "INSERT INTO footwear(p_id, category_id, p_name, p_details, p_price, outer_material, p_for, type, occasion, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ops.setString(1, pid);
            ops.setInt(2, catid);
            ops.setString(3, pname);
            ops.setString(4, pdetails);
            ops.setInt(5, price);
            ops.setString(6, p_one);
            ops.setString(7, p_two);
            ops.setString(8, p_three);
            ops.setString(9, p_four);
            ops.setString(10, image);

            ops.executeUpdate();

            f = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return f;
    }

    //    Method to insert to database:
    public boolean addJewellery(String pid, int catid, String pname, String pdetails, int price, String p_one, String p_two, String p_three, String p_four, String image) {
        boolean f = false;
        try {
            //user ---> database
            String query = "INSERT INTO jewellery(p_id, category_id, p_name, p_details, p_price, clasp_type, material_type, metal_type, gem_type, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ops.setString(1, pid);
            ops.setInt(2, catid);
            ops.setString(3, pname);
            ops.setString(4, pdetails);
            ops.setInt(5, price);
            ops.setString(6, p_one);
            ops.setString(7, p_two);
            ops.setString(8, p_three);
            ops.setString(9, p_four);
            ops.setString(10, image);

            ops.executeUpdate();

            f = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return f;
    }

    //    Method to insert to database:
    public boolean addHomeAndLiving(String pid, int catid, String pname, String pdetails, int price, String p_one, String p_two, String p_three, String p_four, String image) {
        boolean f = false;
        try {
            //user ---> database
            String query = "INSERT INTO homeandliving(p_id, category_id, p_name, p_details, p_price, color, material, use, country_origin, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ops.setString(1, pid);
            ops.setInt(2, catid);
            ops.setString(3, pname);
            ops.setString(4, pdetails);
            ops.setInt(5, price);
            ops.setString(6, p_one);
            ops.setString(7, p_two);
            ops.setString(8, p_three);
            ops.setString(9, p_four);
            ops.setString(10, image);

            ops.executeUpdate();

            f = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return f;
    }

    //    Method to insert to database:
    public boolean addElectronics(String pid, int catid, String pname, String pdetails, int price, String p_one, String p_two, String p_three, String p_four, String image) {
        boolean f = false;
        try {
            //user ---> database
            String query = "INSERT INTO electronics(p_id, category_id, p_name, p_details, p_price, color, weight, warranty, country_origin, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ops.setString(1, pid);
            ops.setInt(2, catid);
            ops.setString(3, pname);
            ops.setString(4, pdetails);
            ops.setInt(5, price);
            ops.setString(6, p_one);
            ops.setString(7, p_two);
            ops.setString(8, p_three);
            ops.setString(9, p_four);
            ops.setString(10, image);

            ops.executeUpdate();

            f = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return f;
    }

    //    Method to insert to database:
    public boolean addAllProducts(String pid, int catid, String pname, String pdetails, int price, String p_one, String p_two, String p_three, String p_four, String image) {
        boolean f = false;
        try {
            //user ---> database
            String query = "INSERT INTO all_products(p_id, category_id, p_name, p_details, p_price, sleeve, fit, type, fabric, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ops.setString(1, pid);
            ops.setInt(2, catid);
            ops.setString(3, pname);
            ops.setString(4, pdetails);
            ops.setInt(5, price);
            ops.setString(6, p_one);
            ops.setString(7, p_two);
            ops.setString(8, p_three);
            ops.setString(9, p_four);
            ops.setString(10, image);

            ops.executeUpdate();

            f = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return f;
    }
}
