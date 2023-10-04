package Lista;

public class No {
    private Object value;
    private No nextNo;
    private No prevNo;
    
    

  
    

    
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
    public No getNextNo() {
        return nextNo;
    }
    public void setNextNo(No nextNo) {
        this.nextNo = nextNo;
    }
    public No getPrevNo() {
        return prevNo;
    }
    public void setPrevNo(No prevNo) {
        this.prevNo = prevNo;
    }
    

    

}
