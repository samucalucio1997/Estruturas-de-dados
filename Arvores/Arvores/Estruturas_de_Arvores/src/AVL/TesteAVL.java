package AVL;

import java.util.ArrayList;
import java.util.Optional;

import ArvoreBinariaPesquisa.No;
import RubroNegra.ArvoreRubroNegra;
import RubroNegra.NoRN;

public class TesteAVL {
  public static void main(String[] args) {
    // final var avl = new ArvoreAVL<Integer>(new No<Integer>(32));
    // avl.incluirNo(31);
    // avl.incluirNo(35);
    // avl.incluirNo(33);
    // avl.incluirNo(36);
    // avl.incluirNo(38);

    // final var avl = new ArvoreAVL<Integer>(new No<Integer>(50));
    // avl.incluirNo(20);
    // avl.incluirNo(80);
    // avl.incluirNo(90);
    // avl.incluirNo(70);
    // avl.incluirNo(60);

    // final var avl = new ArvoreAVL<Integer>(new No<Integer>(50));
    // avl.incluirNo(20);
    // avl.incluirNo(90);
    // avl.incluirNo(30);
    // avl.incluirNo(10);
    // avl.incluirNo(5);

    // final var avl = new ArvoreAVL<Integer>(new No<Integer>(1));
    // avl.incluirNo(2);
    // avl.incluirNo(3);
    // avl.incluirNo(4);
    // avl.incluirNo(5);
    // avl.incluirNo(6);
    // avl.removerNo(2);

    final var avl = new ArvoreAVL<Integer>(new No<Integer>(30));
    avl.incluirNo(35);
    avl.incluirNo(10);
    avl.incluirNo(33);
    avl.incluirNo(11);
    avl.incluirNo(5);
    avl.incluirNo(3);
    avl.incluirNo(7);
    // avl.removerNo(7);
    // avl.removerNo(11);

    // avl.incluirNo(9);

    // final var avl = new ArvoreAVL<Integer>(new No<Integer>(50));
    // avl.incluirNo(20);
    // avl.incluirNo(90);
    // avl.incluirNo(10);
    // avl.incluirNo(40);
    // avl.incluirNo(30);
    // avl.incluirNo(15);
    // avl.incluirNo(19);
    // avl.incluirNo(35);
    // avl.incluirNo(38);
    // avl.removerNo(19);
    // avl.removerNo(10);
    // avl.removerNo(15);
    // avl.removerNo(30);
    // avl.removerNo(20);
    final var lista = new ArrayList<Integer>();
    avl.pegarChavesEmOrdem(avl.getRaiz(), lista);
    final var avRN = new ArvoreRubroNegra<Integer>(new NoRN<Integer>(lista.get(0)));
    for (int i = 1; i < lista.size(); i++) {
       avRN.inserirRB(new NoRN<Integer>(lista.get(i)));
    }

    avl.mostrar();
    System.out.println("-- Abaixo é a rubro negra --");
    avRN.mostrar();
    final var retoPesquisa = avl.pesquisar(avl.getRaiz(), 19);
    // final var refChild = Optional.ofNullable(retoPesquisa.getRightChild())
    // .map(No::getValue)
    // .orElse(null);
    System.out.println(retoPesquisa.getValue());
    // avl.emOrdem(avl.getRaiz());
  }
}
