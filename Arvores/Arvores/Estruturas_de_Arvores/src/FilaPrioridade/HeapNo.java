package FilaPrioridade;

import ArvoreBinariaPesquisa.no;

public class HeapNo<t> implements FilaI<t>{
    private no<t> ultim_node;
    
    private no<t> raiz;


    
    
    
    public HeapNo(no<t> raiz) {
        this.raiz = raiz;
        this.ultim_node = this.raiz;
    }
    
    @Override
    public void insert(t arg0, no<t> arg1) {
        // TODO Auto-generated method stub

        no<t> refu = this.ultim_node;
        //caso o ultimo no seja filho da esquerda, isso quer dizer que o filho da direita é null, ou seja, o no assumira o posto
        if(refu.getFather() == null && refu.getLeftChild() == null){
              refu.setLeftChild(arg1);setUltim_node(arg1);
              arg1.setFather(refu);
              return;
        }

        if(refu.getFather().getLeftChild() != null && refu.getFather().getLeftChild().equals(refu)){
            refu.getFather().setRightChild(arg1);
            setUltim_node(arg1);
            arg1.setFather(refu.getFather());
        }
        else{
            while (refu.getFather()!=null && refu.getFather().getLeftChild() != null &&
             refu.getFather().getRightChild() != null) {
                //caso o no esteja na direita ele irá pro no pai
                if(!refu.getFather().getLeftChild().equals(refu)&&refu.getFather().getRightChild()!=null){
                    refu = refu.getFather();continue;
                }else{
                    if(refu.getFather().getRightChild()==null){
                        refu.getFather().setRightChild(arg1);
                        setUltim_node(arg1);    
                        arg1.setFather(refu);
                    }
                    if(refu.getFather().getLeftChild() != null&&refu.getFather().getLeftChild().equals(refu)){
                        refu = refu.getFather().getRightChild();break;
                    }else{
                        if(refu.getFather().getLeftChild()!=null){
                           refu = refu.getFather().getLeftChild();break;
                       }
                    }
                }
            }
            while (refu.getLeftChild()!=null) {
                refu = refu.getLeftChild();
            }
            refu.setLeftChild(arg1);
            arg1.setFather(refu);
            setUltim_node(arg1);
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
        return null;
    }

    @Override
    public void removeMin() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
