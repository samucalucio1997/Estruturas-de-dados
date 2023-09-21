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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void push(Object o) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object top() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
