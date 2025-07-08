package Grafos;

import java.util.List;

public interface TadGrafo {

    List<Vertice> finalVertices(Aresta aresta);

    Vertice oposto(Vertice vertice, Aresta aresta);

    boolean isAdjacente(Vertice vertice1, Vertice vertice2);

    void substituir(Vertice verticeSubstituido, Vertice verticeSubstituto);

    void substituir(Aresta arestaSubstituida, Aresta arestaSubstituta);

    void inserirVertice();

}
