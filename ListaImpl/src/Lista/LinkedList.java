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




    public No<t> getFirstNo() {
        return firstNo;
    }


    public void setFirstNo(No<t> firstNo) {
        this.firstNo = firstNo;
    }


    public No<t> getTailNo() {
        return tailNo;
    }


    public void setTailNo(No<t> tailNo) {
        this.tailNo = tailNo;
    }

    
}
