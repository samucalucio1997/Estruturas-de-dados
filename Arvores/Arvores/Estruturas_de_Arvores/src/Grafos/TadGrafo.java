package Grafos;

import java.util.Collection;
import java.util.List;

public interface TadGrafo<T extends Object> {

    List<Vertice<T>> finalVertices(Aresta aresta);

    Vertice<T> oposto(Vertice<T> vertice, Aresta aresta);

    boolean isAdjacente(Vertice<T> vertice1, Vertice<T> vertice2);

    void substituir(Vertice<T> verticeSubstituido, Vertice<T> verticeSubstituto);

    void substituir(Aresta arestaSubstituida, Aresta arestaSubstituta);

    Vertice<T> inserirVertice(T o);

    Aresta inserirAresta(Vertice<T> verticeInsert, Vertice<T> verticeInicio, Vertice<T> verticeFim);

    T removerVertice(Vertice<T> vertice);

    Aresta removerAresta(Aresta aresta);

    Collection<Aresta> arestasIncidentes(Vertice<T> vertice);

    Collection<Aresta> arestas();

    Collection<Vertice<T>> vertices();

}
