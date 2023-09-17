package FIFOLIG;

public class No<T> {
    private No<T> next;
    private T value;


    public No(T value) {
        this.value = value;
        this.next = null; 
    }



    
    public No<T> getNext() {
        return next;
    }
    public void setNext(No<T> next) {
        this.next = next;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
}
