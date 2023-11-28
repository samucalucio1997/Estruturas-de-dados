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
        no<Integer> n6 = new no<>(17);
        no<Integer> n7 = new no<>(8);
        no<Integer> n8 = new no<>(7);
        fila.insert(45, n1);
        fila.insert(45, n2);
        fila.insert(45, n3);
        fila.insert(45, n4);
        fila.insert(47, n5);
        fila.insert(44, n6);
        fila.insert(44, n7);
        fila.insert(44, n8);
        // System.out.println(fila.getRaiz().getValue());
        // System.out.println(fila.getRaiz().getLeftChild().getValue());
        // System.out.println(fila.getRaiz().getRightChild().getValue());
        System.out.println(fila.getUltim_node().getValue());
        System.out.println(fila.getUltim_node().getFather().getLeftChild().getValue());
        System.out.println(fila.getUltim_node().getFather().getRightChild().getValue());
        System.out.println();
        fila.emOrdem(fila.getRaiz());
        System.out.println();
        fila.removeMin();//*7 */
        fila.emOrdem(fila.getRaiz());
        fila.removeMin();//*8 */
        System.out.println(fila.getUltim_node().getValue());
        System.out.println();
        fila.emOrdem(fila.getRaiz());
        fila.removeMin();//*16 */
        fila.removeMin();//*15 */
        System.out.println();
        fila.emOrdem(fila.getRaiz());
    }
}
