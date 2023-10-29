package GenericTree;

import java.util.ArrayList;
import java.util.Iterator;

public class No<t> {
    private t o;
    private No<t> pai;
    private ArrayList<No<t>> filhos = new ArrayList<>();
    public No(No<t> pai, t o)
    {
        this.pai = pai;
        this.o = o;
    }
    public t element()
    {
        return o;
    }
    public No<t> parent()
    {
        return pai;
    }
    public void setElement(t o)
    {
        this.o = o;
    }
    public void addChild(No<t> o)
    {
        filhos.add(o);
    }
    public void removeChild(No<t> o)
    {
        filhos.remove(o);
    }
    public int childrenNumber()
    {
        return filhos.size();
    }
    public Iterator children()
    {
        return filhos.iterator();
    }    
}

// private No<t><t> father;
// private ArrayList<No<t><t>> filhos;
// private t value;


// public No<t>(t value) {
//     this.value = value;
//     filhos = new ArrayList<>();
// }


// public t getValue() {
//     return value;
// }


// public void setValue(t value) {
//     this.value = value;
// }


// public No<t><t> getFather() {
//     return father;
// }


// public void setFather(No<t><t> father) {
//     this.father = father;
// }


// public Iterator getFilhos() {
//     return this.filhos.iterator();
// }


// public void adicionarNoint(No<t><t> elemtNo){
//       this.filhos.add(elemtNo);
// }


// public void setLista(ArrayList<No<t><t>> filhos) {
//     this.filhos = filhos;
// }   