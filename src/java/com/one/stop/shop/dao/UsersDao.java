
package com.one.stop.shop.dao;

import com.one.stop.shop.entities.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OraclePreparedStatement;

public class UsersDao {

    private OracleConnection oconn;
    private OraclePreparedStatement ops;

//    Constructor
    public UsersDao(OracleConnection oconn) {
        this.oconn = oconn;
    }

//    Method to insert to database:
    public boolean saveUser(Users user) {
        boolean f = false;
        try {
            //user ---> database
            String query = "Insert into users(u_name,u_email,u_pass,reg_time,nickname) values(?,?,?,CURRENT_DATE,?)";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ops.setString(1, user.getuName());
            ops.setString(2, user.getuEmail());
            ops.setString(3, user.getuPass());
            ops.setString(4, user.getNickname());

            ops.executeUpdate();

            f = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return f;
    }

//     Update users table
    public boolean updatePassword(String email, String newPass) {
        boolean f = false;
        try {
            //user ---> database
            String query = "UPDATE users SET u_pass = ? WHERE u_email=?";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ops.setString(1, newPass);
            ops.setString(2, email);

            int set = ops.executeUpdate();

            if (set > 0) {
                f = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return f;
    }

//    Check email present in the database or not
    public boolean checkEmail(String email) {
        boolean f = false;
        try {
            //user ---> database
            String query = "SELECT  * FROM users WHERE u_email = ?";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ops.setString(1, email);

            ResultSet set = ops.executeQuery();

            if (set.next()) {
                f = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return f;
    }

//    Update profile data
    public boolean updateUser(Users user) {

        boolean f = false;
        try {
            String query = "UPDATE users SET u_name=?, u_address = ?, u_gender = ?, u_mobile = ?, u_profile_image=? WHERE u_email = ?";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ops.setString(1, user.getuName());
            ops.setString(2, user.getuAddress());
            ops.setString(3, user.getuGender());
            ops.setString(4, user.getuMobile());
            ops.setString(5, user.getuProfile());
            ops.setString(6, user.getuEmail());

            ops.executeUpdate();
            f = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return f;
    }

    public boolean checkImage(String img) {
        boolean f = true;
        try {
            String query = "SELECT COUNT(u_profile_image) FROM users WHERE u_profile_image= ?";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ops.setString(1, img);

            ResultSet set = ops.executeQuery();

            if (set.next()) {
                int count = set.getInt(1); 
                if (count > 1) {
                    return false;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return f;
    }

//    Fetch all data from users table
    public List<Users> getUsers() {
        List<Users> users = new ArrayList<Users>();
        try {
            String query = "SELECT * FROM users ORDER BY reg_time DESC";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet set = ops.executeQuery();

            while (set.next()) {
                Users row = new Users();

                row.setuName(set.getString("u_name"));
                row.setuEmail(set.getString("u_email"));
                row.setuAddress(set.getString("u_address"));
                row.setuGender(set.getString("u_gender"));
                row.setuMobile(set.getString("u_mobile"));
                row.setuRegTime(set.getTimestamp("reg_time"));
                users.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

//    Get total Registered users
    public int countUsers() {

        try {
            String query = "SELECT COUNT(*) AS total FROM users";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet set = ops.executeQuery();

            if (set.next()) {
                int tot = set.getInt("total");
                return tot;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public Users getUser(String email) {
        Users user = new Users();
        try {
            String query = "SELECT * FROM users WHERE u_email = ?";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);
            ops.setString(1, email);
            ResultSet set = ops.executeQuery();

            if(set.next()) {

                user.setuName(set.getString("u_name"));
                user.setuEmail(set.getString("u_email"));
                user.setuAddress(set.getString("u_address"));
                user.setuGender(set.getString("u_gender"));
                user.setuMobile(set.getString("u_mobile"));
                user.setuRegTime(set.getTimestamp("reg_time"));
                user.setNickname(set.getString("nickname"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
