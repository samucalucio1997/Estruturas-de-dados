package FilaPrioridade;

import ArvoreBinariaPesquisa.no;

public class TesteFilaPrioArray {
    public static void main(String[] args) {
        
        HeapArray<Integer> fila = new HeapArray<Integer>(4);
        fila.insert(new no<Integer>(6));
        fila.insert( new no<Integer>(14));
        fila.insert( new no<Integer>(11));
        fila.insert( new no<Integer>(5));
        fila.insert(new no<Integer>(2));
        fila.insert(new no<Integer>(1));
        System.out.println(fila.altura(null));
        fila.removeMin();
        fila.mostrar();
        System.out.println(fila.min());
    }
}
