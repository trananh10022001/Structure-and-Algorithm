/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd_sale_assignment1;

/**
 *
 * @author ASUS ROG
 */
public class NodeCustomer {
    Customer info;
    NodeCustomer next;

    public NodeCustomer() {
    }

    public NodeCustomer(Customer info, NodeCustomer next) {
        this.info = info;
        this.next = next;
    }

    public Customer getInfo() {
        return info;
    }

    public void setInfo(Customer info) {
        this.info = info;
    }

    public NodeCustomer getNext() {
        return next;
    }

    public void setNext(NodeCustomer next) {
        this.next = next;
    }
    
}
