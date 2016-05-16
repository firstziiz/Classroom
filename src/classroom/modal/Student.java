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
import java.util.ArrayList;

/**
 *
 * @author KS
 */
public class Student extends Person {

    // Init Student for USE Function of Student Class
    public Student(String user) throws SQLException {
        super(user);
    }

    // [STATIC] Get All Student on Arraylist
    public static ArrayList<Student> getAllStudent() throws SQLException {
        Connection conn = ConnectionDB.getConnection();
        ArrayList<Student> listStd = new ArrayList<Student>();
        PreparedStatement ck = conn.prepareStatement("select * from Person where position='STUDENT'");
        ResultSet result = ck.executeQuery();
        while (result.next()) {
            listStd.add(new Student(result.getString("user")));
        }
        conn.close();
        return listStd;
    }
    
    public ArrayList<Work> showWork(String command) throws SQLException {
        Connection conn = ConnectionDB.getConnection();
        ArrayList<Work> listWork = new ArrayList<Work>();
        PreparedStatement ck;
        if (command == "all") {
            ck = conn.prepareStatement("select * from Work where std = ?");
        }else if (command == "sent"){
            ck = conn.prepareStatement("select * from Work where std = ? and status = 1");
        }else if (command == "unsent"){
            ck = conn.prepareStatement("select * from Work where std = ? and status = 0");
        }else{
            return null;
        }
        ck.setInt(1, id);
        ResultSet result = ck.executeQuery();
        while (result.next()) {
            listWork.add(new Work(result.getInt("id")));
        }
        conn.close();
        return listWork;
    }
    
    public void sentWork(String answer , int workid) throws SQLException{
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement("update Work SET status = 1 , answer = ? where id = ?");
        ps.setString(1, answer);
        ps.setInt(2, workid);
        ps.executeUpdate();
        conn.close();
    }
    
    public int getAllScore() throws SQLException{
        Connection conn = ConnectionDB.getConnection();
           int sum = 0;
           PreparedStatement ck;
           ck = conn.prepareStatement("select * from Work where std = ? and status = 2");
           ck.setInt(1, id);
           ResultSet result = ck.executeQuery();
           while (result.next()) {
               sum += new Work(result.getInt("id")).getScore();
           }
           conn.close();
           return sum;   
    }
    public int countWorkApprove() throws SQLException{
        Connection conn = ConnectionDB.getConnection();
           int count = 0;
           PreparedStatement ck;
           ck = conn.prepareStatement("select * from Work where std = ? and status = 2");
           ck.setInt(1, id);
           ResultSet result = ck.executeQuery();
           while (result.next()) {
               count++;
           }
           conn.close();
           return count;   
    }
    
}
