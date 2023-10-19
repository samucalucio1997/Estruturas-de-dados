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

    public Deque Copy(){//copia invertida
        Deque copy = new Deque(0);
        for (int i = size()-1; i >-1; i--) {
            copy.push(S[i]);//não foi usado o pop() para não esvaziar esta pilha que foi usada para gerar a cópia!!
        }
        return copy;
    }


    public void AdicionaPilha(Deque p){
        Deque aux = new Deque(0);
        while(!p.isEmpty()) {
            aux.push(p.top());p.pop();
        }
          while(!aux.isEmpty()) {
              p.push(aux.top());
              this.push(aux.top());aux.pop();
          }
    }

    public Deque Inverse(){
         Deque nova =new Deque(0);
        //  int i=0;
        //  while (i<this.size()) {
        //     nova.push(S[i]);i++;
        //  }
         while (!isEmpty()) {
            nova.push(pop());
         }
         return nova;
    }

    public void empty(){
        t=-1;
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
        System.out.println();
    }
    
}
