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
    
    // ########################
    //     # TESTING AREA #
    // ########################
    public static void main(String[] args) throws SQLException {

        Student sd = new Student("student");
        
        ArrayList<Work> list = sd.showWork("unsent");

        for (Work work : list) {
            System.out.println(work);
        }

    }
}
