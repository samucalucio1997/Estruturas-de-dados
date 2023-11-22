package FilaPrioridade;

import ArvoreBinariaPesquisa.no;

public class FilaPrioridadeArray<t> implements FilaI<t>{
    private t[] arr;
    private t value;
    private int tam=2;
    private int index;

    public FilaPrioridadeArray(t value) {
        this.value = value;
        this.arr = (t[]) new Object[tam];
        arr[this.tam-1]=value; 
        index = this.tam - 1;
    }

    @Override
    public void insert(t chave, no<t> valor) {
        // TODO Auto-generated method stub
        if(index>=this.arr.length){
            int k = this.tam;
            this.tam*=2;
            t[] novo =(t[]) new Object[this.tam];
            for (int i = 0; i < k; i++) {
                novo[i]=arr[i];
            }
            arr=novo;
        }
        if(arr[2*index]==null){
            arr[2*index]=chave;
        }else{
            arr[2*index+1]=chave;
        }
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public t min() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeMin() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return this.tam;
    }
    
}
