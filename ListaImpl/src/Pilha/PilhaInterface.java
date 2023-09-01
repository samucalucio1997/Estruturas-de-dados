package Pilha;

public interface PilhaInterface {
    public int size();    
    public boolean isEmpty();
    public Object top() throws PilhaVaziaExcecao;
    public void push(Object o);
    public Object pop() throws PilhaVaziaExcecao;
}
