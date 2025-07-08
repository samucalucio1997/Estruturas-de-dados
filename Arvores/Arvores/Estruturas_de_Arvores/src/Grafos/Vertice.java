package Grafos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vertice<T extends Object> {
  private T elemento;  
  private List<Aresta> arestas;//arestas que cortam o vertice
}
