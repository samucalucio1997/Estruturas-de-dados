package FilaPrioridade;

import ArvoreBinariaPesquisa.no;

public interface FilaI<t> {
    public abstract t min();
    public abstract void removeMin();
    public abstract void insert(t chave, no<t> valor);
    public abstract int size();
    public abstract boolean isEmpty();
}
