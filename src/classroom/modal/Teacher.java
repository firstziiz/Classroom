/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroom.modal;

import classroom.database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author KS
 */
public class Teacher extends Person {

    // Init Teacher for USE Function of Teacher Class
    public Teacher(String user) throws SQLException {
        super(user);
    }

    // CREATE WORKS for All Student in the Database.
    // note : Works must assign to all of student.
    public String createWork(String name, String description) throws SQLException {
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement ck = conn.prepareStatement("select name"
                + " from Work where name=?");
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Work"
                + "(name, description, status, answer, score, tch ,std) VALUES"
                + "(?,?,?,?,?,?,?)");
        ck.setString(1, name);
        ResultSet ck_result = ck.executeQuery();
        if (!(ck_result.next())) {
            ArrayList<Student> list = Student.getAllStudent();
            for (Student std : list) {
                System.out.println(std);
                ps.setString(1, name);
                ps.setString(2, description);
                ps.setInt(3, 0);
                ps.setString(4, "");
                ps.setInt(5, 0);
                ps.setInt(6, this.getId());
                ps.setInt(7, std.id);
                ps.executeUpdate();
            }
            conn.close();
            return " Create work : Complete";
        }
        conn.close();
        return " Create work : False";
    }

    public void approveWork(int score,int workid) throws SQLException {
        Connection tcud = ConnectionDB.getConnection();
        PreparedStatement pps = tcud.prepareStatement("UPDATE Work SET status = 2, score = ?  WHERE id =?");
        pps.setInt(1, score);
        pps.setInt(2, workid);
        pps.executeUpdate();
        tcud.close();
        
    }
    
    public ArrayList<Work> showWork(String command) throws SQLException{
        Connection tcud = ConnectionDB.getConnection();
        ArrayList<Work> listWork = new ArrayList<Work>();
        PreparedStatement pps;
        if(command.equals("all")){
            pps = tcud.prepareStatement("select * from Work where tch =?");
        }else if (command.equals("sent")){
            pps = tcud.prepareStatement("select * from Work where tch =? and status = 1");
        }else{
            return null;
        }
        pps.setInt(1, id);
        ResultSet result = pps.executeQuery();
        while (result.next()){
            listWork.add(new Work(result.getInt("id")));
        }
        tcud.close();
        return listWork;
        
    }
    
    public void removeWork(String name) throws SQLException {
        Connection tcud = ConnectionDB.getConnection();
        PreparedStatement pps = tcud.prepareStatement("delete from Work where tch =? and name = ?");
        pps.setInt(1, this.getId());
        pps.setString(2, name);
        pps.executeUpdate();
        tcud.close();
    }
    
}
