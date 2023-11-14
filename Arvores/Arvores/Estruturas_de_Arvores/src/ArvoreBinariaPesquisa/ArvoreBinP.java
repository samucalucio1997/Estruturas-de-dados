package ArvoreBinariaPesquisa;

public class ArvoreBinP<t> implements IArvoreBinariaPesquisa<t>{
    
    private no<t> root;
    private Comparador<t> comp = new Comparador<>();

    public ArvoreBinP(no<t> root) {
        this.root = root;
    }
    //altura(no.getLeftChild())
    //altura(no.getRightChild())
    @Override
    public int altura(no<t> no) {
        // TODO Auto-generated method stub
        if(no==null||no.equals(getRaiz())){
            return 0;
        }else{
            int p=altura(no.getFather());
            return 1 + p; 
        }
    }

    @Override
    public Iterator<t> elements() {
        // TODO Auto-generated method stub
        return null;
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
                    if(curNo.getRightChild()!=null){
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
        return curNo;
    }


    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void mostrar() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Iterator<t> nos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public no<t> pesquisar(no<t> no, t key) {
        // TODO Auto-generated method stub
        if(no==null){
            throw new RuntimeException("Não encontrado");
        }
        if(no.getValue().equals(key)){
             return no;
        }
        else{
            no<t> ret = pesquisar(no.getLeftChild(), key);
            ret = !ret.getValue().equals(key)?pesquisar(no.getRightChild(), key):ret;
            return ret;
        }
    }

    @Override
    public void posOrdem(no<t> no) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void preOrdem(no<t> no) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int profundidade(no<t> no) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public t remover(t key) {
        // TODO Auto-generated method stub
        return null;
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
        return 0;
    }

    
}
