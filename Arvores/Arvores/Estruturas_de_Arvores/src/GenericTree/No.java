package GenericTree;

import java.util.ArrayList;

public class No<t> {
    private No<t> father;
    private ArrayList<No<t>> filhos;
    private t value;
    
    
    public No(t value) {
        this.value = value;
        filhos = new ArrayList<>();
    }
    

    public t getValue() {
        return value;
    }
    
    
    public void setValue(t value) {
        this.value = value;
    }
    
    
    public No<t> getFather() {
        return father;
    }
    
    
    public void setFather(No<t> father) {
        this.father = father;
    }


    public ArrayList<No<t>> getFilhos() {
        return filhos;
    }

    
    public void adicionarNoint(No<t> elemtNo){
          this.getFilhos().add(elemtNo);
    }




    public void setLista(ArrayList<No<t>> filhos) {
        this.filhos = filhos;
    }    
    
}
