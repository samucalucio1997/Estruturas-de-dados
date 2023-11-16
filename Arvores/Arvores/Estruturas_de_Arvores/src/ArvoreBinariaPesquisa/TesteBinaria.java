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
        ArvoreBinP<Integer> ar = new ArvoreBinP<>(node1);
        node2 = ar.incluir(node2.getValue());
        node3 = ar.incluir(node3.getValue());
        node4 = ar.incluir(node4.getValue());
        node5 = ar.incluir(node5.getValue());
        node6 = ar.incluir(node6.getValue());
        node7 = ar.incluir(node7.getValue());
        System.out.println(node3.getFather());
        System.out.println();
        // ar.posOrdem(node1);
        System.out.println();
        ar.remover(6);
        ar.posOrdem(node1);
        System.out.println();
        System.out.println(node4.getRightChild().getValue());
        ////////////////////////////
        System.out.println();
        System.out.println(ar.profundidade(node5));
    }
}
