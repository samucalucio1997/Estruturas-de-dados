package RubroNegra;

public class TesteRN {
    public static void main(String[] args) {
        final var arvRN = new ArvoreRubroNegra<Integer>(new NoRN<Integer>(45));
        arvRN.inserirRB(new NoRN<Integer>(15));
        arvRN.inserirRB(new NoRN<Integer>(50));
        arvRN.inserirRB(new NoRN<Integer>(12));
        arvRN.inserirRB(new NoRN<Integer>(49));
        arvRN.inserirRB(new NoRN<Integer>(10));
        arvRN.inserirRB(new NoRN<Integer>(8));
        arvRN.inserirRB(new NoRN<Integer>(7));
        arvRN.inserirRB(new NoRN<Integer>(11));
        arvRN.inserirRB(new NoRN<Integer>(13));
//        arvRN.inserirRB(new NoRN<Integer>(0));

        arvRN.mostrar();
        final var raiz = (NoRN) arvRN.getRaiz();
        System.out.println(raiz.getCor());
    }
}
