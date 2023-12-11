import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HashTableHashDuplo<t> implements DicionarioImp<t> {
    private Obj[] Dic;
    private int tam;
    private int el=0;
    private List<t> keys = new ArrayList<>();
    private List<Obj> Elements = new ArrayList<>();
    
    public HashTableHashDuplo() {
        Dic =(Obj[]) new Object[tam];
    }
    
    @Override
    public Iterator<Obj> Element() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public t InsertItem(t chave, Obj element) {
        // TODO Auto-generated method stub
        int index = (int) chave%tam;
        if(true){

        }
        return null;
    }
    @Override
    public Iterator<t> Key() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Obj findElement(t chave) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public Obj removeElement(t chave) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
}
