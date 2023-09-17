package FIFOLIG;

public class FilaL<T> implements FilaIm<T> {
    private int i=0; 
    private No<T> head;
    
    
    public FilaL() {
      head = null;
    }
    

    
    public No<T> getHead() {
        return head;
    }

    public void setHead(No<T> head) {
        this.head = head;
    }


    @Override
    public T deQueue() {
      
        
        return null;
    }
    
    @Override
    public T enQueue(T no) {
        No<T> new_node=new No<T>(no);
        head = new_node;
        this.i++;
        return head.getValue();
    }
    
    @Override
    public T first() {
        return head.getValue();
    }

    @Override
    public Boolean isEmpty() {
        return i==0;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return i;
    }
    
    public int getI() {
        return i;
    }
    
    public void setI(int i) {
        this.i = i;
    }
   
}
