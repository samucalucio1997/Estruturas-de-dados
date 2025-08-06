package Buscas;

import java.util.List;

public class DFS {
    private static int t;

    
    static {
        t = 0;
    }
    
    public static void buscar(List<Vertice> vertices) {
        for (Vertice vertice : vertices) {
            if (vertice.getMarcar() == 0) {
                DFSVertice(vertice);
            }
        }  
    }
    
    private static void DFSVertice(Vertice vertice) {
        vertice.setMarcar(-1);
        incrementaT();
        vertice.setD(getT());
        for (Vertice verticeIterado : vertice.getVerticesAdjacentes()) {
            if (verticeIterado.getMarcar() == 0) {
                DFSVertice(vertice);
            }
        }
        
        vertice.setMarcar(1);
        incrementaT();
        vertice.setS(getT());
    }
    
    private static void incrementaT(){
        t++;
    }

    public static int getT() {
        return t;
    }
    
    public static void setT(int t) {
        DFS.t = t;
    }
}