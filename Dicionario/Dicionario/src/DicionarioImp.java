import java.util.Iterator;

public interface DicionarioImp<t> {
    public abstract t InsertItem(t chave,Obj<t> element);
    public abstract Obj<t> findElement(t chave);
    public abstract Obj<t> removeElement(t chave);
    public abstract int size();
    public abstract boolean isEmpty();
    public abstract Iterator<t> Key();
    public abstract Iterator<Obj<t>> Element();
}
