package VECTOR;

public interface VectorIM {
    abstract int size();
    abstract boolean isEmpty();
    abstract Object elementAtRank(int index);
    abstract Object insertAtRank(Object o, int p);
    abstract Object removeAtRank(int ar); 
    
}
