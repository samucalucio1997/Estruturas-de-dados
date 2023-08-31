package Lista;

public class LinkedList<t> {
    private No<t> firstNo;
    private No<t> tailNo;
    
    
    
    public LinkedList() {
        this.firstNo = null;
        this.tailNo = null;
    }
   
    public boolean add(No<t> newNo){
        if(firstNo==null&&tailNo==null){
           firstNo = newNo;
        }else{
            tailNo =newNo;
        } 
        return true;
    }
    
    public boolean addAll(LinkedList<t> lista){
        if(tailNo==null){
           firstNo=lista.getFirstNo();
           tailNo = lista.getTailNo();
           return true;
        }else{
            tailNo.setNextNo(lista.getFirstNo());
            return true;
        }
    }




    public No<T> getFirstNo() {
        return firstNo;
    }


    public void setFirstNo(No<T> firstNo) {
        this.firstNo = firstNo;
    }


    public No<T> getTailNo() {
        return tailNo;
    }


    public void setTailNo(No<T> tailNo) {
        this.tailNo = tailNo;
    }

    
}
