package FilaPrioridade;

import ArvoreBinariaPesquisa.No;

public class TesteFilaPrioridadeNode {
    public static void main(String[] args) {
        /*
                                         22
                            12                           17              
                     10            9              16            15
                8          7  4        6      14       13    
        */
        HeapNo<Integer> fila = new HeapNo<>(new No<Integer>(15));
        No<Integer> n1 = new No<>(12);
        No<Integer> n2 = new No<>(16);
        No<Integer> n3 = new No<>(10);
        No<Integer> n4 = new No<>(9);
        No<Integer> n5 = new No<>(22);
        No<Integer> n6 = new No<>(17);
        No<Integer> n7 = new No<>(8);
        No<Integer> n8 = new No<>(7);
        No<Integer> n9 = new No<>(3);
        fila.insert(n1);
        fila.insert(n2);
        fila.insert(n3);
        fila.insert(n4);
        fila.insert(n5);
        fila.insert(n6);
        fila.insert(n7);
        fila.insert(n8);
        // System.out.println(fila.getRaiz().getValue());
        // System.out.println(fila.getRaiz().getLeftChild().getValue());
        // System.out.println(fila.getRaiz().getRightChild().getValue());
        System.out.println(fila.getUltim_node().getValue());
        System.out.println(fila.getUltim_node().getFather().getLeftChild().getValue());
        System.out.println(fila.getUltim_node().getFather().getRightChild().getValue());
        System.out.println();
        System.out.println(fila.getUltim_node().getValue());
        System.out.println();
        System.out.println(fila.min());
        fila.removeMin();
        fila.removeMin();
        System.out.println("-------------------------------------------");
        System.out.println(fila.min());
        System.out.println(fila.getUltim_node().getValue());
    }
}
