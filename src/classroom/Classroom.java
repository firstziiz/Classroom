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
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {

        // Setting .
        Scanner sc = new Scanner(System.in);
        boolean login = false;
        do {
            // ! Run Program !
            // Init Variable
            int check = 0;
            String user = "";
            String pass;
            String name;
            int pos = 0;
            String position;
            Person User = null;

            // Starter Board
            do {
                System.out.println("# CLASSROOM #");
                System.out.println("Press 1 - Login");
                System.out.println("Press 2 - Register");
                System.out.println("Press 3 - Exit");
                do {
                    try {
                        System.out.print("Enter : ");
                        check = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("> Invalid Input");
                        sc.next();
                    }
                } while (check <= 1 && check >= 3);
                // 3 : Exit Program
                if (check == 3) {
                    System.out.println("Close Program.");
                    System.exit(0);
                }

                // 2 : Create User
                if (check == 2) {
                    System.out.println("- Create New User -");
                    System.out.print("Username : ");
                    user = sc.next();
                    System.out.print("Password: ");
                    pass = sc.next();
                    System.out.print("Person Name: ");
                    name = sc.next();
                    // position
                    System.out.println("Choose Your Position");
                    System.out.println("Press 1 - Student");
                    System.out.println("Press 2 - Teacher");
                    do {
                        try {
                            System.out.print("Enter : ");
                            pos = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("> Invalid Input");
                            sc.next();
                        }
                    } while (check != 1 && check != 2);

                    if (pos == 1) {
                        position = "STUDENT";
                    } else {
                        position = "TEACHER";
                    }

                    try {
                        Person.createPerson(user, pass, name, position);
                        System.out.println("> Create Complete");
                    } catch (Exception e) {
                        System.out.println("> Error : " + e.getMessage());
                    }

                }
                // 1 : Login
                else if (check == 1) {
                    do {
                        System.out.println("# Login");
                        System.out.print("USER : ");
                        user = sc.next();
                        System.out.print("PASS : ");
                        pass = sc.next();

                        if (Person.checkPerson(user, pass)) {
                            System.out.println("> Login Success\n");
                            check = 2;
                        } else {
                            System.out.println("> Invalid Username/Password");
                        }

                    } while (!Person.checkPerson(user, pass));
                }
            } while (check != 2); // Person Login Success.

            login = true; // Person has Login.
            
            User = new Person(user);
            
            if (User.checkPosition().equals("TEACHER")) {
                // Teacher Access
                Teacher tch = new Teacher(user);
                do {
                    System.out.println(" -------------------");
                    System.out.println("# TEACHER DASHBOARD #");
                    System.out.println("Hi, " + User.getName());
                    System.out.println("Press 1 - Show  Works");
                    System.out.println("Press 2 - Check Works");
                    System.out.println("Press 3 - Analytics Board");
                    System.out.println("Press 4 - Logout");
                    do {
                        try {
                            System.out.print("Enter : ");
                            check = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("> Invalid Input");
                            sc.next();
                        }
                    } while (check <= 1 && check >= 4);
                    // 1 : Show Works
                    if (check == 1) {
                        ArrayList<Work> list = tch.showWork();
                        System.out.println("------- my work -------");
                        for (Work w : list) {
                            System.out.println(w);
                        }
                        System.out.println("-----------------------");
                    }
                    // 2 : Check Works
                    else if (check == 2) {
                        System.out.println(" -- I'm in 'Check Works [Function]'");
                        System.out.println(" -- wait for develop\n");
                    }
                    // 3 : Analyrics Board
                    else if (check == 3) {
                        System.out.println(" -- I'm in 'Create Work [Function]'");
                        System.out.println(" -- wait for develop\n");
                    }
                    // 4 : logout
                    else {
                        System.out.println("Bye.\n");
                        login = false;
                        break; // out a infinity loop [ while(true); ]
                    }
                } while (true);
            } else {
                // Student Access
                Student std = new Student(user);
                do {
                    System.out.println(" -------------------");
                    System.out.println("# Student DASHBOARD #");
                    System.out.println("Hi, " + User.getName());
                    System.out.println("Press 1 : Show Works");
                    System.out.println("Press 2 : Sent Works");
                    System.out.println("Press 3 : Logout");
                    do {
                        try {
                            System.out.print("Enter : ");
                            check = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("> Invalid Input");
                            sc.next();
                        }
                    } while (check <= 1 && check >= 3);
                    // 1 : Show Works
                    if (check == 1) {
                        ArrayList<Work> list = std.showWork("all");
                        System.out.println("------- My Work -------");
                        for (Work w : list) {
                            System.out.println(w);
                        }
                        System.out.println("-----------------------");
                    }
                    // 2 : Sent Works
                    else if (check == 2) {
                        ArrayList<Work> list = std.showWork("unsent");
                        if (list.size() > 0) {
                            System.out.println("------- Sent Work -------");
                            int i = 1;
                            for (Work w : list) {
                                System.out.println(i +") " +w);
                                i++;
                            }
                            System.out.print("------- Select ID of Work : ");
                            int select = sc.nextInt();
                            System.out.println("--- Typing Answer ---");
                            String answer = sc.next();
                            std.sentWork(answer , list.get(select-1).getId());
                            System.out.println("Sent Complete ~");
                        }else{
                            System.out.println("You already send you work."); // check sentense.
                        }
                    }
                    // 3 : logout
                    else {
                        System.out.println("Bye.\n");
                        login = false;
                        break; // out a infinity loop [ while(true); ]
                    }
                } while (true);
            }
        } while (login != true);

        // Classroom by First , Fluke , Stamp !
    }
}
