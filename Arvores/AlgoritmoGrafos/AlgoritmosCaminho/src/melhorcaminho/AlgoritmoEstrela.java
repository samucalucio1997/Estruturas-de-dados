package melhorcaminho;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AlgoritmoEstrela {

    private int[][] grafo; // Representação do grafo
    private List<TupleMatriz> naoProcessados;
    private List<TupleMatriz> processados; // Lista para armazenar os nós visitados
    private List<TupleMatriz> caminhoFinal;

    

    public AlgoritmoEstrela() {
        this.naoProcessados = new ArrayList<>();
        this.processados = new ArrayList<>();
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

        naoProcessados.add(saida);

        while (!naoProcessados.isEmpty()) {
            naoProcessados.sort(Comparator.comparingDouble(TupleMatriz::getF).thenComparingDouble(TupleMatriz::getG)); // pega o com menor f
            final var atual = naoProcessados.remove(0);

            if (atual.getabscissa() == chegada.getabscissa() && atual.getordenada() == chegada.getordenada()) {
                ToolUtil.reconstruirCaminho(atual, caminhoFinal); // essa lista é o caminho final
                return;
            }

            processados.add(atual);

            for (TupleMatriz vizinho : ToolUtil.vizinhosValidos(atual, grafo)) {
                if (processados.contains(vizinho))
                    continue;

                final var gNovo = atual.getG() + 1;

                boolean melhorCaminho = !naoProcessados.contains(vizinho) || gNovo < vizinho.getF();

                if (melhorCaminho) {
                    vizinho.setPai(atual);
                    vizinho.setG(gNovo);
                    vizinho.setH(ToolUtil.heuristica(vizinho, chegada));
                    vizinho.calculaF();

                    if (!naoProcessados.contains(vizinho)) {
                        naoProcessados.add(vizinho);
                    }
                }
            }
        }

        System.out.println("Caminho não encontrado.");
    }

    public List<TupleMatriz> getnaoProcessados() {
        return naoProcessados;
    }

    public List<TupleMatriz> getprocessados() {
        return processados;
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
