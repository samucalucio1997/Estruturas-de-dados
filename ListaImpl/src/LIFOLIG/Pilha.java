package LIFOLIG;

import FIFOLIG.No;

public class Pilha<T> implements PilhaIM<T> {
    private int f;//f é o inicio
    private No<T> head;

    public Pilha() {
        f = -1;
        this.head = null;
    }

    public T first(){
        return head.getValue();
    }

    @Override
    public T push(T o) {
        No<T> mod = new No<>(o);
        
            mod.setNext(head);
        head = mod;
        this.f++;
        return mod.getValue();
    }

    @Override
    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        } 
        // System.out.println(head.getValue());
        head=head.getNext();
        f--;
    }

    @Override
    public int size() {
        return f + 1;
    }

    @Override
    public boolean isEmpty() {
        return f == -1;
    }
    
    public void showElements(){
        System.out.print("[");
        while(head.getNext()!=null){
            System.out.print(head.getValue());
            head = head.getNext();
            System.out.print(", ");
        }
        System.out.print(head.getValue());
        System.out.print("]");
    }

}