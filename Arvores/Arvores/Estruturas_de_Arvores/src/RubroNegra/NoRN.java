package RubroNegra;

import ArvoreBinariaPesquisa.No;

public class NoRN<T extends Object> extends No<T> {
  private Cor cor;

  public NoRN(T value) {
    super(value);
    this.cor = Cor.RUBRO;
  }

  @Override
  public NoRN<T> getFather() {
    // TODO Auto-generated method stub
    return (NoRN<T>) super.getFather();
  }

  @Override
  public NoRN<T> getLeftChild() {
    // TODO Auto-generated method stub
    return (NoRN<T>) super.getLeftChild();
  }

  @Override
  public NoRN<T> getRightChild() {
    // TODO Auto-generated method stub
    return (NoRN<T>) super.getRightChild();
  }

  @Override
  public void setFather(No<T> father) {
    // TODO Auto-generated method stub
    super.setFather(father);
  }

  @Override
  public void setLeftChild(No<T> leftChild) {
    // TODO Auto-generated method stub
    super.setLeftChild(leftChild);
  }

  @Override
  public void setRightChild(No<T> rightChild) {
    // TODO Auto-generated method stub
    super.setRightChild(rightChild);
  }

  public Cor getCor() {
    return cor;
  }

  public void setCor(Cor cor) {
    this.cor = cor;
  }
}
