/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroom.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author KS
 */
public class TestDatabase {
    public static void main(String[] args) throws SQLException {
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from Person");
        ResultSet rs = ps.executeQuery();
        rs.next();
        String a = rs.getString("user");
        System.out.println(a);
         
    }
}
