package Grafos;

import java.util.List;

public class Aresta<T extends Object> {
    private List<Vertice<T>> vertices;
    private T value;

    public List<Vertice<T>> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertice<T>> vertices) {
        this.vertices = vertices;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
