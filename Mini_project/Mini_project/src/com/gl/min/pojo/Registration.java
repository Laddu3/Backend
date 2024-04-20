package com.gl.min.pojo;

import java.util.Scanner;

public class Registration 
{

    static Register register = new Register();
    static Login User=new Login();

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) 
        {
            System.out.print(" Enter firstName => ");
            String firstName = scanner.nextLine();
            register.setFirstName(firstName);

            System.out.print(" Enter lastName => ");
            String lastName = scanner.nextLine();
            register.setLastName(lastName);

            System.out.print(" Enter userName => ");
            String userName = scanner.nextLine();
            register.setUserName(userName);

            System.out.print(" Enter password => ");
            String password = scanner.nextLine();
            register.setPassword(password);

            System.out.print(" Enter emailId => ");
            String emailId = scanner.nextLine();
            register.setEmailId(emailId);

            System.out.print(" Enter phoneNo => ");
            long phoneNo = scanner.nextLong();
            register.setPhoneNo(phoneNo);

            System.out.println(register.toString());
        }
    }
}