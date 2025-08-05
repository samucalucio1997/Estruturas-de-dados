package Grafos;

import java.util.Collection;
import java.util.List;

public interface TadGrafo<T extends Object> {

    List<Vertice<T>> finalVertices(Aresta<T> aresta);

    Vertice<T> oposto(Vertice<T> vertice, Aresta<T> aresta);

    boolean isAdjacente(Vertice<T> vertice1, Vertice<T> vertice2);

    void substituir(Vertice<T> verticeSubstituido, Vertice<T> verticeSubstituto);

    void substituir(Aresta<T> arestaSubstituida, Aresta<T> arestaSubstituta);

    Vertice<T> inserirVertice(T o);

    Aresta<T> inserirAresta(Vertice<T> verticeInsert, Vertice<T> verticeInicio, T valorAresta);

    T removerVertice(Vertice<T> vertice);

    Aresta<T> removerAresta(Aresta<T> aresta);

    Collection<Aresta<T>> arestasIncidentes(Vertice<T> vertice);

    Collection<Aresta<T>> arestas();

    Collection<Vertice<T>> vertices();

}
