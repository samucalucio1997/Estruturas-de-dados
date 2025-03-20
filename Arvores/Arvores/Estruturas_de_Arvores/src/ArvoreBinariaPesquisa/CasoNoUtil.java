package ArvoreBinariaPesquisa;

public class CasoNoUtil<t extends Object> {

    private int getSituacao(No<t> node){
        // no a ser removido é um no folha: caso 1
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            return 1;
        }
        // no a ser removido tem apenas um filho
        if (node.getLeftChild() == null || node.getRightChild() == null) {
            return 2;
        }
        // no a ser removido tem dois filho
        if (node.getLeftChild() != null && node.getRightChild() != null) {
            return 3;
        }
        return 0;
    }


    private boolean isRoot(No<t> node){
       return node.getFather() == null;   
    }
}
