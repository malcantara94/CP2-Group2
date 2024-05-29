package MotorPH;

import java.util.Scanner;

public class Login {
    

    public void checkCredentials() {
    
    String userID;
    String employeePass;
    boolean isPasswordCorrect = false;
    
    userID = "1";
    employeePass = "123";

    Scanner input1 = new Scanner(System.in);
    System.out.println("Enter Username : ");
    String username = input1.next();

    Scanner input2 = new Scanner(System.in);
    System.out.println("Enter Password : ");
    String password = input2.next();

    if (username.equals(userID) && password.equals(employeePass)) {

        System.out.println("Access Granted! Welcome!");
        isPasswordCorrect = true;
    }

    else if (username.equals(userID)) {
        System.out.println("Invalid Password!");
    } else if (password.equals(employeePass)) {
        System.out.println("Invalid Username!");
    } else {
        System.out.println("Invalid Username & Password!");
    }

//asdfasdfasdfasdf

//asdfadsf
}


}

