/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroom.modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import classroom.database.ConnectionDB;
import static classroom.modal.Student.createStudent;
import static classroom.modal.Teacher.createTeacher;

/**
 *
 * @author KS
 */
abstract public class Person {

    int id;
    String name;
    String user;
    String password;

    public Person(){
        
    }
    
    public static boolean checkPerson(String user, String password) throws SQLException {
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement("select username,password from Person where username=? and password=?");
        ps.setString(1, user);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
    
    public static int createPerson(String user, String password, String personName, String position) throws SQLException {
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement ck = conn.prepareStatement("select USERNAME"
                + " from Person where USERNAME=?");
        ck.setString(1, user);
        ResultSet ck_result = ck.executeQuery();
        
        if (!(ck_result.next())) 
        {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Person"
		+ "(USERNAME, PASSWORD, PERSONNAME) VALUES"
		+ "(?,?,?)");
            ps.setString(1, user);
            ps.setString(2, password);
            ps.setString(3, personName);
            if (position.equals("STUDENT")) {
                System.out.println("I'm Student");
                Student.createStudent(user);
            }else{
                System.out.println("I'm Teacher");
                Teacher.createTeacher(user);
            }
            return ps.executeUpdate();
        }
        
        return 0;
    }
    
    public static String checkPosition(String user) throws SQLException {
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement("select personUser from Student where personUser=?");
        ps.setString(1, user);
        ResultSet rs = ps.executeQuery();
        boolean check = rs.next();
        if (check) return "STUDENT";
        else       return "TEACHER";
    }
}
