package Grafos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class GrafoSimples<T> implements TadGrafo<T> {

    private List<Vertice<T>> vertices;

    public GrafoSimples() {}

    @Override
    public Collection<Aresta<T>> arestas() {
        // TODO Auto-generated method stub
        final var arestas = new ArrayList<Aresta<T>>();
        final var listArestas = vertices.stream().map(Vertice::getArestas).collect(Collectors.toList());

        return null;
    }

    @Override
    public Collection<Aresta<T>> arestasIncidentes(Vertice<T> vertice) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Vertice<T>> finalVertices(Aresta<T> aresta) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Aresta<T> inserirAresta(Vertice<T> verticeInsert, Vertice<T> verticeInicio, T valorAresta) {
        // TODO Auto-generated method stub
        final var aresta = new Aresta<T>();
        aresta.setValue(valorAresta);
        verticeInsert.getArestas().add(aresta);
        verticeInicio.getArestas().add(aresta);
        aresta.getVertices().add(verticeInicio);
        aresta.getVertices().add(verticeInsert);
        return null;
    }

    @Override
    public Vertice<T> inserirVertice(T o) {
        // TODO Auto-generated method stub
        final var vertice = new Vertice<T>();
        vertice.setElemento(o);
        
        return null;
    }

    @Override
    public boolean isAdjacente(Vertice<T> vertice1, Vertice<T> vertice2) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Vertice<T> oposto(Vertice<T> vertice, Aresta<T> aresta) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Aresta<T> removerAresta(Aresta<T> aresta) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T removerVertice(Vertice<T> vertice) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void substituir(Vertice<T> verticeSubstituido, Vertice<T> verticeSubstituto) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void substituir(Aresta<T> arestaSubstituida, Aresta<T> arestaSubstituta) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Collection<Vertice<T>> vertices() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Vertice<T>> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertice<T>> vertices) {
        this.vertices = vertices;
    }
}
