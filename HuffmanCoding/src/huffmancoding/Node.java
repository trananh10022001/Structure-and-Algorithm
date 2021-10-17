/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancoding;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ASUS
 */
public class Node {
    int freqeuncy;
    char c;
    String encoded;
    
    Node left, right;

    public Node() {
    }

    public Node(char c, int freqeuncy) {
        this.freqeuncy = freqeuncy;
        this.c = c;
        this.encoded = "";
        this.left = this.right = null;
    }
    
    
}

