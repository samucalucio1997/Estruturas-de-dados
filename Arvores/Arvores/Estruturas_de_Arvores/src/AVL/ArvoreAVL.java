package AVL;

import java.util.Optional;

import ArvoreBinariaPesquisa.ArvoreBinP;
import ArvoreBinariaPesquisa.No;

public class ArvoreAVL<t extends Object> extends ArvoreBinP<t> {

    public ArvoreAVL(No<t> root) {
        super(root);
        //TODO Auto-generated constructor stub
    }

    public No<t> incluirNo(t key) {
        final var noIncluso = this.incluir(key);
        // final var rightChildNo = Optional.ofNullable(noIncluso.getFather())
        // .map(No::getLeftChild)
        // .map(No::getValue)
        // .orElse(null);
        // final var isInsereEsquerda = rightChildNo == noIncluso.getValue();

        // if (isInsereEsquerda) {
        //     this.atualizadorFBInsercao(noIncluso.getFather(), 1);
        // }else {
        //     this.atualizadorFBInsercao(noIncluso.getFather(), -1);
        // }
        atualizadorFBInsercao(noIncluso, 0);
        return noIncluso;
    }

    public t removerNo(t key) {
        final var Noremovido = this.remover(key);
        return Noremovido;
    }

    private void atualizadorFBInsercao(No<t> pai, int balanceadorInsert){
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
        }
    }

    private void casoRotacaoEsquerda(No<t> node){
        final var leftNode = Optional.ofNullable(node.getRightChild())
        .map(No::getFB)
        .orElse(null); // mesma coisa de node.getRightChild() != null ? node.get
        final var isRotacaoSimples = leftNode < 0 && node.getFB() < 0;

        if (isRotacaoSimples) {
            rotacaoSimplesEsquerda(node);
        }else{
            rotacaoDuplaEsquerda(node);
        }
    }

    //TODO: Atualizar os FB's de cada nó mexido
    private void rotacaoSimplesEsquerda(No<t> node) {
        if (node.getValue() == getRaiz().getValue()) {
            setRaiz(node.getRightChild());
        }
        final var novoRaizSub = node.getRightChild();
        node.setRightChild(null);
        novoRaizSub.setFather(node.getFather());
        // System.out.println(novoRaizSub.getLeftChild());
        
        if (novoRaizSub.getLeftChild() != null) {
            node.setRightChild(novoRaizSub.getLeftChild());
            novoRaizSub.getLeftChild().setFather(node);
        }
        novoRaizSub.setLeftChild(node); 
        
        node.setFather(novoRaizSub);
    }

    private void rotacaoDuplaEsquerda(No<t> node) {
        final var noRotacao1 = Optional.ofNullable(node.getRightChild())
        .map(No::getLeftChild).orElse(null);
        final var raizSub = noRotacao1.getFather();
        
        raizSub.setLeftChild(null);
        raizSub.setFather(noRotacao1);
        noRotacao1.setFather(node);
        noRotacao1.setRightChild(raizSub);
        node.setRightChild(noRotacao1);
        rotacaoSimplesEsquerda(node);
    }

    private void rotacaoSimplesDireita(No<t> node) {

    }

    
}
