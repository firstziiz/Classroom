/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroom.modal;

import classroom.database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author KS
 */
public class Student extends Person{
    int stuid;
    
    public static int createStudent(String user) throws SQLException {
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Student"
		+ "(PERSONUSER) VALUES"
		+ "(?)");
        ps.setString(1, user);
        return ps.executeUpdate();
    }
    
}
