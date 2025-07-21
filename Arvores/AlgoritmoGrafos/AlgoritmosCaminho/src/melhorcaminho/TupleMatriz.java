package melhorcaminho;

import java.util.Objects;

public class TupleMatriz {
    private int abscissa;
    private int ordenada;
    private double f; // Função f(n) = g(n) + h(n)
    private double g; // Custo do caminho do nó inicial até o nó n
    private double h; // Estimativa do custo do caminho do nó n até o nó objetivo 
    private TupleMatriz pai; // Referência ao nó pai para reconstrução do caminho
    private boolean isDiagonal;
   
    public TupleMatriz(int abscissa, int ordenada) {
        this.abscissa = abscissa;
        this.ordenada = ordenada;
    }

    public double getF() {
        return f;
    }

    public TupleMatriz() {
        this.abscissa = 0;
        this.ordenada = 0;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public int getabscissa() {
        return abscissa;
    }
    public void setabscissa(int abscissa) {
        this.abscissa = abscissa;
    }
    public int getordenada() {
        return ordenada;
    }
    public void setordenada(int ordenada) {
        this.ordenada = ordenada;
    }

    public TupleMatriz getPai() {
        return pai;
    }

    public void setPai(TupleMatriz pai) {
        this.pai = pai;
    }

     public void calculaF() {
        this.f = getG() + getH();
    }

     @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TupleMatriz)) return false;
        TupleMatriz other = (TupleMatriz) obj;
        return this.abscissa == other.abscissa && this.ordenada == other.ordenada;
    }

    @Override
    public int hashCode() {
        return Objects.hash(abscissa, ordenada);
    }


    public boolean isDiagonal() {
        return isDiagonal;
    }

    public void setDiagonal(boolean isDiagonal) {
        this.isDiagonal = isDiagonal;
    }
}
