import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HashTableLinearProbing<t extends Object> implements DicionarioImp<t>{
     
    private Obj[] Dic;
    private int tam;
    private int el=0;
    private List<t> keys = new ArrayList<>();
    private List<Obj> Elements = new ArrayList<>();


    public HashTableLinearProbing() {
        Dic =  (Obj[]) new Object[tam];
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

    @Override
    public Iterator<Obj> Element() {
        // TODO Auto-generated method stub
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
        throw new UnsupportedOperationException("Unimplemented method 'findElement'");
    }


    @Override
    public t InsertItem(t chave, Obj element) {
        // TODO Auto-generated method stub
        if(el==Dic.length){
              tam*=2;
              Obj[] novo = (Obj[]) new Object[tam];
              for (int i = 0; i < Dic.length; i++) {
                   novo[i] = Dic[i];
              }
              Dic = novo;
        }
        int index = (int)chave%tam;
        while(Dic[index] != null){
            index++;
        }
        Dic[index] = element;
        el++;
        return chave;
    }

}
