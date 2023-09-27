package LIFOWFil;

import FIFO.Fila;

public class PilhaIMP implements PilhaI{
    private Fila fila1;
    private Fila fila2;
     
    

    public PilhaIMP() {
        fila1 = new Fila<Object>(0, 0);
        fila2 = new Fila<Object>(0, 0);
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return fila1.isEmpty();
        
    }

    @Override
    public Object pop() {
        if(fila2.isEmpty()){
             throw new PilhaWException("Pilha vazia"); 
        }
        Object pp = fila2.first();
        fila2.deQueue();
        fila1 = fila2.Copy();
        return pp;
    }

    @Override
    public void push(Object o) {
        // TODO Auto-generated method stub
        fila1.enQueue(o);
        fila2 = fila1.Copy();
    }

    @Override
    public int size() {
        if(isEmpty()){
             throw new PilhaWException("pilha vazia");  
        }
        return fila1.size();
    }

    @Override
    public Object top() {
        if(isEmpty()){
             throw new PilhaWException("pilha vazia");  
        }
        return fila2.first();
    }
    
}
