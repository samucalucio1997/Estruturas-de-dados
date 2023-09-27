package FIFOLIG;

public class No<T> {// A classe No<T> como célula da lista 
    private No<T> next;
    private T value;

    public No(T value) {
        this.value = value;
        this.next = null; 
    }
    
    public No() {
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
