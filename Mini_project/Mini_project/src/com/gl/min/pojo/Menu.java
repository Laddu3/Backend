package com.gl.min.pojo;
import java.util.Scanner;
public class Menu {
    public double subTotal;
    public static double runningTotal;
    private static double itemPrice;
    static boolean ordering = true;
    static Scanner input = new Scanner(System.in);
    {
    	System.out.println("**********   Welcome to Surabi Resturant   **********");
        System.out.println("Menu \n1. Burger (100.00) \n2. pizza (250.00)\n3. beverage (300.00) \n4. Biriyani(350.00) \n5.Done");
    
    }
    public static double itemPrice(int foodItem)
    {
        if (foodItem == 1) {
            System.out.println("You've ordered a burger");
            itemPrice = 100.00;
        }
        if (foodItem == 2) {
            System.out.println("You've ordered pizza");
            itemPrice = 250.00;
        }
        if (foodItem == 3) {
            System.out.println("You've ordered a beverage");
            itemPrice = 300.00;
        }
        if(foodItem==4) {
        	System.out.println("You've ordered a biriyani");
        	itemPrice =350.00;
        }
        quantity();
        return itemPrice;
    }
    public static double quantity() {
        System.out.println("Enter quantity");
        double quantity = input.nextDouble();
        subTotal(quantity, itemPrice);
        return quantity;
    }

    public static double subTotal(double quantity, double itemPrice) {
        double subTotal = quantity * itemPrice;
        System.out.println("Subtotal: " + subTotal);
        return subTotal;
    }

    public static void done(double runningTotal) {
        ordering = false;
        System.out.println(runningTotal);
        System.out.println("Enjoy your meal");
    }

    public static void menu()
    {
      Menu menu=new Menu();
        int menuOption;
        int foodItem = 0;
        input = new Scanner(System.in);
        do {
            double runningTotal = 0;
            menuOption = input.nextInt();
            switch (menuOption) {
            case 1:
                foodItem = 1;
                itemPrice(foodItem);
                break;
            case 2:
                foodItem = 2;
                itemPrice(foodItem);
                break;
            case 3:
                foodItem = 3;
                itemPrice(foodItem);
                break;
            case 4:
            	foodItem =4;
            	itemPrice(foodItem);
            	break;
            case 5:
                done(runningTotal);
                break;
            default:
                System.out.println("Invalid option.");
            }
        }
        while (ordering);
        {
            subTotal(quantity(), itemPrice(foodItem));
            runningTotal = runningTotal + subTotal(quantity(), itemPrice(foodItem));
            
        }
    }
}