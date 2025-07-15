package Grafos;

import java.util.Collection;
import java.util.List;

import lombok.Data;

@Data
public class GrafoSimples<T> implements TadGrafo<T> {

    private List<Vertice<T>> vertices;

    public GrafoSimples(T numVertices) {}

    @Override
    public Collection<Aresta> arestas() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<Aresta> arestasIncidentes(Vertice<T> vertice) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Vertice<T>> finalVertices(Aresta aresta) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Aresta inserirAresta(Vertice<T> verticeInsert, Vertice<T> verticeInicio, Vertice<T> verticeFim) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Vertice<T> inserirVertice(T o) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isAdjacente(Vertice<T> vertice1, Vertice<T> vertice2) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Vertice<T> oposto(Vertice<T> vertice, Aresta aresta) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Aresta removerAresta(Aresta aresta) {
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
    public void substituir(Aresta arestaSubstituida, Aresta arestaSubstituta) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Collection<Vertice<T>> vertices() {
        // TODO Auto-generated method stub
        return null;
    }

    

}
