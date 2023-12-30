
package com.one.stop.shop.dao;

import com.one.stop.shop.entities.Login;
import com.one.stop.shop.entities.Users;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OraclePreparedStatement;

public class LoginDao {

    private OracleConnection oconn;
    private OraclePreparedStatement ops;

//    Constructor
    public LoginDao(OracleConnection oconn) {
        this.oconn = oconn;
    }

//    get user by useremail and userpassword
    public Users getUserByEmailAndPassword(String email, String password) {
        Users user = null;

        try {
            String query = "SELECT * FROM users where u_email=? and u_pass=?";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ops.setString(1, email);
            ops.setString(2, password);

            ResultSet set = ops.executeQuery();

            if (set.next()) {
                user = new Users();

//                data from db
                String name = set.getString("u_name");

//                set to user object
                user.setuName(set.getString("u_name"));
                user.setuEmail(set.getString("u_email"));
                user.setuPass(set.getString("u_pass"));
                user.setuGender(set.getString("u_gender"));
                user.setuAddress(set.getString("u_address"));
                user.setuMobile(set.getString("u_mobile"));
                user.setuRegTime(set.getTimestamp("reg_time"));
                user.setuProfile(set.getString("u_profile_image"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

//    Logged User details
    public Users logUser(String email, String password) {
        Users user = null;

        try {
//            Inserting login details into the database
            String query = "INSERT INTO login(u_email,u_pass,log_time) values(?,?,CURRENT_DATE)";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ops.setString(1, email);
            ops.setString(2, password);

            ops.executeUpdate();

//            Fetching login details from the database
            query = "SELECT * FROM login";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet set = ops.executeQuery();

            if (set.next()) {
                user = new Users();

//                set to user object
                user.setuEmail(set.getString("u_email"));
                user.setuPass(set.getString("u_pass"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

//    Fetch data from Login table
        public List<Login> getLogin() {
        List<Login> log = new ArrayList<Login>();
        try {
            String query = "SELECT * FROM login ORDER BY log_time DESC";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet set = ops.executeQuery();

            while (set.next()) {
                Login row = new Login();

                row.setuEmail(set.getString("u_email"));
                row.setuLogTime(set.getTimestamp("log_time"));
                log.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return log;
    }
        
        
}
