/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd_sale_assignment1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ASUS ROG
 */
public class Main {

    static void readFile(String fname) {
        try {
            FileReader fr = new FileReader(fname + ".txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Function_Of_Product h = new Function_Of_Product();
        Function_Of_Customer c = new Function_Of_Customer();
        boolean products, t;
        int option, optionMini, pos;
        String fname = "", codeSearched;
        h.addProduct();
        c.addCustomer();
        while (true) {
            option = CheckInputData.getOption("Please enter 1:operate product , 2 : operate with Customers and 3 : operate saling: ", 1, 3);
            switch (option) {
                case 1:
                    products = true;
                    System.out.println("PRODUCT LIST");
                    System.out.println("1.1  Load data from file");
                    System.out.println("1.2  Input and add to the end");
                    System.out.println("1.3  Display data");
                    System.out.println("1.4  Save product list to file");
                    System.out.println("1.5  Search by pcode");
                    System.out.println("1.6  Delete by pcode");
                    System.out.println("1.7  Sort by pcode");
                    System.out.println("1.8  Add after position k");
                    System.out.println("1.9  Delete the node after the node having code = xCode");
                    System.out.println("1.10 Exit");
                    while (products) {
                        optionMini = CheckInputData.getOption("Enter your choice (1 -> 10): ", 1, 10);
                        switch (optionMini) {
                            case 1:
                                fname = CheckInputData.getProduct("Please enter the file's name: ");
                                h.writeFileProduct(fname);
                                System.out.println("Load completed!");
                                break;
                            case 2:
                                h.inputAndAddEnd();
                                break;
                            case 3:
                                fname = CheckInputData.getProduct("Enter the file you want to read: ");
                                System.out.println("Read file " + fname);
                                readFile(fname);
                                break;
                            case 4:
                                fname = CheckInputData.getProduct("Enter the saved file's name: ");
                                h.writeFileProduct(fname);
                                System.out.println("Save completed!");
                                break;
                            case 5:
                                codeSearched = CheckInputData.getProduct("Enter the code of product you want to search: ");
                                h.searchByPCode(codeSearched);
                                break;
                            case 6:
                                codeSearched = CheckInputData.getProduct("Enter the code of product you want to delete: ");
                                h.deleteByPCode(codeSearched);
                                break;
                            case 7:
                                h.sortByPCode();
                                System.out.println("Sort completed!");
                                break;
                            case 8:
                                pos = CheckInputData.getInt("Enter the position you want to add after: ");
                                h.addAfterPosition(pos);
                                break;
                            case 9:
                                codeSearched = CheckInputData.getProduct("Enter the code of product you want to delete the next element of it : ");
                                h.deleteNextNodeByPCode(codeSearched);
                                break;
                            case 10:
                                System.out.println("Exit");
                                products = false;
                                break;
                        }
                    }
                    break;
                case 2:
                    products = true;
                    System.out.println("CUSTOMER LISTS");
                    System.out.println("2.1  Load data from file");
                    System.out.println("2.2  Input and add to the end");
                    System.out.println("2.3  Display data");
                    System.out.println("2.4  Save customer list to file");
                    System.out.println("2.5  Search by ccode");
                    System.out.println("2.6  Delete by ccode");
                    System.out.println("2.7  Exit!");
                    optionMini = CheckInputData.getOption("Enter 1 to load data,"
                            + " 2 to input and add data to the end, 3 to display,"
                            + " 4 to save data, 5 to search, 6 to delete and 7 to exit", 1, 7);
                    switch (optionMini) {
                        case 1:
                            fname = CheckInputData.getProduct("Please enter the file's name: ");
                            c.writeFileCustomer(fname);
                            System.out.println("Load completed!");
                            break;
                        case 2:
                            c.inputAndAddEndCustomer();
                            break;
                        case 3:
                            fname = CheckInputData.getProduct("Enter the file you want to read: ");
                            System.out.println("Read file " + fname);
                            readFile(fname);
                            break;
                        case 4:
                            fname = CheckInputData.getProduct("Enter the saved file's name: ");
                            c.writeFileCustomer(fname);
                            System.out.println("Save completed!");
                            break;
                        case 5:
                            codeSearched = CheckInputData.getProduct("Enter the customer's code you want to search: ");
                            c.searchByCCode(codeSearched);
                            break;
                        case 6:
                            codeSearched = CheckInputData.getProduct("Enter the customer's code you want to delete: ");
                            c.deleteByCCode(codeSearched);
                            break;
                        case 7:
                            products = false;
                            break;
                    }
                    break;
                case 3:
                    break;

            }
        }
    }
}
