package VECTOR;

public class VectorLIG implements VectorIM{
    private No head;
    private No tail;
    private int c=-1;
    
    public VectorLIG() {
        this.head = new No();
        this.tail = new No();
    }


    @Override
    public Object ReplaceAtRank(int r, Object o) {
        // TODO Auto-generated method stub

        return null;
    }

    
    
    
    
    



    @Override
    public Object elementAtRank(int index) {
        // TODO Auto-generated method stub
        return null;
    }



    
    


    

    @Override
    public Object insertAtRank(Object o, int p) {
        // TODO Auto-generated method stub
        p--;
        No new_no = new No(o);
        if(c==-1){
           head.setNext(new_no);
           tail.setPrev(new_no);
           new_no.setNext(tail);
           new_no.setPrev(head);
        }else{
            No cursor = new No();
            cursor = head;
            for (int i = 0; i < p; i++) {
                   
                       cursor = cursor.getNext();
                   
                }
                new_no.setPrev(cursor);
                new_no.setNext(cursor.getNext());
                cursor.getNext().setPrev(new_no);
                cursor.setNext(new_no);
            if(p==c){
                tail.setPrev(new_no);
            }    
        }
        ++c;
        return new_no.getValue();
    }
    

    
    

    

    
    
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }






    


    @Override
    public Object removeAtRank(int ar) {
        // TODO Auto-generated method stub
        return null;
    }
    
    

    
    
    

    
    
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
        public No getHead() {
            return head;
        }
    
    
    
        public void setHead(No head) {
            this.head = head;
        }
    
    
    
        public No getTail() {
            return tail;
        }
    
    
    
        public void setTail(No tail) {
            this.tail = tail;
        }
          
        public void showElemnts(){
            No cursNo = new No();
            cursNo = head;
            
            System.out.print("[");
            while(cursNo.getNext().getValue()!=null){
                System.out.print(cursNo.getNext().getValue()+", ");
                cursNo = cursNo.getNext();
            }
            System.out.println("]");
        }

}
