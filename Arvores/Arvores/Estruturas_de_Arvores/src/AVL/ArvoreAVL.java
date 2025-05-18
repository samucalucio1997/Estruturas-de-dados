package AVL;

import java.util.Optional;

import ArvoreBinariaPesquisa.ArvoreBinP;
import ArvoreBinariaPesquisa.No;
import utils.MapperNo;

public class ArvoreAVL<t extends Object> extends ArvoreBinP<t> {

    public ArvoreAVL(No<t> root) {
        super(root);
        // TODO Auto-generated constructor stub
    }

    public No<t> incluirNo(t key) {
        // final var noInserido = new No<>(key);
        // MapperNo.toNo(this.incluir(key), noInserido);
        final var noIncluso = this.incluir(key);
        atualizadorFBInsercao(noIncluso, 0);
        return noIncluso;
    }

    public t removerNo(t key) {
        final var pivoRotacao = this.pesquisar(getRaiz(), key);
        No<t> curNo = sucessorRemocao(pivoRotacao);// mudar para pegar o sucessor ao inves do pai caso o no tiver 2
                                                   // filhos
        final var isLeftChild = curNo != null && curNo.getLeftChild() == pivoRotacao;
        final var Noremovido = this.remover(key);

        atualizarFBRemocao(Noremovido, isLeftChild);
        return Noremovido.getValue();
    }

    private void atualizarFBRemocao(No<t> pai, boolean isLeftChild) {
        while (pai != null) {
            if (isLeftChild) {
                pai.setFB(pai.getFB() - 1);
            } else {
                pai.setFB(pai.getFB() + 1);
            }

            if (pai.getFB() == -2) {
                casoRotacaoEsquerda(pai);
                pai = pai.getFather();
            }

            if (pai.getFB() == 2) {
                casoRotacaoDireita(pai);
                pai = pai.getFather();
            }

            if (pai.getFB() != 0) {
                break;
            }

            final var paiAntigo = pai;
            pai = pai.getFather();
            isLeftChild = pai != null && pai.getLeftChild() == paiAntigo;
        }
    }

    private No<t> sucessorRemocao(No<t> node) {
        if (node.getLeftChild() != null && node.getRightChild() != null) {
            No<t> curNo = node.getRightChild();
            while (curNo.getLeftChild() != null) {
                curNo = curNo.getLeftChild();
            }
            return curNo;
        } else {
            return node.getFather();
        }
    }

    private void atualizadorFBInsercao(No<t> pai, int balanceadorInsert) {
        if (pai == null) {
            return;
        }
        final var valorAtualizado = pai.getFB() + balanceadorInsert;
        pai.setFB(valorAtualizado);

        while (pai.getFather() != null) {
            final var paiAntigo = pai;
            pai = pai.getFather();

            final var filhoEsquerdo = Optional.ofNullable(pai.getLeftChild())
                    .map(No::getValue).orElse(null);

            if (filhoEsquerdo == paiAntigo.getValue()) {
                pai.setFB(pai.getFB() + 1);
            } else {
                pai.setFB(pai.getFB() - 1);
            }

            if (pai.getFB() == 0) {
                break;
            }

            if (pai.getFB() == -2) {
                casoRotacaoEsquerda(pai);
                break;
            }

            if (pai.getFB() == 2) {
                casoRotacaoDireita(pai);
                break;
            }
        }
    }

    private void casoRotacaoEsquerda(No<t> node) {
        final var leftNode = Optional.ofNullable(node.getRightChild())
                .map(No::getFB)
                .orElse(0); // mesma coisa de node.getRightChild() != null ? node.get
        final var isRotacaoSimples = leftNode <= 0 && node.getFB() <= 0;

        if (isRotacaoSimples) {
            rotacaoSimplesEsquerda(node);
        } else {
            rotacaoDuplaEsquerda(node);
        }
    }

    private void casoRotacaoDireita(No<t> node) {
        final var rightNode = Optional.ofNullable(node.getLeftChild())
                .map(No::getFB)
                .orElse(0);
        final var isRotacaoSimples = rightNode >= 0 && node.getFB() >= 0;

        if (isRotacaoSimples) {
            rotacaoSimplesDireita(node);
        } else {
            rotacaoDuplaDireita(node);
        }
    }

    // TODO: Atualizar os FB's de cada nó mexido
    private void rotacaoSimplesEsquerda(No<t> node) { // node = B, novaRaizSub = A
        final var novoRaizSub = node.getRightChild();

        if (novoRaizSub == null)
            return; // proteção extra

        // Atualizar a ligação do pai de 'node'
        novoRaizSub.setFather(node.getFather());

        if (node.getFather() == null) {
            setRaiz(novoRaizSub); // Se 'node' era raiz, agora a raiz é 'novoRaizSub'
        } else if (node.getFather().getLeftChild() == node) {
            node.getFather().setLeftChild(novoRaizSub);
        } else {
            node.getFather().setRightChild(novoRaizSub);
        }

        // Atualizar o filho esquerdo de 'novoRaizSub'
        node.setRightChild(novoRaizSub.getLeftChild());
        if (novoRaizSub.getLeftChild() != null) {
            novoRaizSub.getLeftChild().setFather(node);
        }

        // Conectar 'node' como filho esquerdo de 'novoRaizSub'
        novoRaizSub.setLeftChild(node);
        node.setFather(novoRaizSub);

        // Atualizar fatores de balanceamento
        final var novoFbB = node.getFB() + 1 - Math.min(novoRaizSub.getFB(), 0);
        final var novoFbA = novoRaizSub.getFB() + 1 + Math.max(novoFbB, 0);

        node.setFB(novoFbB);
        novoRaizSub.setFB(novoFbA);
    }

    private void rotacaoDuplaEsquerda(No<t> node) {
        // faz primeiro uma rotação simples a direita com a subarvore a direita do no
        // com FB = -2
        rotacaoSimplesDireita(node.getRightChild());
        rotacaoSimplesEsquerda(node);
    }

    private void rotacaoSimplesDireita(No<t> node) {// noode = B, novaRazSub = A
        final var novoRaizSub = node.getLeftChild();

        if (novoRaizSub == null)
            return; // proteção extra

        // Atualizar a ligação do pai de 'node'
        novoRaizSub.setFather(node.getFather());

        if (node.getFather() == null) {
            setRaiz(novoRaizSub); // Se 'node' era raiz, agora novoRaizSub é a nova raiz
        } else if (node.getFather().getLeftChild() == node) {
            node.getFather().setLeftChild(novoRaizSub);
        } else {
            node.getFather().setRightChild(novoRaizSub);
        }

        // Atualizar o filho direito de 'novoRaizSub'
        node.setLeftChild(novoRaizSub.getRightChild());
        if (novoRaizSub.getRightChild() != null) {
            novoRaizSub.getRightChild().setFather(node);
        }

        // Conectar 'node' como filho direito de 'novoRaizSub'
        novoRaizSub.setRightChild(node);
        node.setFather(novoRaizSub);

        // Atualizar fatores de balanceamento
        final var novoFbB = node.getFB() - 1 - Math.max(novoRaizSub.getFB(), 0);
        final var novoFbA = novoRaizSub.getFB() - 1 + Math.min(novoFbB, 0);

        node.setFB(novoFbB);
        novoRaizSub.setFB(novoFbA);
    }

    private void rotacaoDuplaDireita(No<t> node) {
        rotacaoSimplesEsquerda(node.getLeftChild());
        rotacaoSimplesDireita(node);
    }
}
