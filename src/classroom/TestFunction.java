/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroom;

import classroom.modal.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author KS
 */
public class TestFunction {
    public static void main(String[] args) throws SQLException {
    
        Teacher User = new Teacher("teacher");
        
        System.out.println(User);
        
        String a = User.createWork("[INT105] REPORT 1 ", " Lorem Ipsum .... ", User);
        System.out.println("a is : " + a);
        
        ArrayList<Teacher> list = Teacher.getAllTeacher();
        
    }
}