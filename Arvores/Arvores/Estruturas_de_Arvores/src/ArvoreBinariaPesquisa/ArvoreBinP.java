package ArvoreBinariaPesquisa;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

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
                if (no1.equals(no2)) {
                    throw new RuntimeErrorException(new Error("Aquele erro"));
                }
                int p1 = (Integer) no1.getValue();
                int p2 = (Integer) no2.getValue();
                return p1-p2;
            }

            @Override
            public int compareT(int no1, int no2) {
                return no1 - no2;
            }
            
        };
    }
    @Override
    public int altura(No<t> no) {
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
        // final var arrTs = ;
        return  (Iterator<t>) this.list.stream()
        .map(No::getValue)
        .collect(Collectors.toList()).iterator();
    }

    @Override
    public void emOrdem(No<t> no) {
        // TODO Auto-generated method stub
        if(no==null){
            return;
        }
        if(no.Isinternal()){
            emOrdem(no.getLeftChild());
        }
        // final var paiNo = Optional.ofNullable(no.getFather()).map(No::getValue).orElse(null);
        System.out.println("No: " + no.getValue() + ", Pai => " + no.getFB());
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
        No<t> pai = pesquisar(curNo, key);

        final var coefComp = this.getComparador().compare(new_no, pai);
        if (coefComp > 0) {
            pai.setRightChild(new_no);
            // this.atualizadorFB(pai, -1);
        }else{
            pai.setLeftChild(new_no);
            // this.atualizadorFB(pai, 1);
        }
        // caso a arvore esteja somente com no raiz
        // if(curNo.getLeftChild()==null&&curNo.getRightChild()==null){
        //     if(comp.compare(new_no, curNo)>0){
        //          curNo.setRightChild(new_no);
        //          this.atualizadorFB(curNo, -1);
        //     }else{
        //         curNo.setLeftChild(new_no);
        //         this.atualizadorFB(curNo, 1);
        //     }
        // }else{
        //     //comparando as chaves do no cursor e do no a ser inserido
        //     while (curNo!=null) {
        //         int ret = getComparador().compare(new_no, curNo);
        //         if(ret>0){
        //             if(curNo.getRightChild()!=null&&curNo.getLeftChild()!=null){
        //                 curNo = curNo.getRightChild();
        //                 continue;
        //             }else{
        //                 curNo.setRightChild(new_no);
        //                 this.atualizadorFB(curNo, -1);
        //                 break;
        //             } 
        //         }else{
        //             if(curNo.getLeftChild()!=null){
        //                 curNo = curNo.getLeftChild();continue; 
        //             }else{
        //                 curNo.setLeftChild(new_no);
        //                 this.atualizadorFB(curNo, 1);
        //                 break;
        //             }
        //         }
        //     }
        // }
        new_no.setFather(pai);
        this.num_elem++;
        return new_no;
    }


    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return this.num_elem == 0;
    }

    @Override
    public void mostrar() {
        // TODO Auto-generated method stub
        int a = this.altura(root);
        double b = 2;
        String[][] arr = new String[a+1][(int) Math.pow(b, a + 1)];
        printTree(root, 0,(int) Math.pow(b, a + 1)/2,arr);
        for (int i = 0; i < a + 1; i++) {
            for (int j = 0; j < (int) Math.pow(b, a + 1); j++) {
                if(arr[i][j]!=null){
                    System.out.printf("%3s" ,arr[i][j]);
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    private void printTree(No<t> node, int linha, int col, String[][] arr) {
        if(node==null){
            return;
        }

        
        arr[linha][col] = (t) node.getValue() + "[" + node.getFB() + "]";

        int colSkip = (int) Math.pow(2, arr.length - linha - 2);


        if(node.getLeftChild() != null){
           printTree(node.getLeftChild(), linha + 1, col - colSkip, arr);
        }

        // if((int)node.getValue()>col){
        //     arr[profundidade(node)][(int)node.getValue()%col] = node.getValue();         
        // }else{
        // }
        
        if(node.getRightChild() != null){
           printTree(node.getRightChild(), linha + 1, col + colSkip, arr);    
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

    // private void atualizadorFB(No<t> pai, int balanceadorInsert) {
    //     if (pai == null) {
    //         return;
    //     }
    //     final var valorAtualizado = pai.getFB() + balanceadorInsert;
    //     pai.setFB(valorAtualizado);

    //     while (pai.getFB() != 0 && pai.getFather() != null) {
    //         pai = pai.getFather();
    //         final var FBNode = pai.getFB();
    //         pai.setFB(FBNode + balanceadorInsert);
    //     }

    //     // atualizadorFB(pai.getFather(), balanceadorInsert);
    // }   
    
    @Override
    public Iterator<No<t>> nos() {
        // TODO Auto-generated method stub
        buildMatriz(root);
        return (Iterator<No<t>>) this.list.iterator();
    }

    @Override
    public No<t> pesquisar(No<t> no, t key) {
        // TODO Auto-generated method stub
        if(!no.Isinternal()){
            return no;
        }
        if(no.getValue() == key){
             return no;
        }
        int coef = this.getComparador().compare(no, new No<t>(key));
        if (coef > 0) {
            if (no.getLeftChild()==null) {
                return no;
            }
            return pesquisar(no.getLeftChild(),key);
        }else{
            if (no.getRightChild()==null) {
                return no;
            }
            return pesquisar(no.getRightChild(),key);
        }

        // No<t> ret = pesquisar(no.getRightChild(),key);
        // if(ret!=null){
        //     return ret;
        // }else{
        //     return pesquisar(no.getLeftChild(), key);
        // }
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
            return 1 + profundidade(no.getFather());
        }
    }

    @Override
    public No<t> remover(t key) {
         // TODO Auto-generated method stub
         No<t> pai;
         No<t> atual = pesquisar(root, key);
         pai = atual.getFather();
         t valorRemovido = atual.getValue();
         if (atual.getLeftChild() == null && atual.getRightChild() == null) {
            return remocaoCaso(1,atual);
         }
         if(atual.getLeftChild() == null ^ atual.getRightChild() == null){
            return remocaoCaso(2, atual);
         }
         if (atual.getLeftChild() != null && atual.getRightChild() != null) {
            return remocaoCaso(0, atual);
         }
         /*Nesse escopo inicia a busca pelo sucessor do no */
         // no a ser removido é um no folha
         // if (atual.getLeftChild() == null && atual.getRightChild() == null) {
         //     if (pai == null) {
         //         root = null; // Remover a raiz
         //     } else{
         //         if (atual == pai.getLeftChild()) {
         //            pai.setLeftChild(null);
         //        } else {
         //            pai.setRightChild(null);
         //        }
         //     }
         // }
         // // no a ser removido tem apenas um filho
         // else{
         //     if (atual.getLeftChild() == null || atual.getRightChild() == null) {
         //         No<t> filho = (atual.getLeftChild() != null) ? atual.getLeftChild() : atual.getRightChild();
         //         if (pai == null) {// pro caso do do pai ser o root
         //             root = filho; // O filho se torna a nova raiz
         //         } else{
         //             if (atual == pai.getLeftChild()) {
         //                 pai.setLeftChild(filho);
         //             } else {
         //                 pai.setRightChild(filho);
         //             }
         //         } 
         //     }
         //     // no a ser removido tem dois filhos
         //     else {
         //         No<t> sucessor = atual.getRightChild();
         //         while (sucessor.getLeftChild() != null) {
         //            sucessor = sucessor.getLeftChild();    
         //         }
         //         t valorSucessor = sucessor.getValue();
         //         remover(sucessor.getValue()); // remove recursivamente o sucessor
         
         //         atual.setValue(valorSucessor);
         //     }
         // } 
         return pai;
    }    

    private No<t> remocaoCaso(int casoRemocao, No<t> node){
        No<t> pai = node.getFather();
        switch (casoRemocao) {
            case 1:
                if (pai == null) {
                    root = null; // Remover a raiz
                } else {
                    if (node == pai.getLeftChild()) {
                        pai.setLeftChild(null);
                        // pai.setFB(pai.getFB() - 1);
                    } else {
                        pai.setRightChild(null);
                        // pai.setFB(pai.getFB() + 1);
                    }
                }
                return pai;
            case 2:
                final var filho = (node.getLeftChild() != null) ? node.getLeftChild() : node.getRightChild();
                if (pai == null) {// pro caso do do pai ser o root
                    root = filho; // O filho se torna a nova raiz
                } else {
                    if (node == pai.getLeftChild()) {
                        pai.setLeftChild(filho);
                        // pai.setFB(pai.getFB() - 1);
                    } else {
                        pai.setRightChild(filho);
                        // pai.setFB(pai.getFB() + 1);
                    }
                }
                filho.setFather(pai);
                node.setFather(null);
                return pai;
           default:
               No<t> sucessor = node.getRightChild();
               while (sucessor.getLeftChild() != null) {
                  sucessor = sucessor.getLeftChild();
               }
               final var valorSucessor = sucessor.getValue();
               remover(valorSucessor);
               node.setValue(valorSucessor);
               return node;
        }   
   }
    
    
    @Override
    public void setComparator(Comparador<t> c) {
        // TODO Auto-generated method stub
        this.comp = c;
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
