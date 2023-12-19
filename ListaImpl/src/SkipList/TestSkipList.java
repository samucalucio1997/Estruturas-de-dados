package SkipList;

import java.util.LinkedList;

import Lista.No;

public class TestSkipList {
     public static void main(String[] args) {
        // double p =  Math.random()*10;
        // int k = (int) p ;
        // System.out.println("numero sorteado foi: " + k);
        SkipList<Integer> skip = new SkipList<Integer>();
        skip.InsertItem(45);
        skip.InsertItem(12);
        skip.InsertItem(25);
        skip.InsertItem(18);
        skip.InsertItem(59);
        skip.InsertItem(27);
        skip.mostra(skip.getS0());
    }
}
