package com.gl.min.pojo;
import java.sql.SQLException;
public class Main
{
    public static void main(String args[]) throws ClassNotFoundException, SQLException
    {
        Login login = new Login();
        if(login.loginPage() ==1)
        {
            Menu.menu();
        }
        else
        {
            System.out.println("Invalid details");
        }
    }



}