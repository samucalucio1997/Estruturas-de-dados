package FilaPrioridade;

import ArvoreBinariaPesquisa.no;

public class TesteFilaPrioridadeNode {
    public static void main(String[] args) {
        HeapNo<Integer> fila = new HeapNo<>(new no<Integer>(15));
        /*
                    15 
              12          16
          10      9    22<-ultimo
         */
        no<Integer> n1 = new no<>(12);
        no<Integer> n2 = new no<>(16);
        no<Integer> n3 = new no<>(10);
        no<Integer> n4 = new no<>(9);
        no<Integer> n5 = new no<>(22);
        fila.insert(45, n1);
        fila.insert(45, n2);
        fila.insert(45, n3);
        fila.insert(45, n4);
        fila.insert(47, n5);
        System.out.println(fila.getUltim_node().getFather().getValue());
        System.out.println(fila.getUltim_node().getFather().getLeftChild().getValue());
        
    }
}
