package FilaPrioridade;

public interface FilaI<t> {
    public abstract t min();
    public abstract void removeMin();
    public abstract void insert(t chave, Object valor);
    public abstract int size();
    public abstract boolean isEmpty();
}
