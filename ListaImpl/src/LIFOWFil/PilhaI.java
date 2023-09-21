package LIFOWFil;

public interface PilhaI {
    public abstract int size();
    public abstract boolean isEmpty();
    public abstract Object top();// throw same Exception
    public abstract void push(Object o);
    public abstract Object pop();// throw same Exception
}
