package ArvoreBinariaPesquisa;

import java.util.ArrayList;
import java.util.List;


public class ArvoreBinP<t> implements IArvoreBinariaPesquisa<t>{
    
    private No<t> root;
    private Comparador<t> comp;
    private int num_elem;
    private ArrayList<No<t>> list;
    private t[][] arr;

    public ArvoreBinP(No<t> root) {
        this.root = root;
        this.comp = new Comparador<t>() {
            @Override
            public int compare(No<t> no1, No<t> no2) {
                // TODO Auto-generated method stub
                int p1 = (Integer) no1.getValue();
                int p2 = (Integer) no2.getValue();
                return p1-p2;
            }

            @Override
            public int compareT(int no1, int no2) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'compareT'");
            }
            
        };
    }
    @Override
    public int altura(No<t> no) {
        // TODO Auto-generated method stub
        this.setComparator(new Comparador<t>() {

            @Override
            public int compare(No<t> no1, No<t> no2) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'compare'");
            }

            @Override
            public int compareT(int no1, int no2) {
                // TODO Auto-generated method stub
                return no1 - no2;
            }
            
        });
        if(no==null){
            return 0;
        }else{
            int p=this.getComparador()
            .compareT(altura(no.getRightChild()), altura(no.getLeftChild()));
            if(p>0){
                return 1 + altura(no.getRightChild());
            }else{
                return 1 + altura(no.getLeftChild()); 
            }
        }
    }

    @Override
    public Iterator<t> elements() {
        // TODO Auto-generated method stub
        List<t> arrTs = new ArrayList<>();
        for (No<t> t : list) {
            arrTs.add(t.getValue());
        }
        return  (Iterator<t>) arrTs.iterator();
    }

    @Override
    public void emOrdem(No<t> no) {
        // TODO Auto-generated method stub
        if(no==null){
            return;
        }
        if(no.Isinternal()){
            emOrdem(no.getLeftChild());;
        }
        System.out.println(no.getValue());
        if(no.Isinternal()){
            emOrdem(no.getRightChild());
        }
    }

    @Override
    public Comparador<t> getComparador() {
        // TODO Auto-generated method stub
        return this.comp;
    }

    @Override
    public No<t> getRaiz() {
        // TODO Auto-generated method stub
        return this.root;
    }

    @Override
    public No<t> incluir(t key) {
        // TODO Auto-generated method stub
        No<t> new_no = new No<t>(key);
        No<t> curNo = getRaiz();
        // caso a arvore esteja somente com no raiz
        if(curNo.getLeftChild()==null&&curNo.getRightChild()==null){
            if(comp.compare(new_no, curNo)>0){
                 curNo.setRightChild(new_no);
            }else{
                curNo.setLeftChild(new_no);
            }
        }else{
            //comparando as chaves do no cursor e do no a ser inserido
            while (curNo!=null) {
                int ret = getComparador().compare(new_no, curNo);
                if(ret>0){
                    if(curNo.getRightChild()!=null&&curNo.getLeftChild()!=null){
                        curNo = curNo.getRightChild();continue;
                    }else{
                        curNo.setRightChild(new_no);break;
                    } 
                }else{
                    if(curNo.getLeftChild()!=null){
                        curNo = curNo.getLeftChild();continue; 
                    }else{
                        curNo.setLeftChild(new_no);break;
                    }
                }
            }
        }
        new_no.setFather(curNo);
        this.num_elem++;
        return new_no;
    }


    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void mostrar() {
        // TODO Auto-generated method stub
        double a = this.altura(root);
        double b = 2;
        this.arr = (t[][]) new Object[this.altura(root)+1][(int) Math.pow(b, a)];
        printTree(root,(int) Math.pow(b, a)/2,arr);
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j < (int) Math.pow(b, a); j++) {
                if(arr[i][j]!=null){
                    System.out.print(" " + arr[i][j]+ " ");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private void printTree(No<t> node, int col, t[][] arr) {
        if(node==null||(col<0&&col>(int) Math.pow(2, this.altura(root)))){
            return;
        }
        if(node.Isinternal()){
           printTree(node.getLeftChild(), col, arr);
        }

        // if((int)node.getValue()>col){
        //     arr[profundidade(node)][(int)node.getValue()%col] = node.getValue();   
        //     System.out.println(col);         
        // }else{
            arr[profundidade(node)][(int)node.getValue()] = node.getValue();
        // }
        
        if(node.Isinternal()){
           printTree(node.getRightChild(), col, arr);    
        }
    }

    private void buildMatriz(No<t> no){
       if(no==null){
            list.add(null);
            return;
       }
       buildMatriz(no.getLeftChild());
       list.add(no);
       buildMatriz(no.getRightChild());
    }
    

    @Override
    public Iterator<No<t>> nos() {
        // TODO Auto-generated method stub
        buildMatriz(root);
        return (Iterator<No<t>>) this.list.iterator();
    }

    @Override
    public No<t> pesquisar(No<t> no, t key) {
        // TODO Auto-generated method stub
        if(no==null){
            return null;
        }
        if(no.getValue().equals(key)){
             return no;
        }
        No<t> ret = pesquisar(no.getRightChild(),key);
        if(ret!=null){
            return ret;
        }else{
            return pesquisar(no.getLeftChild(), key);
        }
    }

    @Override
    public void posOrdem(No<t> no) {
        // TODO Auto-generated method stub
        if(no==null){
            return;
        }
        else{
            posOrdem(no.getLeftChild());
            posOrdem(no.getRightChild());
            System.out.println(no.getValue());
        }
    }

    @Override
    public void preOrdem(No<t> no) {
        // TODO Auto-generated method stub
        if(no==null){
            return;
        }else{
            System.out.println(no.getValue());
            posOrdem(no.getLeftChild());
            posOrdem(no.getRightChild());
        }
    }

    @Override
    public int profundidade(No<t> no) {
        // TODO Auto-generated method stub
        if(no==null){
            return -1;
        }
        if(no.getValue().equals(getRaiz().getValue())){
            return 0;
        }
        else{
            int p = profundidade(no.getFather());
            return 1 + p;
        }
    }

    @Override
    public t remover(t key) {
        // TODO Auto-generated method stub
        No<t> pai = null;
        No<t> atual = pesquisar(root, key);
        pai = atual.getFather();
        if (atual == null) {
            return null; // Se o nó não foi encontrado
        }
    
        t valorRemovido = atual.getValue();
    /*Nesse escopo inicia a busca pelo sucessor do no */
        // no a ser removido é um no folha
        if (atual.getLeftChild() == null && atual.getRightChild() == null) {
            if (pai == null) {
                root = null; // Remover a raiz
            } else{
                if (atual == pai.getLeftChild()) {
                   pai.setLeftChild(null);
               } else {
                   pai.setRightChild(null);
               }
            }
        }
        // no a ser removido tem apenas um filho
        else{
            if (atual.getLeftChild() == null || atual.getRightChild() == null) {
                No<t> filho = (atual.getLeftChild() != null) ? atual.getLeftChild() : atual.getRightChild();
                if (pai == null) {
                    root = filho; // O filho se torna a nova raiz
                } else{
                    if (atual == pai.getLeftChild()) {
                        pai.setLeftChild(filho);
                    } else {
                        pai.setRightChild(filho);
                    }
                } 
            }
            // no a ser removido tem dois filhos
            else {
                No<t> sucessor = atual.getRightChild();
                while (sucessor.getLeftChild()!=null) {
                   sucessor = sucessor.getLeftChild();    
                }
                t valorSucessor = sucessor.getValue();
                remover(sucessor.getValue()); // remove recursivamente o sucessor
        
                atual.setValue(valorSucessor);
            }
        } 
    
        return valorRemovido;
    }
    
    
    @Override
    public void setComparator(Comparador<t> c) {
        // TODO Auto-generated method stub
        this.comp=c;
    }

    @Override
    public void setRaiz(No<t> p) {
        // TODO Auto-generated method stub
        this.root = p;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return this.num_elem;
    }

    
}
