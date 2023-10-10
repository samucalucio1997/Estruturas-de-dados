package SEQUENCIA;

public class Sequencia implements SequenciaIM{

    private No head;
    private No tail;
    private int t=-1;
    private No interNo;
     

    public Sequencia() {
        this.head = new No();
        this.tail = new No();
    }


    @Override
    public int RankOf(No no) {
        // TODO Auto-generated method stub
        if(t==-1){
            throw new RuntimeException("sequencia vazia!!");
        }
        No n = head.getNext();
        int r=0;
        while((!n.getValue().equals(no.getValue()))){
            n=n.getNext();
            r++;
        }
        return r;
    }

    
    @Override
    public No atRank(int rank) {
        // TODO Auto-generated method stub
        if(t==-1){
            throw new RuntimeException("sequencia vazia!!");
        }
        No new_node;
        if(rank <= size()/2){
            new_node = head.getNext();
            for (int i = 0; i < rank; i++) {
                new_node = new_node.getNext();
            }  
        }else{
            new_node = tail.getPrev();
            for (int i = 0; i < size()-rank -1; i++) {
                new_node = new_node.getPrev();
            }
        }
        return new_node;
    }
    

    @Override
    public Object First() {
        // TODO Auto-generated method stub
        if(t==-1){
            throw new RuntimeException("sequencia vazia!!");
        }
        return head.getNext().getValue();
    }

    @Override
    public Object Last() {
        // TODO Auto-generated method stub
        if(t==-1){
            throw new RuntimeException("sequencia vazia!!");
        } 
        return tail.getPrev().getValue();
    }

    @Override
    public Object ReplaceAtRank(int r, Object o) {
        // TODO Auto-generated method stub
        No cursor = head;
        No newNo = new No(o);
        for (int i = 0; i <= r; i++) {
            cursor = cursor.getNext();
        }
        newNo.setNext(cursor.getNext());
        newNo.setPrev(cursor.getPrev());
        cursor.getNext().setPrev(newNo);
        cursor.getPrev().setNext(newNo);
        return newNo.getValue();
    }

    @Override
    public Object elementAtRank(int index) {
        // TODO Auto-generated method stub
        if(t==-1){
           throw new RuntimeException("Sequencia vazia!");
        }
        No cursor = head.getNext();
       for (int i = 0; i < index; i++) {
           if (!cursor.getNext().equals(tail)) {
               cursor = cursor.getNext();
           } else {
               throw new RuntimeException("valor de índice inválido");
           }
       }
        return cursor.getValue();
    }
     
    @Override
    public Object insertAfter(Object p, Object l) {
        /*
        p seria o valor que apos ele 
        seria inserido o no com o valor l!!! 
        */
        No new_no = new No(l);
        if (t == -1) {
            head.setNext(new_no);
            tail.setPrev(new_no);
        } else {
            No cursNo = Search(p);
            new_no.setNext(cursNo.getNext());
            new_no.setPrev(cursNo);
            cursNo.getNext().setPrev(new_no);
            cursNo.setNext(new_no);
        }
        t++;
        return new_no;
    }

    @Override
    public Object insertAtRank(Object o, int p) {
        // TODO Auto-generated method stub
        No new_no = new No(o);
        if (t == -1) {
            head.setNext(new_no);
            tail.setPrev(new_no);
            new_no.setNext(tail);
            new_no.setPrev(head);
        } else {
            No cursor = Search(elementAtRank(--p));
            new_no.setPrev(cursor);
            new_no.setNext(cursor.getNext());
            cursor.getNext().setPrev(new_no);
            cursor.setNext(new_no);
            if (p == t) {
                tail.setPrev(new_no);
            }
        }
        ++t;
        return new_no.getValue();
    }

     
    @Override
    public Object insertBefore(Object p, Object o) {
        // TODO Auto-generated method stub
        No new_no = new No(o);
      if (t == -1) {
          head.setNext(new_no);
          tail.setPrev(new_no);
      } else {
          No cursor = Search(o);
          cursor = cursor.getPrev();
          new_no.setNext(cursor);
          new_no.setPrev(cursor.getPrev());
          cursor.getNext().setPrev(new_no);
          cursor.getPrev().setNext(new_no);
      }
      t++;
      return new_no;
    }

