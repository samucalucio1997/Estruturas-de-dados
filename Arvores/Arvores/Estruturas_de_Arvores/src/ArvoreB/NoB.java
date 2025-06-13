package ArvoreB;

public class NoB<T extends Object> {
    private int t;// ordem
    private T[] chaves;
    private NoB<T>[] filhos;
    private NoB<T> pai;

    public NoB(int t) {
        this.t = t;
        this.chaves = (T[]) new Object[2*t - 1];
        this.filhos = new NoB[2*t];
    }

    public int getT() {
        return t;
    }
    public void setT(int t) {
        this.t = t;
    }
    public T[] getChaves() {
        return chaves;
    }
    public void setChaves(T[] chaves) {
        this.chaves = chaves;
    }
    public NoB<T>[] getFilhos() {
        return filhos;
    }
    public void setFilhos(NoB<T>[] filhos) {
        this.filhos = filhos;
    }
    public NoB<T> getPai() {
        return pai;
    }
    public void setPai(NoB<T> pai) {
        this.pai = pai;
    }
}
