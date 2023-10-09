package SEQUENCIA;

public class No {
    private Object value;
    private No next;
    private No prev;
   
   
    

    public No() {
    }


    public No(Object value) {
        this.value = value;
    }


    public Object getValue() {
        return value;
    }


    public void setValue(Object value) {
        this.value = value;
    }


    public No getNext() {
        return next;
    }


    public void setNext(No next) {
        this.next = next;
    }


    public No getPrev() {
        return prev;
    }


    public void setPrev(No prev) {
        this.prev = prev;
    }
    
}
