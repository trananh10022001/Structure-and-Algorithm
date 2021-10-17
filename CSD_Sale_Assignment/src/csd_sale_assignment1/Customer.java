/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd_sale_assignment1;

/**ccode (string): the code of the customer (this should be unique for the customer).
cus_name (string): the name of the customer.
phone (string): The phone number of the customer (must contain digits only).
 *
 * @author ASUS ROG
 */
public class Customer {
    private String ccode;
    private String cus_name;
    private int phone;

    public Customer() {
    }

    public Customer(String ccode, String cus_name, int phone) {
        this.ccode = ccode;
        this.cus_name = cus_name;
        this.phone = phone;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
     public String toString() {
        return String.format("%-5s | %-15s | %-5d", ccode, cus_name, phone);
    }
}
