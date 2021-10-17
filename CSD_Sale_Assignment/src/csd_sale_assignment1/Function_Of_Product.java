/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd_sale_assignment1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ASUS ROG
 */
public class Function_Of_Product {

    NodeProduct head, tail;

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void addTailProduct(Product x) {
        if (isEmpty()) {
            head = tail = new NodeProduct(x, null);
        } else {
            NodeProduct p = new NodeProduct(x, null);
            tail.next = p;
            tail = p;
        }
    }

    void addHeadProduct(Product x) {
        if (isEmpty()) {
            head = tail = new NodeProduct(x, null);
        } else {
            NodeProduct p = new NodeProduct(x, null);
            p.next = head;
            head = p;

        }
    }

    void inputAndAddEnd() {
        NodeProduct p = head;
        String pCode = CheckInputData.getProduct("Enter the code of product: ");
        do {
            if (p.info.getPcode().equals(pCode)) {
                System.out.println("Error! The code of product can not be duplicated!!!!! ");
                return;
            } else {
                p = p.next;
            }
        } while (p != null);
        String Pro_name = CheckInputData.getProduct("Enter the name of product: ");
        int quantity = CheckInputData.getQuantityProduct();
        int saled = CheckInputData.getSaledProduct(quantity);
        double price = CheckInputData.getPriceProduct();
        addTailProduct(new Product(pCode, Pro_name, quantity, saled, price));
        System.out.println("ADD COMPLETED!");
    }

    // Thêm sẵn vài phần tử vào list
    void addProduct() {
        addTailProduct(new Product("P03", "Sugar", 12, 3, 25.1));
        addTailProduct(new Product("P01", "Miliket", 10, 5, 5.2));
        addTailProduct(new Product("P02", "Apple", 5, 2, 4.3));
        addTailProduct(new Product("P05", "Rose", 7, 6, 15.4));
        addTailProduct(new Product("P07", "Beer", 11, 3, 12.2));
        addTailProduct(new Product("P04", "Book", 9, 5, 5.2));
    }

    void writeFileProduct(String pname) {
        NodeProduct p = head;
        try {
            FileWriter fw = new FileWriter(pname + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(String.format("%-5s | %-15s | %-8s | %-6s | %-6s | %-6s", "Code", "Pro_name", "Quantity", "Saled", "Price", "Value"));
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

    void addAtPosition(Product x, int index) {
        if (head == null) {
            addHeadProduct(x);
            return;
        }
        NodeProduct p = head;
        int k = 0;
        while (p != null && k != index) {
            p = p.next;
            k++;
        }
        if (k != index) {
            addTailProduct(x);
        } else {
            NodeProduct t = new NodeProduct(x, null);
            t.next = p.next;
            p.next = t;
            return;
        }
    }

    void addAfterPosition(int index) {
        NodeProduct p = head;
        String pCode = CheckInputData.getProduct("Enter the code of product: ");
        do {
            if (p.info.getPcode().equals(pCode)) {
                System.out.println("Wrong input! The code of book can not be duplicated! ");
                return;
            } else {
                p = p.next;
            }
        } while (p != null);
        String Pro_name = CheckInputData.getProduct("Enter the name of product: ");
        int quantity = CheckInputData.getQuantityProduct();
        int saled = CheckInputData.getSaledProduct(quantity);
        double price = CheckInputData.getPriceProduct();
        Product x = new Product(pCode, Pro_name, quantity, saled, price);
        addAtPosition(x, index);
        System.out.println("ADD COMPLETED!");
        traverse();
    }

    void traverse() {
        NodeProduct p = head;
        while (p != null) {
            System.out.println(p.info);
            p = p.next;
        }
        System.out.println("");
    }

    void searchByPCode(String pCode) {
        int k = 1;
        NodeProduct p = head;
        if (isEmpty()) {
            return;
        }
        if (head.next == null) {
            if (head.info.getPcode().equals(pCode)) {
                System.out.println(head.info.toString());
            } else {
                System.out.println("No pCode " + pCode + " in the list!");
            }
            return;
        }
        do {
            if (p.info.getPcode().contains(pCode)) {
                System.out.println(p.info.toString());
                System.out.println("Search completed!");
                return;
            } else {
                p = p.next;
            }
        } while (p != null);
        System.out.println("No pCode " + pCode + " in the list!");
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
    void deleteSecond(){
        if(isEmpty()) {return;}
         if (head != tail) {
            head = head.next.next;
        } else {
            head = head.next.next;
            tail = null;
        }
        
    }
    void deleteTail() {
        if (isEmpty()) {
            return;
        }
        NodeProduct p;
        p = head;
        if (p.next == null) {
            clear();
            return;
        }
        while (p.next != tail) {
            p = p.next;
        }
        p.next = null;
        tail = p;
    }

    void deleteAt(int index) {
        int k = 1;
        NodeProduct p = head;
        if (isEmpty()) {
            return;
        }
        if (index == 0 || head.next == null) {
            deleteFirst();
            return;
        }
        while (p.next.next != null && k != index) {
            p = p.next;
            k++;
        }
        if (k != index) {
            deleteTail();
        } else {
            p.next = p.next.next;
        }
    }

    void deleteByPCode(String pCode) {
        int k = 1;
        NodeProduct p = head;
        if (isEmpty()) {
            return;
        }
        if (head.next == null) {
            if (head.info.getPcode().equals(pCode)) {
                deleteFirst();
            } else {
                System.out.println("No pCode " + pCode + " in the list!");
            }
            return;
        }
        while (p.next != null) {
            if (p.next.info.getPcode().equals(pCode)) {
                p.next = p.next.next;
                System.out.println("Delete completed!");
                return;
            } else {
                p = p.next;
            }
        }
        System.out.println("No pCode " + pCode + " in the list!");
    }

    void addManyTailProduct(List<Product> list) {
        list.forEach((Product) -> {
            addTailProduct(Product);
        });
    }

    void sortByPCode() {
        List<Product> list = new ArrayList<>();
        do {
            list.add(head.info);
            deleteFirst();
        } while (head != null);
        Collections.sort(list, (csd_sale_assignment1.Product o1, csd_sale_assignment1.Product o2)
                -> o1.getPcode().compareTo(o2.getPcode()));
        addManyTailProduct(list);
    }

    void deleteNextNodeByPCode(String codeSearched) {
         int k = 1;
        NodeProduct p = head;
        if (isEmpty()) {
            return;
        }
        if (head.next == null) {
            if (head.info.getPcode().equals(codeSearched)) {
                deleteSecond();
            } else {
                System.out.println("No pCode " + codeSearched + " in the list!");
            }
            return;
        }
        while (p.next != null) {
            if (p.next.info.getPcode().equals(codeSearched)) {
                p.next = p.next.next;
                System.out.println("Delete completed!");
                return;
            } else {
                p = p.next;
            }
    }
}
}
