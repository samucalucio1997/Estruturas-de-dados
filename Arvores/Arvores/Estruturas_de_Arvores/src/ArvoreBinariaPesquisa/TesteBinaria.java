package ArvoreBinariaPesquisa;

public class TesteBinaria {
    public static void main(String[] args) {
        no<Integer> node1 = new no<Integer>(15);
        no<Integer> node2 = new no<Integer>(6);
        no<Integer> node3 = new no<Integer>(9);
        no<Integer> node4 = new no<Integer>(2);
        no<Integer> node5 = new no<Integer>(45);
        no<Integer> node6 = new no<Integer>(25);
        no<Integer> node7 = new no<Integer>(7);
        no<Integer> node8 = new no<Integer>(8);
        no<Integer> node9 = new no<Integer>(13);
        no<Integer> node10 = new no<Integer>(12);
        no<Integer> node11 = new no<Integer>(11);
        no<Integer> node12 = new no<Integer>(14);
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
