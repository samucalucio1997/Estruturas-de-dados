package menorcaminho;

import java.util.ArrayList;
import java.util.List;

import melhorcaminho.ToolUtil;
import melhorcaminho.TupleMatriz;

public class Dijkstra {

    private int[][] grafo; // Representação do grafo
    private int[] distancias; // Distâncias dos nós
    private List<TupleMatriz> visitados; // Nós visitados nuvem

    public Dijkstra() {
        this.distancias = new int[grafo.length];
        this.visitados = new ArrayList<>();
    }

    
    // Implementação do Algoritmo de Dijkstra
    public void encontrarCaminho() {
        //TODO: definir a distancia e inserir    
        final var inicio = ToolUtil.localizaSaida(grafo, 2);
        

    }
    
    public int[][] getGrafo() {
        return grafo;
    }

    public void setGrafo(int[][] grafo) {
        this.grafo = grafo;
    }

}
