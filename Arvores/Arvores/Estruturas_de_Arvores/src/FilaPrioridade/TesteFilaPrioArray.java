package FilaPrioridade;

import ArvoreBinariaPesquisa.no;

public class TesteFilaPrioArray {
    public static void main(String[] args) {
        
        HeapArray<Integer> fila = new HeapArray<Integer>(4);
        fila.insert(6, new no<Integer>(null));
        fila.insert(14, new no<Integer>(null));
        fila.insert(11, new no<Integer>(null));
        fila.insert(5, new no<Integer>(null));
        fila.insert(2, new no<Integer>(null));
        fila.insert(1, new no<Integer>(null));
        System.out.println(fila.altura(null));
        fila.mostrar();
        fila.DownHeap();
        fila.mostrar();
        fila.upHeap();
        fila.mostrar();
    }
}
