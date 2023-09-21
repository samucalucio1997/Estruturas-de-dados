package FIFOWPil;

import PilhaExer.Deque;

public class Fila implements FilaIM{
    private Deque pilha1;
    private Deque pilha2;


    


    public Fila() {
        this.pilha1 = new Deque(0);
        this.pilha2 = new Deque(0);
    }

    @Override
    public Object dequeue() {
        Object out = pilha2.pop();
        pilha1 = pilha2.Copy();
     
        // TODO Auto-generated method stub
        return out;
    }

    @Override
    public void enqueue(Object o) {
        // TODO Auto-generated method stub
        pilha1.push(o);
        pilha2=pilha1.Copy();
        
    }

    @Override
    public Object first() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    public void copy(Deque deque){
       
    }
     
    
    


    
    
}
