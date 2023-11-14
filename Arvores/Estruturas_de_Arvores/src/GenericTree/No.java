package GenericTree;

import java.util.ArrayList;
import java.util.Iterator;

public class No<t> {
    private t o;
    private No<t> pai;
    private ArrayList<No<t>> filhos = new ArrayList<>();
    public No(No<t> pai, t o){
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
    public Iterator<No<t>> children()
    {
        return filhos.iterator();
    }    
}

