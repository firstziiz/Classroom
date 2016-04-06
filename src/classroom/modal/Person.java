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

/**
 *
 * @author KS
 */
public class Person {

    int id;
    private String user;
    private String pass;
    private String name;
    private String position;

    // Init Person by USER form database
    public Person(String user) throws SQLException {
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from Person where user=?");
        ps.setString(1, user);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            this.id = rs.getInt("id");
            this.user = rs.getString("user");
            this.pass = rs.getString("pass");
            this.name = rs.getString("name");
            this.position = rs.getString("position");
        }
    }
    
    // [STATIC] Check A Person in a database, but has return 'true'
    public static boolean checkPerson(String user, String password) throws SQLException {
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement("select user,pass from Person where user=? and pass=?");
        ps.setString(1, user);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
    
    // [STATIC] Create Person .. [REGISTER]
    public static void createPerson(String user, String password, String personName, String position) throws SQLException {
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement ck = conn.prepareStatement("select user from Person where user=?");
        ck.setString(1, user);
        ResultSet ck_result = ck.executeQuery();

        if (!(ck_result.next())) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Person"
                    + "(user, pass, name, position) VALUES"
                    + "(?,?,?,?)");
            ps.setString(1, user);
            ps.setString(2, password);
            ps.setString(3, personName);
            ps.setString(4, position);
            ps.executeUpdate();
        }        
    }
    
    // Check Position of A Person
    public String checkPosition() throws SQLException{
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from Person where user=?");
        ps.setString(1, user);
        ResultSet result = ps.executeQuery();
        result.next();
        return result.getString("position");
	
	
    }
    // GET and SET
    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
//    # use : update statement
//    
//    public void set(String col, String res){
//      "update 'col' from Person value (res) where user='this.user'"
//        }
//    
//    public void setPass(String pass) {
//        this.pass = pass;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setPosition(String position) {
//        this.position = position;
//    }
    
    // toString
    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", user=" + user + ", pass=" + pass + ", name=" + name + ", position=" + position + '}';
    }

    public void showWork() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
