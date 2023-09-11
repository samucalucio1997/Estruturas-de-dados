package PilhaExer;

public class Deque implements PilhaIS{
    
    private int capacity=1;
    private Object[] S;
    private int t= -1;
    private int FI;

   

    public Deque(int t, int fI) {
        this.t = t;
        this.FI = fI<=0?2:fI;
        S = new Object[capacity]; 
    }

    @Override
    public void push(Object o) {
        if(t+1==capacity){
            capacity = FI==0?capacity*2:capacity+FI;
            Object[] nova = new Object[capacity];
            for (int i = 0; i < S.length; i++) {
                nova[i] = S[i];
            }
         S=nova;
        }
        S[++t]=o;
    }

    @Override
    public int size() {
        return t+1;
        // TODO Auto-generated method stub
    }

    @Override
    public boolean isEmpty() {
        return t!=-1;
        // TODO Auto-generated method stub
    }

    @Override
    public Object pop() {
        // TODO Auto-generated method stub
        Object res = S[t];
        S[t]=null;
        --t;
        return res;
    }

    @Override
    public Object top() {
        // TODO Auto-generated method stub
         return S[t];
    }
    
}
