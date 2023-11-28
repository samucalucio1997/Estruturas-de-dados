package FilaPrioridade;

import ArvoreBinariaPesquisa.no;

public class HeapNo<t> implements FilaI<t>{
    private no<t> ultim_node;
    
    private no<t> raiz;

    private int tam;

    
    
    
    public HeapNo(no<t> raiz) {
        this.raiz = raiz;
        this.tam = 1;
        this.ultim_node = this.raiz;
    }
    
    @Override
    public void insert(no<t> arg1) {
        // TODO Auto-generated method stub
        no<t> refu = this.ultim_node;
        //caso o ultimo no seja filho da esquerda, isso quer dizer que o filho da direita é null, ou seja, o no assumira o posto
        if(refu.getFather() == null && refu.getLeftChild() == null){
              refu.setLeftChild(arg1);setUltim_node(arg1);
              arg1.setFather(refu);
              upHeap();
              return;
        }

        if(refu.getFather().getLeftChild() != null && refu.getFather().getLeftChild().equals(refu)){
            refu.getFather().setRightChild(arg1);
            setUltim_node(arg1);
            arg1.setFather(refu.getFather());
            upHeap();
        }
        else{
            while (refu.getFather()!=null && refu.getFather().getLeftChild() != null &&
             refu.getFather().getRightChild() != null) {
                //caso o no esteja na direita ele irá pro no pai
                if(!refu.getFather().getLeftChild().equals(refu) && refu.getFather().getRightChild() != null){
                    refu = refu.getFather();continue;
                }else{
                    if(refu.getFather().getRightChild() == null){
                        refu.getFather().setRightChild(arg1);
                        setUltim_node(arg1);    
                        arg1.setFather(refu);
                        upHeap();
                    }
                    if(refu.getFather().getLeftChild() != null && refu.getFather().getLeftChild().equals(refu)){
                        refu = refu.getFather().getRightChild();break;
                    }else{
                        if(refu.getFather().getLeftChild() != null){
                           refu = refu.getFather().getLeftChild();break;
                       }
                    }
                }
            }
            while (refu.getLeftChild() != null) {
                refu = refu.getLeftChild();
            }
            refu.setLeftChild(arg1);
            arg1.setFather(refu);
            setUltim_node(arg1);
            upHeap();
        }
        this.tam++;
    }
    
    private void upHeap(){
        no<t> cursiNo = getUltim_node();
        while (!cursiNo.equals(getRaiz()) && (int) cursiNo.getValue() > (int) cursiNo.getFather().getValue()) {
            t valueNo = cursiNo.getValue();
            cursiNo.setValue(cursiNo.getFather().getValue());
            cursiNo.getFather().setValue(valueNo);
            cursiNo = cursiNo.getFather();
        }
    }

    public no<t> getRaiz() {
        return raiz;
    }

    public void setRaiz(no<t> raiz) {
        this.raiz = raiz;
    }


    public no<t> getUltim_node() {
            return ultim_node;
    }
    
    public void setUltim_node(no<t> ultim_node) {
            this.ultim_node = ultim_node;
    }
    /*
                         A
                B                           C 
        D             E                F         G
    H        I    J       K       
                      ultimo_no  
    */

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public t min() {
        // TODO Auto-generated method stub
        return getRaiz().getValue();
    }

    @Override
    public void removeMin() {
        // TODO Auto-generated method stub
        no<t> curNo = getUltim_node();
        //caso o no seja filho da direita
        if(curNo.getFather()!=null && curNo.getFather().getRightChild() != null && curNo.getFather().getRightChild().equals(curNo)){
               curNo = curNo.getFather().getLeftChild();
               curNo.getFather().setRightChild(null);
               setUltim_node(curNo);
        }else{
            //no excluido filho da esquerda mas não tá na ponta
            if(curNo.getFather() != null && curNo.getFather().getLeftChild().equals(curNo) && curNo.getFather().getRightChild() != null){
                curNo = curNo.getFather();
                curNo.setLeftChild(null);
                while (curNo.getFather() != null && curNo.getFather().getRightChild() != null && curNo.getFather().getRightChild().equals(curNo)) {
                     curNo = curNo.getFather();
                }
                curNo = curNo.getLeftChild();
                while (curNo.getRightChild() != null) {
                    curNo = curNo.getRightChild();
                }
                setUltim_node(curNo);
            }
            //no filho da esquerda na ponta
            else{
                curNo = curNo.getFather();
                curNo.setLeftChild(null);
                while (curNo.getFather() != null) {
                    curNo = curNo.getFather();
                }
                
                if(curNo.getFather() == null && curNo.getLeftChild().equals(curNo)){
                      curNo = curNo.getRightChild();
                      while(curNo.getLeftChild()!=null){
                          curNo = curNo.getRightChild();
                      }
                      setUltim_node(curNo); 
                }else{
                    curNo = curNo.getRightChild();
                    while (curNo.getRightChild() != null) {
                        curNo = curNo.getRightChild();
                    }
                    setUltim_node(curNo);
                }
            }
        }
        this.tam--;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return this.tam;
    }

    public void emOrdem(no<t> node){
        if(node == null){
            return;
        }
        if(node.Isinternal()){
            emOrdem(node.getLeftChild());;
        }
        no<t> paiNo = node.getFather() != null?node.getFather():node;
        System.out.println(node.getValue() + " filho de " + paiNo.getValue());
        paiNo = null;
        if(node.Isinternal()){
            emOrdem(node.getRightChild());
        }
    }
    
}
