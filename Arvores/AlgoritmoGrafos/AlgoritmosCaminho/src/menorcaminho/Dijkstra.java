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
       // 1. Localiza o nó inicial (valor 2 no grafo)
    final var inicio = ToolUtil.localizaSaida(grafo, 2);
    inicio.setG(0); // Custo inicial é 0

    // 2. Preenche os nós válidos com valor de G infinito
    noNaoVisitados = ToolUtilMenorCaminho.preencherNonVisitados(grafo);
    for (TupleMatriz no : noNaoVisitados) {
        if (!no.equals(inicio)) {
            no.setG(Integer.MAX_VALUE);
        }
    }

    // 3. Ordena a lista para garantir que o menor custo venha primeiro
    noNaoVisitados.sort(Comparator.comparingInt(TupleMatriz::getG));

    // 4. Inicia a lista de antecessores
    antecessores = new HashMap<>();

    // 5. Laço principal do Dijkstra
    while (!noNaoVisitados.isEmpty()) {
        // 5.1 Pega o nó com menor custo atual
        TupleMatriz atual = noNaoVisitados.remove(0);
        visitados.add(atual);

        // 5.2 Para cada vizinho do nó atual
        for (TupleMatriz vizinho : ToolUtil.vizinhosValidos(atual, grafo)) {
            if (!visitados.contains(vizinho)) {
                int novaDistancia = atual.getG() + 1; // Ou o peso real da aresta, se houver

                if (novaDistancia < vizinho.getG()) {
                    vizinho.setG(novaDistancia);
                    antecessores.put(vizinho, atual);
                }
            }
        }

        // 5.3 Reordena os não visitados com base no custo G atualizado
        noNaoVisitados.sort(Comparator.comparingInt(TupleMatriz::getG));
    }

    // 6. Reconstrói o caminho até o destino (valor 3 no grafo)
    TupleMatriz destino = ToolUtil.localizaSaida(grafo, 3);
    List<TupleMatriz> caminho = ToolUtilMenorCaminho.reconstruirCaminho(destino, antecessores);

    // 7. Imprime o caminho
    System.out.println("Caminho mínimo:");
    for (TupleMatriz passo : caminho) {
        System.out.println(passo.getG() + ":" + passo.getabscissa() + "," + passo.getordenada());
    }
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

    public List<TupleMatriz> getVisitados() {
        return visitados;
    }

}
