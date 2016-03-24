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
    public String createWork(String name, String description, Teacher tch) throws SQLException {
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement ck = conn.prepareStatement("select name"
                + " from Work where name=?");
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Work"
                + "(name, description, status, point, tch ,std) VALUES"
                + "(?,?,?,?,?,?)");
        ck.setString(1, name);
        ResultSet ck_result = ck.executeQuery();

        if (!(ck_result.next())) {
            ArrayList<Student> list = Student.getAllStudent();
            for (Student std : list) {
                System.out.println(std);
                ps.setString(1, name);
                ps.setString(2, description);
                ps.setInt(3, 0);
                ps.setInt(4, 0);
                ps.setInt(5, this.getId());
                ps.setInt(6, std.id);
                ps.executeUpdate();
            }
            return " Create work : Complete";
        }

        return " Create work : False";
    }
}
