package SkipList;

import java.rmi.server.ObjID;
import java.util.LinkedList;
import java.util.List;

import Lista.No;

public class SkipList<t> {

   private LinkedList<No> S0;
   private int h=0;
   private LinkedList<No> linkedList;

public SkipList() {
    S0 = new LinkedList<>();
    this.S0.addFirst(new No(-100));
    this.S0.addLast(new No(100));
    this.linkedList= this.S0;
}

private int random(){
    double p =  Math.random()*10;
    int k = (int) p ;
    return k;
}

void InsertItem(Object chave){
    int i = 0;
    while (random() == 0) {
        i++;
    }
    
    if(i>=h){
        this.linkedList = AddLista();
    }
    No shift = this.linkedList.getFirst();
    shift.setNextNo(this.linkedList.size()>2?this.linkedList.getFirst().getNextNo():this.linkedList.getLast());
    shift = ProcuraNoLista(shift, chave);
    int index = this.S0.indexOf(shift);
    No new_No = new No(chave);
    new_No.setPrevNo(shift);
    new_No.setNextNo(shift.getNextNo());
    S0.add(index+1, new_No); // inserir depois do no achado
    shift = S0.get(index+1);
    
}

private No ProcuraNoLista(No shift, Object chave){
    while(shift.getValue()!=null&&shift.getNextNo() != null&&(int)shift.getNextNo().getValue() < (int)chave){
        if(shift.getDownNo()!=null && (int)shift.getNextNo().getValue() > (int)chave){
            shift = dropDown(shift);
            continue;
        }else{
            if (shift.getNextNo() != null && (int)shift.getNextNo().getValue() < (int)chave) {
                shift = scanForward(shift);
                continue;
            }else{
                break;
            }
        }
    }
    return shift;
}

public void mostra(LinkedList<No> list){
    for (No no : list) {
        System.out.print(no.getValue()+" ");
    }
    System.out.println();
    LinkedList<No> new_lista = new LinkedList();
    if(list.getFirst().getUpNo()!=null){
        new_lista.set(list.indexOf(new_lista.getFirst()),list.getFirst().getUpNo());
        new_lista.set(list.indexOf(new_lista.getLast()),list.getLast().getUpNo());
        mostra(new_lista);
    }else{
        return;
    }
}

private No scanForward(No ref){
    return ref.getNextNo();
}

private No dropDown(No ref){
    return ref.getDownNo();
}

private LinkedList<No> AddLista() {
    LinkedList<No> Sh = new LinkedList<>();
    Sh.addFirst(this.S0.getFirst());
    Sh.addLast(this.S0.getLast());
    No curNo =  S0.getFirst();
    No tail =  S0.getLast();
    while (curNo.getUpNo() != null) {
        curNo = curNo.getUpNo(); 
        tail = tail.getUpNo();
    }
    curNo.setUpNo(Sh.getFirst());
    tail.setUpNo(Sh.getLast());
    Sh.getFirst().setDownNo(curNo);
    Sh.getLast().setDownNo(tail);
    return Sh;
}

public LinkedList<No> getS0() {
 return S0;
}

public void setS0(LinkedList<No> s0) {
 S0 = s0;
}
}
