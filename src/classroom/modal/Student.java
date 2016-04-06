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

        return listStd;
    }
    
    public ArrayList<Work> showWork() throws SQLException {
        Connection conn = ConnectionDB.getConnection();
        ArrayList<Work> listWork = new ArrayList<Work>();
        PreparedStatement ck = conn.prepareStatement("select * from Work where std = ?");
        ck.setInt(1, id);
        ResultSet result = ck.executeQuery();
        while (result.next()) {
            listWork.add(new Work(result.getInt("id")));
        }
        return listWork;
    }
    
    public void sentWork(String answer , int workid) throws SQLException{
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement("update Work SET status = 1 , answer = ? where id = ?");
        ps.setString(1, answer);
        ps.setInt(2, workid);
        ps.executeUpdate();
    }
}
