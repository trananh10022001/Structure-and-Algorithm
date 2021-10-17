/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd_sale_assignment1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ASUS ROG
 */
public class Function_Of_Customer {
     NodeCustomer head, tail;

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void addCustomer() {
        addTailCustomer(new Customer("C03", "Hoa", 1902));
        addTailCustomer(new Customer("C01", "La", 1901));
        addTailCustomer(new Customer("C02", "Canh", 1903));
        addTailCustomer(new Customer("C05", "Cay", 1910));
    }

    void writeFileCustomer(String pname) {
        NodeCustomer p = head;
        try {
            FileWriter fw = new FileWriter(pname + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(String.format("%-5s | %-15s | %-5s", "CCode", "Name", "Phone"));
            bw.newLine();
            do {
                bw.write(p.info.toString());
                bw.newLine();
                p = p.next;
            } while (p != null);
            bw.close();
            fw.close();
        } catch (IOException e) {
        }
    }

    void addTailCustomer(Customer x) {
        if (isEmpty()) {
            head = tail = new NodeCustomer(x, null);
        } else {
            NodeCustomer p = new NodeCustomer(x, null);
            tail.next = p;
            tail = p;
        }
    }

    void inputAndAddEndCustomer() {
        NodeCustomer p = head;
        String CCode = CheckInputData.getProduct("Enter the code of customer: ");
        String name = CheckInputData.getProduct("Enter the customer's name: ");
        int phone = CheckInputData.getPhone();
        addTailCustomer(new Customer(CCode, name, phone));
        System.out.println("ADD COMPLETED!");
    }

    void searchByCCode(String CCode) {
        NodeCustomer p = head;
        if (isEmpty()) {
            return;
        }
        if (head.next == null) {
            if (head.info.getCcode().equals(CCode)) {
                System.out.println(head.info.toString());
            } else {
                System.out.println("No CCode " + CCode + " in the list!");
            }
            return;
        }
        do {
            if (p.info.getCcode().contains(CCode)) {
                System.out.println(p.info.toString());
                System.out.println("Search completed!");
                return;
            } else {
                p = p.next;
            }
        } while (p != null);
        System.out.println("No CCode " + CCode + " in the list!");
    }

    void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        if (head != tail) {
            head = head.next;
        } else {
            head = head.next;
            tail = null;
        }
    }

    void deleteByCCode(String CCode) {
        NodeCustomer p = head;
        if (isEmpty()) {
            return;
        }
        if (head.next == null) {
            if (head.info.getCcode().equals(CCode)) {
                deleteFirst();
            } else {
                System.out.println("No Ccode " + CCode + " in the list!");
            }
            return;
        }
        while (p.next != null) {
            if (p.next.info.getCcode().equals(CCode)) {
                p.next = p.next.next;
                System.out.println("Delete completed!");
                return;
            } else {
                p = p.next;
            }
        }
        System.out.println("No CCode " + CCode + " in the list!");
    }
}
