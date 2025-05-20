package utils;

import ArvoreBinariaPesquisa.No;
import RubroNegra.Cor;
import RubroNegra.NoRN;

public class MapperNo {
    public static <T> void toNo(NoRN<T> norn, No<T> node) {
        try {
            node.setFather((No) norn.getFather());
            node.setLeftChild((No) norn.getLeftChild());
            node.setRightChild((No) norn.getRightChild());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static <T> void toNoRN(No<T> node, NoRN<T> norn) {// deve ser usado na Inclusão
        try {
            norn.setFather(node);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static <T> NoRN<T> instanciaParaNullRB() {
        final var noNull = new NoRN<T>(null);
        noNull.setCor(Cor.NEGRO);
        return noNull;
    }
}
