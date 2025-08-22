package Buscas;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BFS {
    private Queue<Vertice> fila;

    public BFS() {
        this.fila = new PriorityQueue<Vertice>();
    }

    public void buscar(List<Vertice> vertices) {
        if (vertices.isEmpty()) {
            return;
        }
        fila.add(vertices.get(0));
        while (!fila.isEmpty()) {
            final var primeiroFila = fila.poll();
            for (Vertice vertice : primeiroFila.getVerticesAdjacentes()) {
                if (vertice.getMarcar() == 0) {
                    vertice.setD(primeiroFila.getD() + 1);
                    vertice.setMarcar(-1);
                    fila.add(vertice);
                }
            }
            primeiroFila.setD(1);
        }
    }

    public Queue<Vertice> getFila() {
        return fila;
    }

    public void setFila(Queue<Vertice> fila) {
        this.fila = fila;
    }

}
