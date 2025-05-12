package RubroNegra;

import java.util.Optional;

import ArvoreBinariaPesquisa.ArvoreBinP;

public class ArvoreRubroNegra<T extends Object> extends ArvoreBinP<T> {

    private ArvoreRubroNegra(NoRN<T> root) {
        super(root);
        root.setCor(Cor.NEGRO);
    }

    public NoRN<T> inserirRB(NoRN<T> node) {
        final var noInserido = this.incluir((T) node);
        verificarCaso(node);
        return null;
    }

    private void verificarCaso(NoRN<T> node) {
        final var corPaiNo = Optional.ofNullable(node.getFather())
                .map(NoRN::getCor).orElse(Cor.NEGRO);
    }

}
