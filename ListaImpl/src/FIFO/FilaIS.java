package FIFO;

public interface FilaIS<T extends Object> {
    public T enQueue(T no);
    public T deQueue();
    public T first();
    public int size();
    public Boolean isEmpty();
}
