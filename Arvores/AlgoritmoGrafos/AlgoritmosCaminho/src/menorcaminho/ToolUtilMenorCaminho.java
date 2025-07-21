package menorcaminho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import melhorcaminho.TupleMatriz;

public class ToolUtilMenorCaminho {

    public static List<TupleMatriz> preencherNonVisitados(int[][] grafo){
        final var noNaoVisitados = new ArrayList<TupleMatriz>();
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo[i].length; j++) {
                if (grafo[i][j] != 2) {
                    noNaoVisitados.add(new TupleMatriz(i, j));
                }
            }
        }
        return noNaoVisitados;
    }

    public static int[][] initializeDistances(int[][] grafo){
        final var distancias = new int[grafo.length][];
        for (int i = 0; i < grafo.length; i++) {
            distancias[i] =  new int[grafo[i].length];
            for (int j = 0; j < distancias[i].length; j++) {
                distancias[i][j] = Integer.MAX_VALUE;
            }
        }
        return distancias;
    }

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
