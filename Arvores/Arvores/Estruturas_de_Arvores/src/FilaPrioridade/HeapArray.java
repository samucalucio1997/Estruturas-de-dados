package FilaPrioridade;

import ArvoreBinariaPesquisa.Comparador;
import ArvoreBinariaPesquisa.no;

public class HeapArray<t> implements FilaI<t>{
    private t[] arr;
    private int tam = 2;
    private int c=0;
    private int index;
    
    private Comparador<t> comp;

    public HeapArray(t value) {
        no<t> root = new no<t>(value);
        this.arr = (t[]) new Object[this.tam];
        arr[this.tam-1] = root.getValue(); 
        index = this.tam - 1;
        this.c = index;
        this.comp = new Comparador<t>() {

            @Override
            public int compare(no<t> no1, no<t> no2) {
                // TODO Auto-generated method stub
                return (int)no1.getValue() - (int)no2.getValue();
            }

            @Override
            public int compareT(int no1, int no2) {
                // TODO Auto-generated method stub
                return no1 - no2;
            }
            
        };
    }
    
    @Override
    public void insert(t chave, no<t> valor) {
        // TODO Auto-generated method stub
        valor.setValue(chave);
        if(2*c >= this.arr.length){
            int k = this.tam;
            this.tam *=2;
            t[] novo = (t[]) new Object[this.tam];
            for (int i = 1; i < k; i++) {
                novo[i] = arr[i];
                index = i;
            }
            arr = novo;
        }
        // if(this.comp.compareT(index, c)){

        // }
        if(arr[2*c] == null){
            arr[2*c] = valor.getValue();
            index=2*c;
        }else{
            arr[2*c + 1] = valor.getValue();
            index = 2*c+1;
            c++; 
        }
    }

    public void upHeap(){
        for (int i = 1; i < arr.length-1; i++) {
            int in = i;
            for (int j = i+1; j < arr.length; j++) {
                int p = this.comp.compareT((int)arr[in], (int)arr[j]);
                if(p>0){
                   in=j;
                }
            }
            if(in!=i){
                t aux = arr[i];
                arr[i] = arr[in];
                arr[in] = aux; 
            } 
        }
    }

    public void DownHeap(){
        this.upHeap(); int c=1;
        t[] dnovo = (t[]) new Object[arr.length];
        for (int i = arr.length-1; i > 0; i--) {
            dnovo[c++] = arr[i];
        }
        arr = dnovo;
    }
    
    public void mostrar(){
        for (int i = 1; i < this.arr.length; i++) {
                System.out.print(arr[i] + " "); 
        }
        System.out.println();
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

    public int altura(no<t> node){
        int height = 1;
        for (int i = 1; i < arr.length; i*=2) {
           if(arr[i] != null){
               height += 1;
            }
        } 
        return height;
    }  
    
    public int getIndex() {
        return index;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
}
