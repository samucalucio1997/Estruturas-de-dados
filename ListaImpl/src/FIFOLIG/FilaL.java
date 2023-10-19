package FIFOLIG;


public class FilaL<T> implements FilaIm<T> {
    private int i=0; 
    private No<T> head;
    private No<T> tail;
    
    
    public FilaL() {
      head=null;
      tail = null;  
    }
    

    
    public No<T> getHead() {
        return head;
    }


    @Override
    public T deQueue() {
        if(isEmpty()){
            throw new RuntimeException("Pilha vazia");
        }
        No<T> old_No = head;
        head=head.getNext();
        --i;
        return old_No.getValue();
    }
    
    @Override
    public T enQueue(T no) {
        No<T> new_node = new No<T>(no);
        if(head==null){
            head = new_node;
            tail = head;
        }else{
          tail.setNext(new_node);  
          tail = new_node;
        }
        this.i++;
        return no;
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
   
    public void ShowElements(){
        while(head!=null){
            System.out.print(head.getValue());
            head = head.getNext();
            System.out.print(" ");
        }
        System.out.println();
    }
}
