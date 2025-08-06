package Buscas;

import java.util.List;

public class Vertice {
    private int d;
    private int s;
    private int marcar;
    private List<Vertice> verticesAdjacentes; 

    public Vertice() {
        this.d = 0;
        this.s = 0;
    }

    public int getD() {
        return d;
    }
    public void setD(int d) {
        this.d = d;
    }
    public int getS() {
        return s;
    }
    public void setS(int s) {
        this.s = s;
    }

    public int getMarcar() {
        return marcar;
    }

    public void setMarcar(int marcar) {
        this.marcar = marcar;
    }

    public List<Vertice> getVerticesAdjacentes() {
        return verticesAdjacentes;
    }

    public void setVerticesAdjacentes(List<Vertice> verticesAdjacentes) {
        this.verticesAdjacentes = verticesAdjacentes;
    }
    
    
}
