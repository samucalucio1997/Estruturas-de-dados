package Pilha;

public interface PilhaInterface {
    public int size();

    public boolean isEmpty();

    public Object topVermelho() throws PilhaVaziaExcecao;

    public Object topPreto() throws PilhaVaziaExcecao;

    public Object popVermelha() throws PilhaVaziaExcecao;

    public void pushRed(Object o);

    public void pushBlack(Object o);
}
