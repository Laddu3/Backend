package com.gl.min.pojo;
import java.sql.SQLException;
import java.util.Scanner;
public class Login 
{
    public int loginPage() throws ClassNotFoundException, SQLException 
    {
    	UserDAO userdao = new UserDAO();
        Scanner scanner = new Scanner(System.in); 
        
            System.out.print(" Enter email => ");
            String userName = scanner.nextLine();
            System.out.print(" Enter password => ");
            String password = scanner.nextLine();
            User userObject = userdao.checkLogin(userName, password);
            if(userObject == null) {
            	
            	
            }
            else {
            if (userObject.getEmail().equals(userName) && userObject.getPassword().equals(password)) 
            {
                System.out.println(" User successfully logged-in.. ");
                return 1;
            } 
            else 
            {
                System.out.println(" In valid userName of password ");
                return -1;
            }
            }
			return 0;
        
    }
}