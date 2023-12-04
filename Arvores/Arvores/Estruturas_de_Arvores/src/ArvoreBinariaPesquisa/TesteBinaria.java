package ArvoreBinariaPesquisa;

public class TesteBinaria {
    public static void main(String[] args) {
        No<Integer> node1 = new No<Integer>(15);
        No<Integer> node2 = new No<Integer>(6);
        No<Integer> node3 = new No<Integer>(9);
        No<Integer> node4 = new No<Integer>(2);
        No<Integer> node5 = new No<Integer>(45);
        No<Integer> node6 = new No<Integer>(25);
        No<Integer> node7 = new No<Integer>(7);
        No<Integer> node8 = new No<Integer>(8);
        No<Integer> node9 = new No<Integer>(13);
        No<Integer> node10 = new No<Integer>(12);
        No<Integer> node11 = new No<Integer>(11);
        No<Integer> node12 = new No<Integer>(14);
        ArvoreBinP<Integer> ar = new ArvoreBinP<>(node1);
        node2 = ar.incluir(node2.getValue());
        node3 = ar.incluir(node3.getValue());
        node4 = ar.incluir(node4.getValue());
        node5 = ar.incluir(node5.getValue());
        node6 = ar.incluir(node6.getValue());
        node7 = ar.incluir(node7.getValue());
        node8 = ar.incluir(node8.getValue());
        node9 = ar.incluir(node9.getValue());
        node10 = ar.incluir(node10.getValue());
        node11 = ar.incluir(node11.getValue());
        node12 = ar.incluir(node12.getValue());
        System.out.println(ar.altura(node1));
        System.out.println();
        System.out.println();
        ar.remover(6);
        ar.remover(13);
        System.out.println(node10.getFather().getValue());
        // ar.emOrdem(node1);
        // ar.preOrdem(node1);
        ar.mostrar();
        System.out.println();
        // System.out.println(node3.getValue());
        // System.out.println(node2.getRightChild().getLeftChild().getValue());
        ////////////////////////////
        System.out.println();
        System.out.println(ar.profundidade(node5));
    }
}
