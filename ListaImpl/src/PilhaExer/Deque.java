package PilhaExer;

public class Deque implements PilhaIS{
    
    private int capacity=1;
    private Object[] S;
    private int t= -1;
    private int FI;

   

    public Deque(int fI) {
        this.FI = fI<=0?0:fI;
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
        t++;
        S[t]=o;
    }

    @Override
    public int size() {
        return t+1;
        // TODO Auto-generated method stub
    }

    @Override
    public boolean isEmpty() {
        return t==-1;
        // TODO Auto-generated method stub
    }

    public Deque Copy(){
        Deque copy = new Deque(0);
        for (int i = size()-1; i >-1; i--) {
            
            copy.push(S[i]);
        }
        return copy;
    }

    @Override
    public Object pop() {
        // TODO Auto-generated method stub
        if(isEmpty()){
            throw new RuntimeException("vazio");
        }
        Object res = S[t];
        t--;
        return res;
    }

    @Override
    public Object top() {
        // TODO Auto-generated method stub
         return S[t];
    }

    public void ShwEl(){
        for (int i = t; i >-1 ; i--) {
            if(S[i]!=null){
               System.out.print(S[i]);
               System.out.print(" ");
            }
        }
    }
    
}
