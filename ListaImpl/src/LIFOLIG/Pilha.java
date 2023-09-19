package LIFOLIG;

import FIFOLIG.No;

public class Pilha<T> implements PilhaIM<T> {
    private int f;//f é o inicio
    private No<T> tail;/*
                        * para inserir na frente mas coloquei tail n sei pq
                        */

    public Pilha() {
        f = -1;
        this.tail = null;
    }

    @Override
    public T push(T o) {
        No<T> mod = new No<>(o);
        tail = mod;
        this.f++;
        tail.setNext(null);
        return mod.getValue();
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }
        No<T> old_no;
        old_no = tail;
        tail=tail.getNext();
        f--;
        return old_no.getValue();
    }

    @Override
    public int size() {
        return f + 1;
    }

    @Override
    public boolean isEmpty() {
        return f == 0;
    }
    
    public void showElements(){
        for (int i = 0; i < size(); i++) {
            System.out.print(tail.getValue());
            tail=tail.getNext();
            System.out.print(", ");
        }
    }

}
