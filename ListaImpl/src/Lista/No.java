package Lista;

public class No<t> {
    private t value;
    private No<t> nextNo;
    
    public No(T value) {
        this.value = value;
        this.nextNo =null; 
    }
    
    public T getValue() {
        return value;
    }


    public void setValue(T value) {
        this.value = value;
    }


    public No<T> getNextNo() {
        return nextNo;
    }


    public void setNextNo(No<T> nextNo) {
        this.nextNo = nextNo;
    }


    

}
