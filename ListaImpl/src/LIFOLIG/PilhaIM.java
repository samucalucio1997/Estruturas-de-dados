package LIFOLIG;

public interface PilhaIM<T> {
    public abstract T push(T o);
    public abstract T pop();
    public abstract int size();
    public abstract boolean isEmpty(); 
}
