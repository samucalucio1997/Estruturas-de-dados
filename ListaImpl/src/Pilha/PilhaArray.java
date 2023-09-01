package Pilha;

public class PilhaArray implements PilhaInterface {

    private Cor[] S;
    private int v = -1;
    private int p;
    private int totalEl = 0;
    private int capacidade = 1;
    private int FO;

    public PilhaArray(int t, int fO) {
        S = new Cor[capacidade];
        p = S.length;
        if (fO <= 0) {
            FO = 0;
        } else {
            FO = fO;
        }
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return totalEl;
        // throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return totalEl == 0;
    }

    @Override
    public int topVermelho() throws PilhaVaziaExcecao {
        if (this.isEmpty()) {
            throw new PilhaVaziaExcecao("É Pilha vazia man");
        }
        return S[v].getValue();
        // TODO Auto-generated method stub
    }

    @Override
    public void push(Cor o) {
        if (v == p + 1 || (!isEmpty() && capacidade == 1)) {
            // aumenta a capacidade da Pilha
            if (FO == 0) {
                capacidade *= 2;
            } else {
                capacidade += FO;
            }
            this.v = -1;
            this.p = capacidade;
            Cor[] a = new Cor[capacidade];
            for (int i = 0; i < S.length; i++) {
                if (o.getNome().equals("Vermelho")) {
                    a[++v] = S[i];
                } else {
                    a[--p] = S[i];
                }
            }
            S = a;
        } else {
            if (o.getNome().equals("Vermelho")) {
                S[++v] = o;
            } else {
                S[--p] = o;
            }
        }
        totalEl++;
        // TODO Auto-generated method stub
    }

    @Override
    public Cor pop() throws PilhaVaziaExcecao {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pop'");
    }

    @Override
    public int topPreto() throws PilhaVaziaExcecao {
        // TODO Auto-generated method stub]
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("É pilha vazia man");
        }
        return S[p].getValue();// pelo indice, é preto
    }

}
