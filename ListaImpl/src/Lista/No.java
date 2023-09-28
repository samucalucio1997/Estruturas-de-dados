package Lista;

public class No<t> {
    private t value;
    private No<t> nextNo;
    private No<t> prevNo;

    
    
    public No(t value) {
        this.value = value;
        this.nextNo =null; 
    }

    public No<t> getPrevNo() {
        return prevNo;
    }

    public void setPrevNo(No<t> prevNo) {
        this.prevNo = prevNo;
    }

    
    public t getValue() {
        return value;
    }


    public void setValue(t value) {
        this.value = value;
    }


    public No<t> getNextNo() {
        return nextNo;
    }


    public void setNextNo(No<t> nextNo) {
        this.nextNo = nextNo;
    }


    

}
