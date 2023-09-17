package FIFOLIG;

public interface FilaIm<T> {
    public T enQueue(T no);
    public T deQueue();
    public T first();
    public int size();
    public Boolean isEmpty();
}
