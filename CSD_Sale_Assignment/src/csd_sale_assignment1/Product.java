/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd_sale_assignment1;

 /*
 * @author ASUS ROG
 */
public class Product {
    private String pCode;
    private String pro_name;
    private int quantity;
    private int saled;
    private double price;

    public Product() {
    }

    public Product(String pCode, String pro_name, int quantity, int saled, double price) {
        this.pCode = pCode;
        this.pro_name = pro_name;
        this.quantity = quantity;
        this.saled = saled;
        this.price = price;
    }

    public String getPcode() {
        return pCode;
    }

    public void setPcode(String pCode) {
        this.pCode = pCode;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSaled() {
        return saled;
    }

    public void setSaled(int saled) {
        this.saled = saled;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getValue(){
         return price * saled ; 
} 
    public String toString() {
        return String.format("%-5s | %-15s | %-8d | %-6d | %-6.1f | %-6.1f", pCode, pro_name, quantity, saled, price, getValue()); //To change body of generated methods, choose Tools | Templates.
    }
    
}
