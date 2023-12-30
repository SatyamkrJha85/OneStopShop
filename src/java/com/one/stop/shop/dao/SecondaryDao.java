package com.one.stop.shop.dao;

import com.one.stop.shop.entities.Complaint;
import com.one.stop.shop.entities.Feedback;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OraclePreparedStatement;

public class SecondaryDao {

    private OracleConnection oconn;
    private OraclePreparedStatement ops;

//    Constructor
    public SecondaryDao(OracleConnection oconn) {
        this.oconn = oconn;
    }

    public int maxContactID() {
        int qty = 0;
        try {
            String query = "select max(c_id) from contactus";
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

    //    Method to insert Contactus to database:
    public boolean saveContactus(int id, String fname, String lname, String email, String phone, String subject) {
        boolean f = false;
        try {
            //user ---> database
            String query = "INSERT INTO contactus(c_id,u_fname,u_lname,u_email, u_phone, u_subject) VALUES (?,?,?,?,?,?)";

            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ops.setInt(1, id);
            ops.setString(2, fname);
            ops.setString(3, lname);
            ops.setString(4, email);
            ops.setString(5, phone);
            ops.setString(6, subject);

            ops.executeUpdate();

            f = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return f;
    }

    public int maxFeedbackID() {
        int qty = 0;
        try {
            String query = "select max(f_id) from feedback";
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

    //    Method to Feedback insert to database:
    public boolean saveFeedback(int id, String email, String subject) {
        boolean f = false;
        try {
            //user ---> database
            String query = "INSERT INTO feedback(f_id,u_email,u_subject) VALUES (?,?, ?)";

            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ops.setInt(1, id);
            ops.setString(2, email);
            ops.setString(3, subject);

            ops.executeUpdate();

            f = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return f;
    }

    public int maxComplaintID() {
        int qty = 0;
        try {
            String query = "select max(c_id) from complaint";
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

    //    Method to insert Complaint to database:
    public boolean saveComplaint(int id,String fname, String lname, String email, String phone, String reason, String subject) {
        boolean f = false;
        try {
            //user ---> database
            String query = "INSERT INTO complaint(c_id,u_fname,u_lname,u_email, u_phone,u_reason, u_subject) VALUES (?,?, ?, ? ,?, ?, ?)";

            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ops.setInt(1, id);
            ops.setString(2, fname);
            ops.setString(3, lname);
            ops.setString(4, email);
            ops.setString(5, phone);
            ops.setString(6, reason);
            ops.setString(7, subject);

            ops.executeUpdate();

            f = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return f;
    }

    //  Method to Fetch Complaint Data to table
    public List<Complaint> getComplaints() {
        List<Complaint> complaints = new ArrayList<>();

        try {
            String query = "SELECT * FROM complaint";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet set = ops.executeQuery();

            while (set.next()) {
                Complaint complaint = new Complaint();

                complaint.setfName(set.getString("u_fname"));
                complaint.setlName(set.getString("u_lname"));
                complaint.setEmail(set.getString("u_email"));
                complaint.setPhone(set.getString("u_phone"));
                complaint.setReason(set.getString("u_reason"));
                complaint.setSubject(set.getString("u_subject"));

                complaints.add(complaint);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return complaints;
    }

// Method To Fetch Feedback to Tabel
    public List<Feedback> getFeedback() {
        List<Feedback> feedbacks = new ArrayList<>();

        try {
            String query = "SELECT * FROM feedback";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet set = ops.executeQuery();

            while (set.next()) {
                Feedback feedback = new Feedback();

                feedback.setEmail(set.getString("u_email"));
                feedback.setSubject(set.getString("u_subject"));

                feedbacks.add(feedback);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return feedbacks;
    }

}
