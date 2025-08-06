package Buscas;

import java.util.List;

public class Teste {
    public static void main(String[] args) {
        final var vertice1 = new Vertice();
        final var vertice2 = new Vertice();
        final var vertice3 = new Vertice();
        final var vertice4 = new Vertice();
        final var vertice5 = new Vertice();
        final var vertice6 = new Vertice();
        vertice1.setVerticesAdjacentes(List.of(vertice2, vertice4));
        vertice2.setVerticesAdjacentes(List.of(vertice4));
        vertice5.setVerticesAdjacentes(List.of(vertice3));
        vertice4.setVerticesAdjacentes(List.of(vertice2));
        vertice6.setVerticesAdjacentes(List.of(vertice6));
        new DFS();
        DFS.buscar(null);
    }
}
