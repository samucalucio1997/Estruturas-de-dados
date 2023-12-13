import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HashTableLinearProbing<t extends Object> implements DicionarioImp<t>{
     
    private Obj<t>[] Dic;
    private int tam;
    private int el=0;
    private List<t> keys = new ArrayList<>();
    private List<Obj<t>> Elements = new ArrayList<>();
    
    
    public HashTableLinearProbing(int tam) {
        this.tam = tam;
        Dic =  (Obj[]) new Obj[this.tam];
    }

    
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return el != 0; 
    }

    @Override
    public Obj<t> removeElement(t chave) {
        // TODO Auto-generated method stub
        Obj<t> removed = null;
        for (int i = 0; i < Dic.length; i++) {
            if(Dic[i].getValue().equals(chave)){
                removed = Dic[i];
                Dic[i]=null;
                break;
            }
        }
        return removed;
    }
    
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return this.el;
    }
    
    @Override
    public Iterator<Obj<t>> Element() {
        // TODO Auto-generated method stub
        for (int i = 0; i < Dic.length; i++) {
            if(Dic[i].getValue() != null){
                this.Elements.add(Dic[i]); 
            }
        }
        return this.Elements.iterator();
    }

    @Override
    public Iterator<t> Key() {
        // TODO Auto-generated method stub
        for (int i = 0; i < Dic.length; i++) {
            if(Dic[i].getValue()!=null){
                this.keys.add((t) Dic[i].getValue());
            }
        }
        return this.keys.iterator();
    }
    
    @Override
    public Obj<t> findElement(t chave) {
        // TODO Auto-generated method stub
        Obj<t> ret = null;
        for (int i = 0; i < Dic.length; i++) {
            if(Dic[i].getValue().equals(chave)){
                ret=Dic[i];break;
            }
        }
        if(ret!=null){
            return ret;
        }else{
            throw new RuntimeException("Este elemento não existe");
        }
    }
    
    @Override
    public t InsertItem(t chave, Obj<t> element) {
        // TODO Auto-generated method stub
        element.setValue(chave);
        if(size()/tam >= 0.5){//pegar 
            tam *= 2;
            while(!Isprimo(tam) && size()/tam >= 0.5){
                tam++;
            }
            Obj<t>[] novo = (Obj<t>[]) new Obj[tam];
            for (int i = 0; i < Dic.length; i++) {
                int ind = (int)Dic[i].getValue()%tam;
                novo[ind] = Dic[i];
            }
            Dic = novo;
        }
        int index = (int) chave % tam;
        while(Dic[index] != null){
            if(Dic[index].getValue().equals(chave)){
                throw new RuntimeException("O elemento já existe");
            }
            index = (index + 1) % tam;
        }
        Dic[index] = element;
        el++;
        return chave;
    }
    
    public boolean Isprimo(int num) {
        int p=num-1;
        p/=2; 
        int con=0;
        boolean ret;
        if(num%2==0){
            ret = false;
            return ret;
        }else{
            while (p>1) {
                if(num%p==0){
                    con++;
                }
                p--;
            }
            return ret=con>0?false:true;
        }
    }

    
    public void Print(){
        for (int i = 0; i < Dic.length; i++) {
            if(Dic[i]!=null){
                System.out.println(i+"tem "+ Dic[i].getValue());
            }
        }
    }
   
    public int getTam() {
        return tam;
    }
}
