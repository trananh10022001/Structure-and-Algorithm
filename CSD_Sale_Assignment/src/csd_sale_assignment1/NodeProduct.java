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
public class NodeProduct {
    Product info;
    NodeProduct next;

    public NodeProduct() {
    }

    public NodeProduct(Product info, NodeProduct next) {
        this.info = info;
        this.next = next;
    }

    public Product getInfo() {
        return info;
    }

    public void setInfo(Product info) {
        this.info = info;
    }

    public NodeProduct getNext() {
        return next;
    }

    public void setNext(NodeProduct next) {
        this.next = next;
    }
    
}
