package com.one.stop.shop.dao;

import com.one.stop.shop.entities.Cart;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OraclePreparedStatement;

public class CartDao {

    private OracleConnection oconn;
    private OraclePreparedStatement ops;

//    Constructor
    public CartDao(OracleConnection oconn) {
        this.oconn = oconn;
    }

    public boolean addToCart(Cart cart) {
        boolean flag = false;
        try {
            String query = "Insert into cart(u_id, p_id,p_name,price, quantity) values(?,?,?,?,?)";
            ops = (OraclePreparedStatement) this.oconn.prepareStatement(query);
            ops.setString(1, cart.getUserId());
            ops.setString(2, cart.getProductId());
            ops.setString(3, cart.getProductName());
            ops.setInt(4, cart.getPrice());
            ops.setInt(5, cart.getQuantity());

            ops.executeUpdate();
            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public Cart getCartByProductId(String pid, String uEmail, int quantity) throws SQLException {
        Cart ct = new Cart();
        try {
            String query = "SELECT * FROM all_products WHERE p_id = ?";

            ops = (OraclePreparedStatement) oconn.prepareCall(query);
            ops.setString(1, pid);

            ResultSet set = ops.executeQuery();
            if (set.next()) {
                ct.setProductId(set.getString("p_id"));
                ct.setProductName(set.getString("p_name"));
                ct.setQuantity(quantity); 
                ct.setPrice(set.getInt("p_price"));
                ct.setUserId(uEmail);  
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ct;
    }

    public List<Cart> getCartListByUserId(String uid) {
        List<Cart> list = new ArrayList<Cart>();
        try {
            String query = "select * from cart where u_id = ?";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);
            ops.setString(1, uid);

            ResultSet rs = ops.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart();
                cart.setUserId(rs.getString("u_id"));
                cart.setProductId(rs.getString("p_id"));
                cart.setProductName(rs.getString("p_name"));
                cart.setPrice(rs.getInt("price"));
                cart.setQuantity(rs.getInt("quantity"));

                list.add(cart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public int getQuantityById(String uid, String id) {
        int qty = 0;
        try {
            String query = "select * from cart where p_id = ? and u_id=?";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);
            ops.setString(1, id);
            ops.setString(2, uid);
            ResultSet rs = ops.executeQuery();
            while (rs.next()) {
                qty = rs.getInt("quantity");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qty;
    }

    public void updateQuantity(String uid, String id, int qty) {

        try {
            String query = "update cart set quantity = ? where p_id = ? and u_id = ?  ";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);
            ops.setInt(1, qty);
            ops.setString(2, id);
            ops.setString(3, uid);

            ops.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeProduct(String id, String uid) {
        try {
            String query = "delete from cart where p_id = ? and u_id = ?";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);
            ops.setString(1, id);
            ops.setString(2, uid);

            ops.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int countProducts(String uid) {
        int count = 0;
        try {
            String query = "SELECT COUNT(p_id) AS product FROM cart WHERE u_id = ?";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);
            ops.setString(1, uid);

            ResultSet set = ops.executeQuery();
            if (set.next()) {
                // Move to the first row and retrieve the count
                count = set.getInt("product");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
//
    public void removeAllProduct(String uid) {
        try {
            String query = "delete from cart where u_id=?";
            PreparedStatement ops = this.oconn.prepareStatement(query);
            ops.setString(1, uid);
            ops.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
