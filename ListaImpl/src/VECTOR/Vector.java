package VECTOR;

public class Vector implements VectorIM{
     
    private Object[] ar;
    private int c=-1;
    private int capacity;
    
    

    public Vector() {
        capacity=1;
        this.ar = new Object[capacity];
    }

    @Override
    public Object ReplaceAtRank(int r, Object o) {
        if(c==-1){
            throw new RuntimeException("Vector vazio!!!");
        }
        if(ar[r]!=null){
            ar[r]=o;
        }
        return ar[r];
    }

    @Override
    public Object elementAtRank(int index) {
        // TODO Auto-generated method stub
        if(c==-1){
            throw new RuntimeException("Vector vazio!!!");
        }
        return ar[index];
    }

    @Override
    public Object insertAtRank(Object o, int p) {
        if(c==capacity-1){
          int cp = capacity;
          capacity*=2;
          Object[] novo = new Object[capacity];
          for (int i = 0; i < cp; i++) {
             novo[i] = ar[i];
          }
          ar=novo;
        }
        for (int i = c+1; i > p; i--) {
           ar[i]=ar[i-1];
        }
        ar[p]=o;
        c++;
        return ar[p];
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return c==-1;
    }

    @Override
    public Object removeAtRank(int a) {
        // TODO Auto-generated method stub
        if(c==-1){
            throw new RuntimeException("Vector vazio!!");
        }
        Object remo = ar[a];
        for (int i = a+1; i< size(); i++) {
            ar[i-1]=ar[i];
        }
        c--;
        return remo;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return c+1;
    }
    
    public void ShowElements(){
        System.out.print("[");
        for (int i = 0; i < size(); i++) {
            System.out.print(ar[i] + " ,");
        }
        System.out.println("]");
    }

}
