package Lista;

public class No {
    private Object value;
    private No nextNo;
    private No prevNo;
    private No DownNo;
    private No upNo;
    
    public No getUpNo() {
        return upNo;
    }

    public void setUpNo(No upNo) {
        this.upNo = upNo;
    }

    public No(){}

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
    
    public No getDownNo() {
        return DownNo;
    }
    
    public void setDownNo(No downNo) {
        DownNo = downNo;
    }
    
}
