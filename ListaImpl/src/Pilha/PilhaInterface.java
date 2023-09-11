package Pilha;

public interface PilhaInterface {
    public int size();

    public boolean isEmpty();

    public int topVermelho() throws PilhaVaziaExcecao;

    public int topPreto() throws PilhaVaziaExcecao;

    public int popVermelha() throws PilhaVaziaExcecao;

    public void pushRed(Object o);

    public void pushBlack(Object o);
}