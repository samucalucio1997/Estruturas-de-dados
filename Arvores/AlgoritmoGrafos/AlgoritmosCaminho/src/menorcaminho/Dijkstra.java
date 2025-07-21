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
    private List<TupleMatriz> caminhoFinal;

    public Dijkstra(int[][] grafo) {
        this.grafo = grafo;
        this.visitados = new ArrayList<>();        
        this.noNaoVisitados = new ArrayList<>();
        antecessores = new HashMap<>();
    }

    // Implementação do Algoritmo de Dijkstra
    public void encontrarCaminho() {
        // Localiza o nó inicial (valor 2 no grafo)
        final var inicio = ToolUtil.localizador(grafo, 2);
        
        inicio.setG(0); // Custo inicial é 0

        // 2. Preenche os nós válidos com valor de G infinito
        noNaoVisitados = ToolUtilMenorCaminho.preencherNonVisitados(grafo);
        for (TupleMatriz no : noNaoVisitados) {
            if (!no.equals(inicio)) {
                no.setG(Integer.MAX_VALUE);
            }
        }

        // 3. Ordena a lista para garantir que o menor custo venha primeiro
        noNaoVisitados.sort(Comparator.comparingDouble(TupleMatriz::getG));

        // 5. Laço principal do Dijkstra
        while (!noNaoVisitados.isEmpty()) {
            // 5.1 Pega o nó com menor custo atual
            TupleMatriz atual = noNaoVisitados.remove(0);
            visitados.add(atual);

            // 5.2 Para cada vizinho do nó atual
            for (TupleMatriz vizinho : ToolUtil.vizinhosValidos(atual, grafo, getTodosOsNos())) {
                TupleMatriz vizinhoOriginal = ToolUtilMenorCaminho.buscarNoExistente(vizinho, noNaoVisitados, visitados);

                if (!visitados.contains(vizinho)) {
                    final var novaDistancia = atual.getG() + (atual.isDiagonal() ? 1.4 : 1); // Ou o peso real da aresta, se houver

                    if (novaDistancia < vizinho.getG()) {
                        vizinhoOriginal.setG(novaDistancia);
                        antecessores.put(vizinhoOriginal, atual);
                    }
                }
            }

            noNaoVisitados.sort(Comparator.comparingDouble(TupleMatriz::getG));
        }

        TupleMatriz destino = ToolUtil.localizador(grafo, 3);
        TupleMatriz destinoReal = ToolUtilMenorCaminho.buscarNoExistente(destino,noNaoVisitados,visitados);
        caminhoFinal = ToolUtilMenorCaminho.reconstruirCaminho(destinoReal, antecessores);

        System.out.println("Caminho mínimo:");
        for (TupleMatriz passo : caminhoFinal) {
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

    public List<TupleMatriz> getCaminhoFinal() {
        return caminhoFinal;
    }

    private List<TupleMatriz> getTodosOsNos() {
        List<TupleMatriz> todos = new ArrayList<>();
        todos.addAll(noNaoVisitados);
        todos.addAll(visitados);
        return todos;
    }

}
