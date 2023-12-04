package FilaPrioridade;

import ArvoreBinariaPesquisa.No;

public interface FilaI<t> {
    public abstract t min();
    public abstract void removeMin();
    public abstract void insert(No<t> valor);
    public abstract int size();
    public abstract boolean isEmpty();
}
