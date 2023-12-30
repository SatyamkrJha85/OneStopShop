
package com.one.stop.shop.dao;

import com.one.stop.shop.entities.Order;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OraclePreparedStatement;

public class OrderDao {

    private OracleConnection oconn;
    private OraclePreparedStatement ops;

//    Constructor
    public OrderDao(OracleConnection oconn) {
        this.oconn = oconn;
    }

    public boolean saveOrder(Order ord) {
        boolean f = false;
        try {
            //user ---> database
            String query = "Insert into orders(order_id,u_id,p_id,p_name,price,quantity,full_name,address,order_date) values(?,?,?,?,?,?,?,?,CURRENT_DATE)";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ops.setInt(1, ord.getOrderId());
            ops.setString(2, ord.getuId());
            ops.setString(3, ord.getpId());
            ops.setString(4, ord.getpName());
            ops.setInt(5, ord.getPrice());
            ops.setInt(6, ord.getQuantity());
            ops.setString(7, ord.getFullName());
            ops.setString(8, ord.getAddress());

            ops.executeUpdate();

            f = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return f;
    }

    public int maxOrderID() {
        int qty = 0;
        try {
            String query = "select max(order_id) from orders";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);
            ResultSet rs = ops.executeQuery();
            while (rs.next()) {
                qty = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qty;
    }

    public List<Order> getOrderListByUserId(String uid) {
        List<Order> list = new ArrayList<Order>();
        try {
            String query = "select * from orders where u_id = ? order by order_date desc";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);
            ops.setString(1, uid);

            ResultSet rs = ops.executeQuery();
            while (rs.next()) {
                Order ord = new Order();
                ord.setOrderId(rs.getInt("order_id"));
                ord.setuId(rs.getString("u_id"));
                ord.setpId(rs.getString("p_id"));
                ord.setpName(rs.getString("p_name"));
                ord.setPrice(rs.getInt("price"));
                ord.setQuantity(rs.getInt("quantity"));
                ord.setFullName(rs.getString("full_name"));
                ord.setAddress(rs.getString("address"));
                ord.setStatus(rs.getString("status"));
                ord.setOrderDate(rs.getTimestamp("order_date"));

                list.add(ord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateStatus(String oid, String pid, String status) {

        try {
            String query = "update orders set status = ? where order_id = ? and p_id = ?  ";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);
            ops.setString(1, status);
            ops.setString(2, oid);
            ops.setString(3, pid);

            ops.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fetch Order Details to Admin Page
    public List<Order> getOrders() {
        List<Order> list = new ArrayList<Order>();
        try {
            String query = "select * from orders  order by order_date desc";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet rs = ops.executeQuery();
            while (rs.next()) {
                Order ord = new Order();
                ord.setOrderId(rs.getInt("order_id"));
                ord.setuId(rs.getString("u_id"));
                ord.setpId(rs.getString("p_id"));
                ord.setpName(rs.getString("p_name"));
                ord.setPrice(rs.getInt("price"));
                ord.setQuantity(rs.getInt("quantity"));
                ord.setFullName(rs.getString("full_name"));
                ord.setAddress(rs.getString("address"));
                ord.setStatus(rs.getString("status"));
                ord.setOrderDate(rs.getTimestamp("order_date"));

                list.add(ord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //Count Orders
    public int countOrders() {
        int count = 0;
        try {
            String query = "SELECT COUNT(*) AS od FROM orders ";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet set = ops.executeQuery();
            if (set.next()) {
                count = set.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
