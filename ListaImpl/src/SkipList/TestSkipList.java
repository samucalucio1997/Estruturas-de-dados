package SkipList;

import java.util.LinkedList;

import Lista.No;

public class TestSkipList {
     public static void main(String[] args) {
        SkipList<Integer> skip = new SkipList<Integer>();
        // skip.InsertItem(45);
        // skip.InsertItem(12);
        // skip.InsertItem(25);
        // skip.InsertItem(18);
        // skip.InsertItem(59);
        // skip.InsertItem(27);
        // skip.mostra(skip.getS0());
        LinkedList<No> list = new LinkedList<>();
        LinkedList<No> list0 = new LinkedList<>();
        list.addFirst(new No(-100));
        list.addLast(new No(100));
        list0.addFirst(new No(-100));
        list0.addLast(new No(100));
        list.getFirst().setDownNo(list0.getFirst());
        list.getLast().setDownNo(list0.getLast());
        list0.getFirst().setUpNo(list.getFirst());
        list0.getLast().setUpNo(list.getLast());
        No n1=new No(85);
        No n2=new No(75);
        n1.setNextNo(n2);
        n2.setPrevNo(n1);
        No n3=new No(85);
        n3.setDownNo(n2);
        n2.setUpNo(n3);
        list.add(1, n3);
        list.getFirst().setNextNo(n1);
        list.getLast().setPrevNo(n2);
        list.add(1,n2);
        list0.add(1,n3);
        list0.getFirst().setNextNo(n3);
        list0.getLast().setPrevNo(n3);
        for (No no : list0) {
            System.out.print(no.getValue()+" "+no.getNextNo());
        }
        System.out.println("list:");
        for (No no : list) {
            System.out.print(no.getValue()+" "+ no.getNextNo());
        }
        System.out.println();
        System.out.println(skip.ProcuraNoLista(list.getFirst(), n3.getValue()).getValue());
    }
}
