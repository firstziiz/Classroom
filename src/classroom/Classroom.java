/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroom;

import classroom.modal.*;
import java.sql.SQLException;
import java.util.*;
/**
 *
 * @author KS
 */
public class Classroom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        // Setting .
        Scanner sc = new Scanner(System.in);
        
        // Variable
        int check = 0;
        String username = "";
        String password;
        String name;
        int pos = 0;
        String position;
        Person User = null;
        // Login
        do{
        System.out.println(":: CLASSROOM ::");
        System.out.println("Press 1 : Login");
        System.out.println("Press 2 : Register");
        do {
            try {
                System.out.print("Enter : ");
                check = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("-------- Invalid Input");
                System.out.println("----------------------");
                sc.next();
            }
        } while (check != 1 && check != 2);
        
        // Create User
        if (check == 2) {
            System.out.println("- Create New User -");
            System.out.print("Username : ");
            username = sc.next();
            System.out.print("Password: ");
            password = sc.next();
            System.out.print("Person Name: ");
            name = sc.next();
            // position
            System.out.println("Choose Your Position");
            System.out.println("Press 1 : Student");
            System.out.println("Press 2 : Teacher");
            do {
                try {
                    System.out.print("Enter : ");
                    pos = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("-------- Invalid Input");
                    System.out.println("----------------------");
                    sc.next();
                }
            } while (check != 1 && check != 2);
            
            if (pos == 1) position = "STUDENT";
            else position = "TEACHER";
            
            try {
                Person.createPerson(username, password, name, position);
                System.out.println("------ Create Complete");
                System.out.println("----------------------");
            } catch (Exception e) {
                System.out.println("---------------- Error");
                System.out.println("----------------------");
            }
                    
        } // Login User 
        else if (check == 1) {
            do {
                System.out.print("Username: ");
                username = sc.next();
                System.out.print("Password: ");
                password = sc.next();
                if ( !Person.checkPerson(username, password)) {
                    System.out.println("-------- invalid login");
                    System.out.println("----------------------");
                }
                } while (!Person.checkPerson(username, password));
            }
        } while (check != 1); // Person Login Success.
        
        System.out.println("----------------------");
        System.out.println("--- Login  Success ---");
        System.out.println("----------------------");
        
        position = Person.checkPosition(username);
                
        if (position == "STUDENT") {
            // Student Zone
            System.out.println("I'm Student naja");
            // User = new Student(username);
            
            
        }
        else if ( position == "TEACHER") {
            // Teacher Zone
            System.out.println("I'm Teacher naja");
            // User = new Teacher(username);
            
        }
        
    }
    
}
