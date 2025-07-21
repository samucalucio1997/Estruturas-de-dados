package melhorcaminho;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlgoritmoEstrela {

    private int[][] grafo; // Representação do grafo
    private List<TupleMatriz> noNaoVisitados; // Lista para armazenar o caminho encontrado
    private List<TupleMatriz> noVisitados; // Lista para armazenar os nós visitados
    private List<TupleMatriz> caminhoFinal;

    

    public AlgoritmoEstrela() {
        this.noNaoVisitados = new ArrayList<>();
        this.noVisitados = new ArrayList<>();
        caminhoFinal =  new ArrayList<>();
    }

    // Implementação do Algoritmo A* (A Estrela)
    // f(n) = g(n) + h(n)
    // onde:
    // g(n) é o custo do caminho do nó inicial até o nó n
    // h(n) é a estimativa do custo do caminho do nó n até o nó objetivo
    public void encontrarCaminho() {
        final var saida = ToolUtil.localizador(grafo, 2);
        final var chegada = ToolUtil.localizador(grafo, 3);

        saida.setG(0);
        saida.setH(ToolUtil.heuristica(saida, chegada));
        saida.calculaF();

        noNaoVisitados.add(saida);

        while (!noNaoVisitados.isEmpty()) {
            noNaoVisitados.sort(Comparator.comparingInt(TupleMatriz::getF).thenComparingInt(TupleMatriz::getG)); // pega o com menor f
            final var atual = noNaoVisitados.remove(0);

            if (atual.getabscissa() == chegada.getabscissa() && atual.getordenada() == chegada.getordenada()) {
                ToolUtil.reconstruirCaminho(atual, caminhoFinal); // essa lista é o caminho final
                return;
            }

            noVisitados.add(atual);

            for (TupleMatriz vizinho : ToolUtil.vizinhosValidos(atual, grafo)) {
                if (noVisitados.contains(vizinho))
                    continue;

                int gNovo = atual.getG() + 1;

                boolean melhorCaminho = !noNaoVisitados.contains(vizinho) || gNovo < vizinho.getG();

                if (melhorCaminho) {
                    vizinho.setPai(atual);
                    vizinho.setG(gNovo);
                    vizinho.setH(ToolUtil.heuristica(vizinho, chegada));
                    vizinho.calculaF();

                    if (!noNaoVisitados.contains(vizinho)) {
                        noNaoVisitados.add(vizinho);
                    }
                }
            }
        }

        System.out.println("Caminho não encontrado.");
    }

    public List<TupleMatriz> getNoNaoVisitados() {
        return noNaoVisitados;
    }

    public List<TupleMatriz> getNoVisitados() {
        return noVisitados;
    }

    public int[][] getGrafo() {
        return grafo;
    }

    public void setGrafo(int[][] grafo) {
        this.grafo = grafo;
    }

    public List<TupleMatriz> getCaminhoFinal() {
        return caminhoFinal;
    }


}
