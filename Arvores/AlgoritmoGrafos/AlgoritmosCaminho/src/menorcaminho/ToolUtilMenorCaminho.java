package menorcaminho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import melhorcaminho.TupleMatriz;

public class ToolUtilMenorCaminho {

    /**
     * Retorna uma lista com todos os nós válidos (não obstáculos).
     * Inclui início (2), fim (3) e caminhos livres (0).
     */
    public static List<TupleMatriz> preencherNonVisitados(int[][] grafo) {
        final var noNaoVisitados = new ArrayList<TupleMatriz>();
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo[i].length; j++) {
                if (grafo[i][j] != 1) { // Apenas blocos com valor 1 (parede) são ignorados
                    noNaoVisitados.add(new TupleMatriz(i, j));
                }
            }
        }
        return noNaoVisitados;
    }

    public static int[][] initializeDistances(int[][] grafo) {
        final var distancias = new int[grafo.length][];
        for (int i = 0; i < grafo.length; i++) {
            distancias[i] = new int[grafo[i].length];
            for (int j = 0; j < distancias[i].length; j++) {
                distancias[i][j] = Integer.MAX_VALUE;
            }
        }
        return distancias;
    }

    /**
     * Reconstrói o caminho a partir do destino até o início usando o mapa de antecessores.
     */
    public static List<TupleMatriz> reconstruirCaminho(TupleMatriz destino,
                                                       Map<TupleMatriz, TupleMatriz> antecessores) {
        List<TupleMatriz> caminho = new ArrayList<>();
        TupleMatriz atual = destino;
        while (atual != null) {
            caminho.add(0, atual);
            atual = antecessores.get(atual);
        }
        return caminho;
    }

    /**
     * Retorna a instância original de um nó, se ele já existe nas listas.
     */
    public static TupleMatriz buscarNoExistente(TupleMatriz no, List<TupleMatriz> noNaoVisitados, List<TupleMatriz> visitados) {
        for (TupleMatriz existente : noNaoVisitados) {
            if (existente.equals(no)) return existente;
        }
        for (TupleMatriz existente : visitados) {
            if (existente.equals(no)) return existente;
        }
        return null;
    }

}