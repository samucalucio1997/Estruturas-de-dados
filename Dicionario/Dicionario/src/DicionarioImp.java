import java.util.Iterator;

public interface DicionarioImp<t> {
    public abstract t InsertItem(t chave,Obj element);
    public abstract Obj findElement(t chave);
    public abstract Obj removeElement(t chave);
    public abstract int size();
    public abstract boolean isEmpty();
    public abstract Iterator<t> Key();
    public abstract Iterator<Obj> Element();
}
