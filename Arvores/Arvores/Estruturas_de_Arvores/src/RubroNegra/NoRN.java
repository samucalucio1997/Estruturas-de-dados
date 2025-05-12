package RubroNegra;

import ArvoreBinariaPesquisa.No;

public class NoRN<T extends Object> extends No<T> {
  private NoRN<T> father;
  private NoRN<T> leftChild;
  private NoRN<T> rightChild;
  private Cor cor;

  public NoRN(T value) {
    super(value);
    this.cor = Cor.RUBRO;
  }

  public NoRN<T> getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(NoRN<T> leftChild) {
    this.leftChild = leftChild;
  }

  public NoRN<T> getRightChild() {
    return rightChild;
  }

  public void setRightChild(NoRN<T> rightChild) {
    this.rightChild = rightChild;
  }

  public Cor getCor() {
    return cor;
  }

  public void setCor(Cor cor) {
    this.cor = cor;
  }

  public NoRN<T> getFather() {
    return father;
  }

  public void setFather(NoRN<T> father) {
    this.father = father;
  }
}
