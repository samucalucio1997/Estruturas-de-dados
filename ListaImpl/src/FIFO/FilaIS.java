package FIFO;

public interface FilaIS<T extends Object> {
    public void enQueue(T no);
    public T deQueue();
    public T first();
    public int size();
    public Boolean isEmpty();
}
