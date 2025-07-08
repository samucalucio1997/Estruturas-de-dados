package RubroNegra;

import java.util.Optional;

import javax.management.RuntimeErrorException;

import ArvoreBinariaPesquisa.ArvoreBinP;
import ArvoreBinariaPesquisa.Comparador;
import ArvoreBinariaPesquisa.No;
import utils.MapperNo;
import utils.ValidatorsUtil;

public class ArvoreRubroNegra<T extends Object> extends ArvoreBinP<T> {

    private Comparador<T> comp;

    public ArvoreRubroNegra(NoRN<T> root) {
        super(root);
        this.comp = new Comparador<T>() {

            @Override
            public int compare(No<T> no1, No<T> no2) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'compare'");
            }

            @Override
            public int compareT(int no1, int no2) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'compareT'");
            }

            @Override
            public int compareRN(NoRN<T> norn1, NoRN<T> norn2) {
                if (norn1.getValue().equals(norn2.getValue())) {
                    throw new RuntimeErrorException(new Error("Aquele erro"));
                }

                int p1 = (Integer) norn1.getValue();
                int p2 = (Integer) norn2.getValue();
                return p1 - p2;
            }

        };
        if (root != null) {
            root.setCor(Cor.NEGRO);
        }
    }

    public NoRN<T> inserirRB(NoRN<T> node) {
        NoRN<T> newNo = new NoRN<>(node.getValue());
        No<T> curNo = getRaiz();
        if (ValidatorsUtil.isEmpty(curNo)) {
            this.setRaiz(newNo);
            return newNo;
        }
        No<T> pai = pesquisar(curNo, node.getValue());

        int comp = this.getComparador().compare(newNo, pai);
        if (comp > 0) {
            pai.setRightChild(newNo);
        } else {
            pai.setLeftChild(newNo);
        }

        newNo.setFather((NoRN<T>) pai); // já que pai pode ser NoRN também
        this.incrementaElementos();
        verificarCaso(newNo);
        return newNo;
    }

    private void verificarCaso(NoRN<T> node) {// inserção
        final var pai = node.getFather();

        if (ValidatorsUtil.isEmpty(pai))
            return;
        if (pai.getCor() == Cor.NEGRO) {// pai é negro nada precisa ser feito caso 1
            return;
        } else {
            final var avoNO = Optional.ofNullable(pai.getFather()).orElse(null);
            final var tioNo = pai == Optional.ofNullable(avoNO).map(NoRN::getLeftChild).orElse(null)
                    ? Optional.ofNullable(avoNO).map(NoRN::getRightChild).orElse(MapperNo.instanciaParaNullRB())
                    : Optional.ofNullable(avoNO).map(NoRN::getLeftChild).orElse(MapperNo.instanciaParaNullRB());

            if (tioNo != null && pai.getCor() == Cor.RUBRO && tioNo.getCor() == Cor.RUBRO) {// pai e tio rubros e avo negro caso 2
                caso2Insercao(node);
            } else {
                if (pai.getCor() == Cor.RUBRO && tioNo.getCor() == Cor.NEGRO) {// casos 3
                    caso3Insercao(node);
                }
            }
        }
    }

    private void caso2Insercao(NoRN<T> node) {
        if (node.getFather() == null)
            return;

        final var pai = node.getFather();
        final var avo = pai.getFather();
        if (avo == null)
            return;

        NoRN<T> tio;
        if (pai == avo.getLeftChild()) {
            tio = (NoRN<T>) avo.getRightChild();
        } else {
            tio = (NoRN<T>) avo.getLeftChild();
        }

        if (tio != null && tio.getCor() == Cor.RUBRO) {
            pai.setCor(Cor.NEGRO);
            avo.setCor(avo == getRaiz() ? Cor.NEGRO : Cor.RUBRO);
            tio.setCor(Cor.NEGRO);

            verificarCaso(avo); // chamada recursiva
        }
    }

    private void caso3Insercao(NoRN<T> node) {
        final var paiNo = node.getFather();
        final var avoNo = Optional.ofNullable(paiNo.getFather()).orElse(null);
        final var isCaso3a = avoNo.getLeftChild() == paiNo && paiNo.getLeftChild() == node;// rotação direita simples
        final var isCaso3b = avoNo.getRightChild() == paiNo && paiNo.getRightChild() == node;// rotação esquerda simples
        final var isCaso3c = avoNo.getRightChild() == paiNo && paiNo.getLeftChild() == node;// rotação esquerda dupla
        final var isCaso3d = avoNo.getLeftChild() == paiNo && paiNo.getRightChild() == node;// rotação direita dupla

        if (isCaso3a) {
            this.rotacaoSimplesDireita(avoNo);
            avoNo.setCor(Cor.RUBRO);
            paiNo.setCor(Cor.NEGRO);
        }

        if (isCaso3b) {
            this.rotacaoSimplesEsquerda(avoNo);
            paiNo.setCor(Cor.NEGRO);
            avoNo.setCor(Cor.RUBRO);
        }

        if (isCaso3c) {
            rotacaoDuplaEsquerda(avoNo);
            node.setCor(Cor.RUBRO);
            avoNo.setCor(Cor.RUBRO);
        }

        if (isCaso3d) {
            rotacaoDuplaDireita(avoNo);
            node.setCor(Cor.NEGRO);
            avoNo.setCor(Cor.RUBRO);
        }
    }

    private void rotacaoSimplesEsquerda(NoRN<T> avo) {
        final var novoRaizSub = avo.getRightChild();

        novoRaizSub.setFather(avo.getFather());

        if (avo.getFather() == null) {// use o ValidatorsUtils
            setRaiz(novoRaizSub);
        } else {
            if (avo.getFather().getLeftChild() == avo) {// refatorar depois
                avo.getFather().setLeftChild(novoRaizSub);
            } else {
                avo.getFather().setRightChild(novoRaizSub);
            }
        }

        avo.setRightChild(novoRaizSub.getLeftChild());
        if (novoRaizSub.getLeftChild() != null) {// use o ValidatorsUtils
            novoRaizSub.getLeftChild().setFather(avo);
        }

        novoRaizSub.setLeftChild(avo);
        avo.setFather(novoRaizSub);
    }

    private void rotacaoSimplesDireita(NoRN<T> avo) {
        final var novaRaizSub = avo.getLeftChild();

        novaRaizSub.setFather(avo.getFather());

        if (avo.getFather() == null) {// use o ValidatorsUtils
            setRaiz (novaRaizSub);
        } else {
            if (avo.getFather().getLeftChild() == avo) {
                avo.getFather().setLeftChild(novaRaizSub);
            } else {
                avo.getFather().setRightChild(novaRaizSub);
            }
        }

        avo.setLeftChild(novaRaizSub.getRightChild());
        if (novaRaizSub.getRightChild() != null) {// use o ValidatorsUtils
            novaRaizSub.getRightChild().setFather(avo);
        }

        novaRaizSub.setRightChild(avo);
        avo.setFather(novaRaizSub);
    }

    private void rotacaoDuplaEsquerda(NoRN<T> avo) {
        rotacaoSimplesDireita(avo.getRightChild());
        rotacaoSimplesEsquerda(avo);
    }

    private void rotacaoDuplaDireita(NoRN<T> avo) {
        rotacaoSimplesEsquerda(avo.getLeftChild());
        rotacaoSimplesDireita(avo);
    }

    public NoRN<T> removerRB(T key) {
        // TODO Auto-generated method stub
        NoRN<T> pai;
        NoRN<T> atual = pesquisarRN((NoRN<T>) getRaiz(), key);
        pai = atual.getFather();
        if (atual.getLeftChild() == null && atual.getRightChild() == null) {
            final var isLeftChild = ValidatorsUtil.isLeftChild(pai, atual);    
            final var sucessor = remocaoCaso(1, atual);
            verificaSituacaoRemover(atual, sucessor,isLeftChild);
            return sucessor;
        }
        if (atual.getLeftChild() == null ^ atual.getRightChild() == null) {
            final var sucessor = remocaoCaso(2, atual);
            verificaSituacaoRemover(atual, sucessor, false);
            return sucessor;
        }
        if (atual.getLeftChild() != null && atual.getRightChild() != null) {
            final var sucessor = remocaoCaso(0, atual);
            verificaSituacaoRemover(atual, sucessor,false);
            return sucessor;
        }

        return pai;
    }

    private void verificaSituacaoRemover(NoRN<T> removido, NoRN<T> sucessor, boolean isLeftChild) {
        if (removido.getCor() == Cor.RUBRO && sucessor.getCor() == Cor.RUBRO) {// situação 1
            return;
        } else {
            if (removido.getCor() == Cor.NEGRO && sucessor.getCor() == Cor.RUBRO) {// situação 2
                sucessor.setCor(Cor.NEGRO);
                return;
            }

            if (removido.getCor() == Cor.NEGRO && sucessor.getCor() == Cor.NEGRO) {// situação 3
                verificarCasoRemocao(sucessor, isLeftChild);
                return;
            }

            if (removido.getCor() == Cor.RUBRO && sucessor.getCor() == Cor.NEGRO) {// situação 4
                sucessor.getFather().setCor(Cor.RUBRO);
                verificarCasoRemocao(sucessor, isLeftChild);
                return;
            }
        }
    }

    private void verificarCasoRemocao(NoRN<T> sucessor, boolean isLeftChild) {
        final var pai = Optional.ofNullable(sucessor).map(NoRN::getFather).orElse(MapperNo.instanciaParaNullRB());
        final var irmao = ValidatorsUtil.isLeftChild(pai, sucessor) || isLeftChild ? pai.getRightChild()
                : Optional.ofNullable(pai).map(NoRN::getLeftChild).orElse(MapperNo.instanciaParaNullRB());
        final var sobrinhoInterno = ValidatorsUtil.isLeftChild(irmao.getFather(), irmao) ? Optional.ofNullable(irmao).map(NoRN::getRightChild).orElse(MapperNo.instanciaParaNullRB())
                : Optional.ofNullable(irmao).map(NoRN::getLeftChild).orElse(MapperNo.instanciaParaNullRB());
        final var sobrinhoExterno = ValidatorsUtil.isLeftChild(irmao, sobrinhoInterno) ? Optional.ofNullable(irmao).map(NoRN::getRightChild).orElse(MapperNo.instanciaParaNullRB())
                : Optional.ofNullable(irmao).map(NoRN::getLeftChild).orElse(MapperNo.instanciaParaNullRB());

        if (irmao.getCor() == Cor.RUBRO && pai.getCor() == Cor.NEGRO && sobrinhoInterno.getCor() == Cor.NEGRO) {// caso1
            if (ValidatorsUtil.isLeftChild(sucessor.getFather(), sucessor)) {
                rotacaoSimplesEsquerda(sucessor.getFather());
            } else {
                rotacaoSimplesDireita(sucessor.getFather());
            }
            pai.setCor(Cor.RUBRO);
            irmao.setCor(Cor.NEGRO);
            caso2b(pai, ValidatorsUtil.isLeftChild(pai, irmao));
            return;
        }

        if (irmao.getCor() == Cor.NEGRO && pai.getCor() == Cor.NEGRO && sobrinhoInterno.getCor() == Cor.NEGRO && sobrinhoExterno.getCor() == Cor.NEGRO) {// caso2a
            irmao.setCor(Cor.RUBRO);
            if (ValidatorsUtil.isNotEmpty(pai.getFather())) {
                verificarCasoRemocao(pai.getFather(),false);
            }
            return;
        }

        if (pai.getCor() == Cor.RUBRO && irmao.getCor() == Cor.NEGRO && sobrinhoInterno.getCor() == Cor.NEGRO && sobrinhoExterno.getCor() == Cor.NEGRO) {// caso2b
            irmao.setCor(Cor.RUBRO);
            pai.setCor(Cor.NEGRO);
            if (ValidatorsUtil.isNotEmpty(pai.getFather())) {
                verificarCasoRemocao(pai.getFather(), false);
            }
            return;
        }

        if (sobrinhoInterno.getCor() == Cor.RUBRO && sobrinhoExterno.getCor() == Cor.NEGRO) {// caso3
              if (ValidatorsUtil.isLeftChild(irmao, sobrinhoInterno)) {
                rotacaoSimplesDireita(irmao);
            } else {
                rotacaoSimplesEsquerda(irmao);
            } 
            irmao.setCor(Cor.RUBRO);
            sobrinhoInterno.setCor(Cor.NEGRO);
            verificarCasoRemocao(sucessor,isLeftChild);
            return;
        }

        if (sobrinhoExterno.getCor() == Cor.RUBRO) {// caso4
            if (ValidatorsUtil.isLeftChild(irmao, sobrinhoExterno)) {// rotação simples Direita
                rotacaoSimplesDireita(sucessor.getFather());
            } else {
                rotacaoSimplesEsquerda(sucessor.getFather());
            }
            final var corPai = pai.getCor();
            pai.setCor(Cor.NEGRO);
            irmao.setCor(corPai);
            sobrinhoExterno.setCor(Cor.NEGRO);
            return;
        }

    }

    public boolean isRubroNegra(){
        final var noRaizRN = pesquisarRN((NoRN) getRaiz(), getRaiz().getValue());
        final var nosPretosPorCaminho = this.pretosCaminho(noRaizRN);

        return contaPretos(noRaizRN) != -1
        && noRaizRN.getCor() == Cor.NEGRO 
        && !isRubroFilhoRubro(noRaizRN);
    }

    private int pretosCaminho(NoRN<T> raiz) {//pega um caminho mais fácil
        int sum = 0;
        while (raiz != null) {
            if (raiz.getCor() == Cor.NEGRO) {
                sum++;
            }
            raiz = raiz.getLeftChild();
        }
        return sum;
    }

    private int contaPretos(NoRN<T> node) {
        if (node == null) {
            return 0;
        }

        int qtdNegroDireita = contaPretos(node.getRightChild());

        if (qtdNegroDireita == -1) {
            return -1;            
        }

        int qtdNegrosEsquerda = contaPretos(node.getLeftChild());

        if (qtdNegrosEsquerda == -1) {
            return -1;
        }

        if (qtdNegroDireita != qtdNegrosEsquerda) {
            return -1;
        }

        final var pai = Optional.ofNullable(node.getFather())
                .map(NoRN::getCor).orElse(Cor.NEGRO);

        if (node.getCor() == Cor.RUBRO && pai == Cor.RUBRO) {
            return -1;
        }

        return qtdNegrosEsquerda + (node.getCor() == Cor.NEGRO ? 1 : 0);
    }

    public boolean isRubroFilhoRubro(NoRN<T> raiNoRN){
        if (!raiNoRN.Isinternal()) {
            return raiNoRN.getCor() == Cor.RUBRO && raiNoRN.getFather().getCor() == Cor.RUBRO;
        }

        return isRubroFilhoRubro(raiNoRN.getLeftChild()) && isRubroFilhoRubro(raiNoRN.getRightChild());
    }

    private void caso2b(NoRN<T> node, boolean isLeftChild) {
        NoRN<T> filho;

        if (isLeftChild) {
            filho = node.getLeftChild();
        } else {
            filho = node.getRightChild();
        }
        node.setCor(Cor.NEGRO);
        filho.setCor(Cor.RUBRO);
    }

    @Override
    public void mostrar() {
        int alturaComp = this.altura(getRaiz());
        String[][] arr = new String[alturaComp + 1][(int) Math.pow(2, alturaComp + 1)];
        printTreeRN((NoRN) getRaiz(), 0, (int) Math.pow(2, alturaComp + 1) / 2, arr);

        for (int i = 0; i < alturaComp + 1; i++) {
            for (int j = 0; j < (int) Math.pow(2, alturaComp + 1); j++) {
                if (arr[i][j] != null) {
                    System.out.printf("%3s", arr[i][j]);
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    private void printTreeRN(NoRN<T> node, int linha, int col, String[][] arr) {
        if (node == null) {
            return;
        }

        arr[linha][col] = (T) node.getValue() + "[" + node.getCor().getDescricao() + "]";

        int colSkip = (int) Math.pow(2, arr.length - linha - 2);

        if (node.getLeftChild() != null) {
            printTreeRN(node.getLeftChild(), linha + 1, col - colSkip, arr);
        }

        if (node.getRightChild() != null) {
            printTreeRN(node.getRightChild(), linha + 1, col + colSkip, arr);
        }
    }

    public NoRN<T> pesquisarRN(NoRN<T> no, T key) {
        if (!no.Isinternal()) {
            return no;
        }

        if (no.getValue() == key) {
            return no;
        }

        int coefComparacao = this.getComp().compareRN(no, new NoRN<T>(key));
        if (coefComparacao > 0) {
            if (no.getLeftChild() == null) {
                return no;
            }
            return pesquisarRN(no.getLeftChild(), key);
        } else {
            if (no.getRightChild() == null) {
                return no;
            }
            return pesquisarRN(no.getRightChild(), key);
        }
    }

    private NoRN<T> remocaoCaso(int casoRemocao, NoRN<T> node) {
        NoRN<T> pai = node.getFather();
        switch (casoRemocao) {
            case 1:
                if (pai == null) {
                    setRaiz(null);// Remover a raiz
                } else {
                    if (node == pai.getLeftChild()) {
                        pai.setLeftChild(null);
                    } else {
                        pai.setRightChild(null);
                    }
                }
                return node;
            case 2:
                final var filho = (node.getLeftChild() != null) ? node.getLeftChild() : node.getRightChild();
                if (pai == null) {// pro caso do do pai ser o root
                    setRaiz(filho);// O filho se torna a nova raiz
                } else {
                    if (node == pai.getLeftChild()) {
                        pai.setLeftChild(filho);
                    } else {
                        pai.setRightChild(filho);
                    }
                }
                filho.setFather(pai);
                return node;
            default:
                NoRN<T> sucessor = node.getRightChild();
                while (sucessor.getLeftChild() != null) {
                    sucessor = sucessor.getLeftChild();
                }
                final var valorSucessor = sucessor.getValue();
                if (sucessor.getRightChild() != null) {//chama situação 3
                    sucessor.getRightChild().setCor(Cor.NEGRO);
                    sucessor = sucessor.getRightChild();
                    node.setCor(Cor.NEGRO);
                    verificaSituacaoRemover(node, sucessor, false);
                }
                else {
                    remover(valorSucessor);
                }
                node.setValue(valorSucessor);
                return sucessor;// a referencia desse nó não é nula
        }
    }

    public Comparador<T> getComp() {
        return comp;
    }

    public void setComp(Comparador<T> comp) {
        this.comp = comp;
    }

}