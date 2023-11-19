package ArvoreBinariaPesquisa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.tree.TreeNode;

public class ArvoreBinP<t> implements IArvoreBinariaPesquisa<t>{
    
    private no<t> root;
    private Comparador<t> comp;
    private int num_elem;
    private ArrayList<t> list;
    private t[][] arr;

    public ArvoreBinP(no<t> root) {
        this.root = root;
        this.comp =new Comparador<t>() {
            @Override
            public int compare(no<t> no1, no<t> no2) {
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
    public int altura(no<t> no) {
        // TODO Auto-generated method stub
        this.setComparator(new Comparador<t>() {

            @Override
            public int compare(no<t> no1, no<t> no2) {
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
        for (t t : list) {
            arrTs.add(t);
        }
        return  (Iterator<t>) arrTs.iterator();
    }

    @Override
    public void emOrdem(no<t> no) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Comparador<t> getComparador() {
        // TODO Auto-generated method stub
        return this.comp;
    }

    @Override
    public no<t> getRaiz() {
        // TODO Auto-generated method stub
        return this.root;
    }

    @Override
    public no<t> incluir(t key) {
        // TODO Auto-generated method stub
        no<t> new_no = new no<t>(key);
        no<t> curNo = getRaiz();
        if(curNo.getLeftChild()==null&&curNo.getRightChild()==null){
            if(comp.compare(new_no, curNo)>0){
                 curNo.setRightChild(new_no);
            }else{
                curNo.setLeftChild(new_no);
            }
        }else{
            while (curNo!=null) {
                int ret = comp.compare(new_no, curNo);
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
    
    private void printTree(no<t> node, int col, t[][] arr) {
        if(node==null||(col<0&&col>(int) Math.pow(2, this.altura(root)))){
            return;
        }
        if(node.Isinternal()){
           printTree(node.getLeftChild(), col+2, arr);
        }
        arr[profundidade(node)][((int)(node.getValue())+1)%col] = node.getValue();
        if(node.Isinternal()){
           printTree(node.getRightChild(), col-6, arr);    
        }
        // else{
        //     arr[profundidade(node)][col]=(t) node.getValue();
        //     printTree(node.getLeftChild(),col-4,arr);
        //     printTree(node.getRightChild(), col+2, arr);
        // } 
    }

    private void buildMatriz(no<t> no){
       if(no==null){
            list.add(null);
            return;
       }
       buildMatriz(no.getLeftChild());
       list.add(no.getValue());
       buildMatriz(no.getRightChild());
    }
    

    @Override
    public Iterator<t> nos() {
        // TODO Auto-generated method stub
        buildMatriz(root);
        return (Iterator<t>) this.list.iterator();
    }

    @Override
    public no<t> pesquisar(no<t> no, t key) {
        // TODO Auto-generated method stub
        if(no==null){
            return null;
        }
        if(no.getValue().equals(key)){
             return no;
        }
        no<t> ret = pesquisar(no.getRightChild(),key);
        if(ret!=null){
            return ret;
        }else{
            return pesquisar(no.getLeftChild(), key);
        }
    }

    @Override
    public void posOrdem(no<t> no) {
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
    public void preOrdem(no<t> no) {
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
    public int profundidade(no<t> no) {
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
        no<t> nt = pesquisar(root, key);
        t value = nt.getValue();
        if(nt.getRightChild()!=null){
                nt = nt.getRightChild();
        }
        while (nt.getLeftChild()!=null) {
            nt = nt.getLeftChild();
        }
        no<t> sgTroca = pesquisar(root, nt.getValue());
        no<t> novo  =pesquisar(root, key);
        novo.setValue(nt.getValue());
        nt=nt.getRightChild()!=null?nt.getRightChild():null;
        while (nt!=null&&nt.getLeftChild()!=null) {
            nt = nt.getLeftChild();
        }
        if(nt!=null){
            sgTroca.setValue(nt.getValue()); 
        }else{
            sgTroca.setValue(null);
        }
        return value;
    }

    @Override
    public void setComparator(Comparador<t> c) {
        // TODO Auto-generated method stub
        this.comp=c;
    }

    @Override
    public void setRaiz(no<t> p) {
        // TODO Auto-generated method stub
        this.root = p;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return this.num_elem;
    }

    
}
