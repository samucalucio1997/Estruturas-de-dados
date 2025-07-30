package menorcaminho;

import java.util.*;
import melhorcaminho.ToolUtil;
import melhorcaminho.TupleMatriz;

public class Dijkstra {

    private int[][] grafo;
    private Map<TupleMatriz, TupleMatriz> mapaNos;
    private List<TupleMatriz> visitados;
    private List<TupleMatriz> naoVisitados;
    private Map<TupleMatriz, TupleMatriz> antecessores;
    private List<TupleMatriz> caminhoFinal;

    public Dijkstra(int[][] grafo) {
        this.grafo = grafo;
        this.mapaNos = construirMapaNos(grafo);
        this.visitados = new ArrayList<>();
        this.naoVisitados = new ArrayList<>(mapaNos.values());
        this.antecessores = new HashMap<>();
    }

    public void encontrarCaminho() {
        TupleMatriz inicio = mapaNos.get(ToolUtil.localizador(grafo, 2));
        TupleMatriz destino = mapaNos.get(ToolUtil.localizador(grafo, 3));

        if (inicio == null || destino == null) {
            System.out.println("Erro: início ou destino não encontrados.");
            return;
        }

        inicio.setG(0);

        for (TupleMatriz no : naoVisitados) {
            if (!no.equals(inicio)) {
                no.setG(Double.POSITIVE_INFINITY);
            }
        }

        naoVisitados.sort(Comparator.comparingDouble(TupleMatriz::getG));

        while (!naoVisitados.isEmpty()) {
            TupleMatriz atual = naoVisitados.remove(0);
            visitados.add(atual);

            if (atual.equals(destino)) {
                break;
            }

            for (TupleMatriz vizinho : ToolUtil.vizinhosValidos(atual, grafo, mapaNos)) {
                if (!visitados.contains(vizinho)) {
                    double novaDistancia = atual.getG() + (vizinho.isDiagonal() ? 1.4 : 1);
                    if (novaDistancia < vizinho.getG()) {
                        vizinho.setG(novaDistancia);
                        antecessores.put(vizinho, atual);
                    }
                }
            }

            naoVisitados.sort(Comparator.comparingDouble(TupleMatriz::getG));
        }

        final var destinoReal = ToolUtilMenorCaminho.buscarNoExistente(destino, naoVisitados, visitados);

        caminhoFinal = ToolUtilMenorCaminho.reconstruirCaminho(destinoReal, antecessores);

        System.out.println("Caminho mínimo:");
        for (TupleMatriz passo : caminhoFinal) {
            System.out.println(passo.getG() + ":" + passo.getabscissa() + "," + passo.getordenada());
        }
    }

    public List<TupleMatriz> getCaminhoFinal() {
        return caminhoFinal;
    }

    public Map<TupleMatriz, TupleMatriz> getAntecessores() {
        return antecessores;
    }

    private Map<TupleMatriz, TupleMatriz> construirMapaNos(int[][] grafo) {
        Map<TupleMatriz, TupleMatriz> mapa = new HashMap<>();
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo[0].length; j++) {
                if (grafo[i][j] != 1) {
                    TupleMatriz no = new TupleMatriz(i, j);
                    mapa.put(no, no);
                }
            }
        }
        return mapa;
    }
}
