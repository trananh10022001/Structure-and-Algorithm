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


import java.util.Scanner;
import jdk.nashorn.internal.parser.Lexer;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Input your string to encode: ");
        char[] inputString = input();
        char[] distinct = getDistinctChar(inputString);
        int[] fre = getFrequency(inputString);

        Huffman.createHuffmanTree(distinct, fre);
        Huffman.encode(inputString);
    }

    private static char[] input() {
        String string = "";
        Scanner sc = new Scanner(System.in);
        do {
            string = sc.nextLine().toLowerCase();
            if (!string.matches("^[a-z ]+")) {
                System.out.println("Input characters only! Input new text:");
            }
        } while (!string.matches("^[a-z ]+"));
        return string.toCharArray();
    }

    private static int[] getFrequency(char[] a) {
        char[] distinct = getDistinctChar(a);
        int size = distinct.length;
        int[] arr = new int[size];
        int count = 0;
        for (int i = 0; i < distinct.length; i++) {
            count = 0;
            for (char ch : a) {
                if (ch == distinct[i]) {
                    count++;
                }
            }
            arr[i] = count;
        }
        return arr;
    }

    private static char[] getDistinctChar(char[] a) {
        String arr = "";
        for (char ch : a) {
            if (!arr.contains(ch + "") && ch != ' ') {
                arr += ch;
            }
        }
        return arr.toCharArray();
    }

    
}

