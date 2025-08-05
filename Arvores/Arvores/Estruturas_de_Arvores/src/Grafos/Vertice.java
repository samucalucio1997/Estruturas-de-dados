package Grafos;

import java.util.List;

public class Vertice<T extends Object> {
  private T elemento;  
  private List<Aresta<T>> arestas;//arestas que cortam o vertice
  
  public Vertice() {}

  public T getElemento() {
    return elemento;
  }
  public void setElemento(T elemento) {
    this.elemento = elemento;
  }
  public List<Aresta<T>> getArestas() {
    return arestas;
  }
  public void setArestas(List<Aresta<T>> arestas) {
    this.arestas = arestas;
  }

  
}
