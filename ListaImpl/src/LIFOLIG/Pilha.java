package LIFOLIG;

import FIFOLIG.No;
import LIFOWFil.PilhaWException;

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

    public void AdicionaPilha(Pilha<T> p){
        Pilha<T> ipl = new Pilha<>();
        
        while (!p.isEmpty()) {
            ipl.push(p.pop());
        }
        while(!ipl.isEmpty()){
           p.push(ipl.first());
           push(ipl.pop());
        }
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new PilhaWException("pilha vazia");
        } 
        Object topo = head.getValue();
        head=head.getNext();
        f--;
        return (T) topo;
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