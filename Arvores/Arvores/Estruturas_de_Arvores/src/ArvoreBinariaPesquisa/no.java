package ArvoreBinariaPesquisa;

public class no<t> {
    private t value;
    private no<t> father;
    private no<t> leftChild;
    private no<t> RightChild;
    
    public no(t value) {
        this.value = value;
    } 
    
    public t getValue() {
        return value;
    }

    public void setValue(t value) {
        this.value = value;
    }

    public no<t> getFather() {
        return father;
    }

    public void setFather(no<t> father) {
        this.father = father;
    }

    public no<t> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(no<t> leftChild) {
        this.leftChild = leftChild;
    }

    public no<t> getRightChild() {
        return RightChild;
    }

    public void setRightChild(no<t> rightChild) {
        RightChild = rightChild;
    }
    public boolean Isinternal(){
        return this.leftChild!=null||this.RightChild!=null;
    }

}
