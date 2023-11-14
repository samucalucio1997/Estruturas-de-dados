package ArvoreBinariaPesquisa;

import java.util.Stack;

public class Iterator<t> implements java.util.Iterator<t>{
    private Stack<no<t>> pilha; 

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return !pilha.isEmpty();
    }

    private void RealOck(no<t> node){
          
    }

    @Override
    public t next() {
        // TODO Auto-generated method stub
        no<t> pNo = pilha.pop();
        return pNo.getValue();
    }

}
