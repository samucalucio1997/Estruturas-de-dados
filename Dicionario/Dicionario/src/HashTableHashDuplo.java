import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HashTableHashDuplo<t> implements DicionarioImp<t> {
    private Obj<t>[] Dic;
    private int tam;
    private int el=0;
    private List<t> keys = new ArrayList<>();
    private List<Obj<t>> Elements = new ArrayList<>();
    
    public HashTableHashDuplo() {
        Dic =(Obj<t>[]) new Obj[tam];
    }
    
    @Override
    public Iterator<Obj<t>> Element() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public t InsertItem(t chave, Obj<t> element) {
        // TODO Auto-generated method stub
        element.setValue(chave);
        int index = (int) chave%tam;
        while(Dic[index]!=null){
            
        }    
        return null;
    }
    @Override
    public Iterator<t> Key() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Obj<t> findElement(t chave) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public Obj<t> removeElement(t chave) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
}
