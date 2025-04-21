package AVL;

import java.util.Optional;

import ArvoreBinariaPesquisa.No;

public class TesteAVL {
  public static void main(String[] args) {
    // final var avl = new ArvoreAVL<Integer>(new No<Integer>(32));
    // avl.incluirNo(31);
    // avl.incluirNo(35);
    // avl.incluirNo(33);
    // avl.incluirNo(36);
    // avl.incluirNo(38);


    final var avl = new ArvoreAVL<Integer>(new No<Integer>(50));
    avl.incluirNo(20);
    avl.incluirNo(80);
    avl.incluirNo(70);
    avl.incluirNo(60);
    avl.incluirNo(90);
    
    final var retoPesquisa = avl.pesquisar(avl.getRaiz(), 80);
    final var refChild = Optional.ofNullable(retoPesquisa.getFather())
    .map(No::getValue).orElse(null);
    System.out.println(refChild);
    avl.mostrar();
    avl.emOrdem(avl.getRaiz());
  }
}
