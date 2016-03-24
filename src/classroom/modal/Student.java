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
public class Student extends Person{
    
    public Student(String user) throws SQLException {
        super(user);
    }
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
}
