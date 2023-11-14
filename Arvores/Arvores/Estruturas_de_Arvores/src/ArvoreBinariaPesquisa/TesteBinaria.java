package ArvoreBinariaPesquisa;

public class TesteBinaria {
    public static void main(String[] args) {
        no<Integer> node1 = new no<Integer>(15);
        no<Integer> node2 = new no<Integer>(6);
        no<Integer> node3 = new no<Integer>(9);
        no<Integer> node4 = new no<Integer>(2);
        no<Integer> node5 = new no<Integer>(45);
        no<Integer> node6 = new no<Integer>(25);
        ArvoreBinP<Integer> ar = new ArvoreBinP<>(node1);
        System.out.println(ar.incluir(node2.getValue()).getValue());
        System.out.println(ar.incluir(node3.getValue()).getValue());
        System.out.println(ar.incluir(node4.getValue()).getValue());
        System.out.println(ar.incluir(node5.getValue()).getValue());
        System.out.println(ar.incluir(node6.getValue()).getValue());
        ar.posOrdem(node1);
        ////////////////////////////
        System.out.println(ar.pesquisar(ar.getRaiz(), 45).getValue());
    }
}
