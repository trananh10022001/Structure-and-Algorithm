/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd_sale_assignment1;

import java.util.Scanner;

/**
 *
 * @author ASUS ROG
 */
public class CheckInputData {
    public static String getProduct(String s) {
        Scanner sc = new Scanner(System.in);
        String text;
        System.out.println(s);
        do {
            text = sc.nextLine();
            if (text.trim().isEmpty()) {
                System.err.println("Invalid input! Please reeter: ");
            } else {
                return text;
            }
        } while (true);
    }

    public static int getQuantityProduct() {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("Enter the product's quantity: ");
        while (true) {
            try {
                num = Integer.parseInt(sc.nextLine());
                if (num < 0) {
                    System.err.println("Please enter a digit greater or equal than 0!");
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter a digit greater or euqal than 0!");
            }
        }

    }

    public static int getSaledProduct(int quantity) {
       Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("Enter the quantity saled product: ");
        while (true) {
            try {
                num = Integer.parseInt(sc.nextLine());
               if (num < 0 || num > quantity) {
                    System.err.println("Please enter a digit greater or equal than 0"
                            + " and less or equal than " + quantity + "!");
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter a digit greater or euqal than 0!");
            }
        }

    }

    public static double getPriceProduct() {
        Scanner sc = new Scanner(System.in);
        double x;
        System.out.println("Enter the product's price: ");
        while (true) {
            try {
                x = Double.parseDouble(sc.nextLine());
                if (x < 0) {
                    System.err.println("Please enter a digit greater or equal than 0!");
                } else {
                    return x;
                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter a digit greater or equal than 0!");
            }
        }
    }

    public static int getOption(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int option;
        System.out.println(msg);
        do {
            try {
                option = Integer.parseInt(sc.nextLine());
                if (option < min || option > max) {
                    System.err.println("Please enter a number greater or equal than " + min + " and less or equal than " + max+"!");
                } else {
                    return option;
                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter a number greater or equal than " + min + " and less or equal than " + max+"!");
            }
        } while (true);
    }

    public static int getInt(String msg) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println(msg);
        do {
            try {
                num = Integer.parseInt(sc.nextLine());
                if (num < 0) {
                    System.err.println("Please enter a positive number: ");
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter a positive number: ");
            }
        } while (true);
    }

    public static int getPhone() {
        Scanner sc = new Scanner(System.in);
        int phone;
        do {
            try {
                System.out.println("Enter the customer's phone: ");
                phone = Integer.parseInt(sc.nextLine());
                if (phone < 1000 || phone > 9999) {
                    System.err.println("Invalid input! Please re-enter: ");
                } else {
                    return phone;
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input! Please re-enter: ");
            }
        } while (true);
    }
}
