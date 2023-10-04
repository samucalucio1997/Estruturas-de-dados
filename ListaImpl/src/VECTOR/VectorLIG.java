package VECTOR;

public class VectorLIG implements VectorIM {
    private No head;
    private No tail;
    private int c = -1;

    public VectorLIG() {
        this.head = new No();
        this.tail = new No();
    }

    @Override
    public Object ReplaceAtRank(int r, Object o) {
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
        No cursor = head;
        for (int i = 0; i < index; i++) {
            if (!cursor.getNext().equals(tail)) {
                cursor = cursor.getNext();
            } else {
                throw new RuntimeException("valor de índice inválido");
            }
        }
        return cursor.getNext().getValue();
    }

    @Override
    public Object insertAtRank(Object o, int p) {
        p--;
        No new_no = new No(o);
        if (c == -1) {
            head.setNext(new_no);
            tail.setPrev(new_no);
            new_no.setNext(tail);
            new_no.setPrev(head);
        } else {
            No cursor = new No();
            cursor = head;
            for (int i = 0; i < p; i++) {
                cursor = cursor.getNext();
            }
            new_no.setPrev(cursor);
            new_no.setNext(cursor.getNext());
            cursor.getNext().setPrev(new_no);
            cursor.setNext(new_no);
            if (p == c) {
                tail.setPrev(new_no);
            }
        }
        ++c;
        return new_no.getValue();
    }

///////////////////////////////////////////////////////////////////
    public void insertBefore(int index, Object elemento) {
        No new_node = new No(elemento);
        // if(head == null){
        //         he =  new node(null);
        //         fim =  new node(null);
        //         inicio.setNext(new_node);
        //         fim.setPrev(new_node);
        //         new_node.setPrev(inicio);
        //         new_node.setNext(fim);
        //     }
        No atual = head.getNext();
        for (int i = 0; i < index; i++) {
                atual = atual.getNext();
            }
        new_node.setPrev(atual.getPrev());
        new_node.setNext(atual);
        (atual.getPrev()).setNext(new_node);
        atual.setPrev(new_node);
        ++c;
    }

    
    public void insertAfter(int index, Object elemento) {
        
        No new_node = new No(elemento);
        // if(inicio == null){
        //         inicio =  new node(null);
        //         fim =  new node(null);
        //         inicio.setNext(new_node);
        //         fim.setPrev(new_node);
        //         new_node.setPrev(inicio);
        //         new_node.setNext(fim);
        //     }
        No atual = head.getNext();
        for (int i = 0; i < index; i++) {
                atual = atual.getNext();
            }
        new_node.setPrev(atual);
        new_node.setNext(atual.getNext());
        (atual.getNext()).setPrev(new_node);
        atual.setNext(new_node);
        ++c;
    }







////////////////////////////////////////////////////////////////////////////////////


    @Override
    public boolean isEmpty() {
        return c == -1;
    }

    @Override
    public Object removeAtRank(int ar) {
        No cursor = new No();
        cursor = head;
        for (int i = 0; i <= ar; i++) {
            cursor = cursor.getNext();
        }
        No node = cursor;
        cursor.getNext().setPrev(cursor.getPrev());
        cursor.getPrev().setNext(cursor.getNext());
        cursor = null;
        c--;
        return node.getValue();
    }

    @Override
    public int size() {
        return c + 1;
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

    public void showElements() {
        No cursNo = new No();
        cursNo = head;

        System.out.print("[");
        while (cursNo.getNext().getValue() != null) {
            System.out.print(cursNo.getNext().getValue() + ", ");
            cursNo = cursNo.getNext();
        }
        System.out.println("]");
    }
}