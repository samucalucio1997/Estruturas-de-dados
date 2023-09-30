package VECTOR;

public class No {
    private No next;
    private No prev;
    private Object value;

    
    public No(Object value) {
        this.value = value;
    }

    
    
    
    public No() {
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
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }     
}
