package RubroNegra;

public class TesteRN {
    public static void main(String[] args) {
        final var arvRN = new ArvoreRubroNegra<Integer>(new NoRN<Integer>(45));
        arvRN.inserirRB(new NoRN<Integer>(15));
        arvRN.inserirRB(new NoRN<Integer>(50));
        arvRN.inserirRB(new NoRN<Integer>(12));
        arvRN.inserirRB(new NoRN<Integer>(46));
        arvRN.inserirRB(new NoRN<Integer>(10));
        arvRN.inserirRB(new NoRN<Integer>(8));
        arvRN.inserirRB(new NoRN<Integer>(5));
        arvRN.inserirRB(new NoRN<Integer>(11));
        arvRN.inserirRB(new NoRN<Integer>(13));
        arvRN.inserirRB(new NoRN<Integer>(9));
        arvRN.inserirRB(new NoRN<Integer>(17));
        arvRN.inserirRB(new NoRN<Integer>(26));
        // arvRN.inserirRB(new NoRN<Integer>(84));
        // arvRN.inserirRB(new NoRN<Integer>(47));//[10, 5, 15, 3, 7, 12, 17, 2, 4]
        
        arvRN.removerRB(5);
        arvRN.removerRB(10);

        // final var arvRN = new ArvoreRubroNegra<Integer>(new NoRN<Integer>(10));
        // arvRN.inserirRB(new NoRN<Integer>(5));
        // arvRN.inserirRB(new NoRN<Integer>(15));
        // arvRN.inserirRB(new NoRN<Integer>(3));
        // arvRN.inserirRB(new NoRN<Integer>(7));
        // arvRN.inserirRB(new NoRN<Integer>(12));
        // arvRN.inserirRB(new NoRN<Integer>(17));
        // arvRN.inserirRB(new NoRN<Integer>(2));
        // arvRN.inserirRB(new NoRN<Integer>(4));

        arvRN.removerRB(15);
        
        // System.out.println(arvRN.isRubroNegra());

        arvRN.mostrar();
        final var nodeSearch = arvRN.pesquisarRN((NoRN) arvRN.getRaiz(), 17);
        System.out.println(nodeSearch.getRightChild().getValue());
    }
}