    public No Search(Object no) {
        No cursNo = head.getNext();
        while (!cursNo.getValue().equals(no)) {
            if (cursNo.getValue().equals(null)) {
                throw new RuntimeException("Não tem o nó coleguinha");
            }
            cursNo = cursNo.getNext();
        }
        return cursNo;
    }


    @Override
    public Object insertFirst(Object p) {
        // TODO Auto-generated method stub
        No new_no = new No(p);
        if (t == -1) {
            head.setNext(new_no);
            tail.setPrev(new_no);
        } else {
            new_no.setNext(head.getNext());
            new_no.setPrev(head);
            head.getNext().setPrev(new_no);
            head.setNext(new_no);
        }
        t++;
        return head;
    }

    @Override
    public Object insertLast(Object m) {
        // TODO Auto-generated method stub
          No new_no = new No(m);
        if (isEmpty()) {
            head.setNext(new_no);
            tail.setPrev(new_no);
        } else {
            new_no.setNext(tail);
            new_no.setPrev(tail.getPrev());
            tail.getPrev().setNext(new_no);
            tail.setPrev(new_no);
        }
        t++;
        return tail.getPrev();
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return t==-1;
    }

    @Override
    public Boolean isFirst(Object jk) {
        // TODO Auto-generated method stub
        if(t==-1){
            throw new RuntimeException("sequencia vazia!!");
        }
        return head.getNext().getValue().equals(jk);
    }

    @Override
    public Boolean isLast(Object jk) {
        // TODO Auto-generated method stub
        if(t==-1){
            throw new RuntimeException("sequencia vazia!!");
        }
        return tail.getPrev().getValue().equals(jk);
    }

    @Override
    public Object remove(Object no) {
        // TODO Auto-generated method stub
        if (isEmpty()) {
           throw new RuntimeException("Lista vazia");
       }
       No cursNo = Search(no);
       No remove = cursNo;
       cursNo.getPrev().setNext(cursNo.getNext());
       cursNo.getNext().setPrev(cursNo.getPrev());
       cursNo = null;
       return remove.getValue();
    }

    @Override
    public Object removeAtRank(int ar) {
        // TODO Auto-generated method stub
       No cursor = new No();
       cursor = head;
       for (int i = 0; i <= ar; i++) {
           cursor = cursor.getNext();
       }
       No node = cursor;
       cursor.getNext().setPrev(cursor.getPrev());
       cursor.getPrev().setNext(cursor.getNext());
       cursor = null;
       t--; 
       return node.getValue();
    }

    @Override
    public Object replaceElement(Object n, int o) {
        // TODO Auto-generated method stub
       No cursor = head;
       No newNo = new No(n);
       for (int i = 0; i <= o; i++) {
           cursor = cursor.getNext();
       }
       newNo.setNext(cursor.getNext());
       newNo.setPrev(cursor.getPrev());
       cursor.getNext().setPrev(newNo);
       cursor.getPrev().setNext(newNo);
       return newNo.getValue();
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return t+1;
    }

    public void Object(){
        No curNo = head;
        while(!curNo.getNext().equals(null)){
            System.out.println(curNo.getNext().getValue());
            curNo = curNo.getNext();
        }
    }

    public Object nextObject(){
        interNo = head.getNext();
        return interNo.getValue();
    }

    public boolean hasNext(){
        interNo = interNo==null?interNo.getNext():interNo;
        return interNo.equals(null);
    }

    @Override
    public void swapElement(Object a, Object b) {
        // TODO Auto-generated method stub
        No cursorNo = head.getNext();
        No cursor = head.getNext();
        int c = 0;
        int d = 0;
        if (t == -1) {
            throw new RuntimeException("Lista vazia");
        }
        while (!cursor.getValue().equals(a)) {
            cursorNo = cursorNo.getNext();
            c++;
        }
        while (!cursor.getValue().equals(b)) {
            cursor = cursor.getNext();
            d++;
        }
        replaceElement(cursor.getValue(), c);
        replaceElement(cursorNo.getValue(), d);
    }

    public void showElements(){
        No cursNo = head;
        System.out.print("[");
        while (cursNo.getNext() != null && !cursNo.getNext().equals(head)) {
            System.out.print(cursNo.getNext().getValue() + ", ");
            cursNo = cursNo.getNext();
        }
        System.out.print("]");
        System.out.println();
    }
}
