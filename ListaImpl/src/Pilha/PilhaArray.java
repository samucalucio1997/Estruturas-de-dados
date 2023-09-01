package Pilha;

public class PilhaArray implements PilhaInterface{

    private Object[] S;
    private int v=-1;
    private int t=-1;
    private int p=-1;
    private int capacidade;
    private int FO;
    
    
    
    
    public PilhaArray( int t, int fO) {
        S= new Object[1];
        this.t=t;
        p=t-v;
        if(fO<=0){
           FO=0;
        }else{
            FO=fO;
        }
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public Object top() throws PilhaVaziaExcecao {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'top'");
    }

    @Override
    public void push(Object o) {
        if(t==p+v){
          //aumenta Pilha
        } else{
          if(o.getClass().getName().equals("Pilha.Vermelho"))
            S[++v]=o;
        //   else S[]
        }

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'push'");
    }

    @Override
    public Object pop() throws PilhaVaziaExcecao {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pop'");
    }
    
}
