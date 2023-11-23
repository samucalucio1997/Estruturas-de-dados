package FilaPrioridade;

import ArvoreBinariaPesquisa.Comparador;
import ArvoreBinariaPesquisa.no;

public class FilaPrioridadeArray<t> implements FilaI<t>{
    private t[] arr;
    private int tam = 2;
    private int index;
    private Comparador<t> comp;

    public FilaPrioridadeArray(t value) {
        no<t> root = new no<t>(value);
        this.arr = (t[]) new Object[this.tam];
        arr[this.tam-1] = root.getValue(); 
        index = this.tam - 1;
        this.comp = new Comparador<t>() {

            @Override
            public int compare(no<t> no1, no<t> no2) {
                // TODO Auto-generated method stub
                return (int)no1.getValue() - (int)no2.getValue();
            }

            @Override
            public int compareT(int no1, int no2) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'compareT'");
            }
            
        };
    }

    @Override
    public void insert(t chave, no<t> valor) {
        // TODO Auto-generated method stub
        valor.setValue(chave);
        if(2*index >= this.arr.length){
            int k = this.tam;
            this.tam = 2*index+1;
            t[] novo = (t[]) new Object[this.tam];
            for (int i = 1; i < k; i++) {
                novo[i] = arr[i];
                index = i;
            }
            arr = novo;
        }
        if(arr[2*index] == null){
            arr[2*index] = valor.getValue();
        }else{
            arr[2*index + 1] = valor.getValue(); 
        }
        index = arr[2*index]!=null&&arr[2*index]!=null?index*2+1:index;
    }

    public void upHeap(){
        for (int i = 1; i < arr.length; i++) {
                  
        }
    }
    
    public void mostrar(){
        for (int i = 1; i < arr.length; i++) {
            // if(arr[i]!=null){
                System.out.print("- "+arr[i]+"="+ i+" -"); 
            // }
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
    
}
