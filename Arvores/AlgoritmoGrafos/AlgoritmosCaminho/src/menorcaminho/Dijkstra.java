package menorcaminho;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import melhorcaminho.ToolUtil;
import melhorcaminho.TupleMatriz;

public class Dijkstra {

    private int[][] grafo; // Representação do grafo
    private int[][] distancias; // Distâncias dos nós
    private List<TupleMatriz> visitados; // Nós visitados nuvem
    private List<TupleMatriz> noNaoVisitados; 
    private Map<TupleMatriz,TupleMatriz> antecessores;

    public Dijkstra(int[][] grafo) {
        this.grafo = grafo;
        this.distancias = new int[grafo.length][];
        this.visitados = new ArrayList<>();        
        this.noNaoVisitados = new ArrayList<>();
        antecessores = new HashMap<>();
    }

    // Implementação do Algoritmo de Dijkstra
    public void encontrarCaminho() {
        // TODO 1: Localizar o nó inicial (valor 2 no grafo)
        final var inicio = ToolUtil.localizaSaida(grafo, 2);

        // TODO 2: Inicializar distâncias com infinito (Integer.MAX_VALUE) e setar 0 no início
        // distancias[inicio.getordenada()][inicio.getabscissa()] = 0;
        inicio.setG(0);

        // TODO 3: Inicializar lista de não visitados com todos os nós válidos (por exemplo, != 1)
        noNaoVisitados = ToolUtilMenorCaminho.preencherNonVisitados(grafo);
        noNaoVisitados.sort(Comparator.comparingInt(n -> n.getG()));

        // TODO 4: Inicializar o mapa de antecessores, se for reconstruir o caminho

        while (!noNaoVisitados.isEmpty()) {
            // TODO 5: Escolher o nó w ∈ noNaoVisitados com menor distâncias[y][x]
            TupleMatriz atual = noNaoVisitados.remove(0);

            // TODO 6: Remover o nó atual de noNaoVisitados e adicioná-lo a visitados
            visitados.add(atual);

            // TODO 7: Para cada vizinho válido de "atual"
            for (TupleMatriz vizinho : ToolUtil.vizinhosValidos(atual, grafo)) {
            //     Se vizinho ∉ visitados, calcular nova distância via "atual"
                if (!visitados.contains(vizinho)) {
                    final var distAtual = vizinho.getG() + 1;

                    if (distAtual < vizinho.getG()) {
                        vizinho.setG(distAtual);
                    }
                }
            //     Se nova distância < distância atual do vizinho
            //         Atualizar distâncias
            //         Atualizar antecessor
            }
        }

        // TODO 8 (opcional): Reconstruir o caminho mínimo usando o mapa de antecessores
    }
    
    public int[][] getGrafo() {
        return grafo;
    }

    public void setGrafo(int[][] grafo) {
        this.grafo = grafo;
    }

    public Map<TupleMatriz, TupleMatriz> getAntecessores() {
        return antecessores;
    }

}
