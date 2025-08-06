import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import Decisao.Goodman;
import Decisao.Goodman.Vertice;
import melhorcaminho.AlgoritmoEstrela;
import melhorcaminho.ToolUtil;
import melhorcaminho.TupleMatriz;
import menorcaminho.Dijkstra;

public class App {
    public static void main(String[] args) throws Exception {

        // final var verify = new Goodman();

        

        // List<Vertice> listaConexa = List.of();

        // System.out.println(verify.isConexo(listaConexa));

        
        int[][] grafo = ToolUtil.lerMatrizDeArquivo("/home/samuca/Downloads/labirinto.dat");
        // /*
        //  * A Estrela
        //  */
        AlgoritmoEstrela algoritmo = new AlgoritmoEstrela();
        algoritmo.setGrafo(grafo);
        long inicio = System.currentTimeMillis();
        algoritmo.encontrarCaminho();
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (fim - inicio) + " ms");

        System.out.println("Nós visitados: " + algoritmo.getCaminhoFinal().size());

        for (TupleMatriz is : algoritmo.getCaminhoFinal()) {
            System.out.println("Caminho: (" + is.getG() + ", " + is.getF() + ")");
        }
        
        // Imprime o caminho encontrado
        imprimirCaminho(grafo, algoritmo.getCaminhoFinal());

        /*
         * Dijikstra
         */

        
        // Dijkstra algoDijkstra = new Dijkstra(grafo);
        // long inicio = System.currentTimeMillis();
        // algoDijkstra.encontrarCaminho();
        // long fim = System.currentTimeMillis();
        // System.out.println("Tempo de execução: " + (fim - inicio) + " ms");
        
        // final var caminhos = algoDijkstra.getCaminhoFinal();
        // for (TupleMatriz is : caminhos) {
        //     System.out.println(is.getabscissa()+":"+is.getordenada());
        // } 

        // imprimirCaminho(grafo, caminhos);    
    }

    private static void imprimirCaminho(int[][] grafo, List<TupleMatriz> caminho) {
        char[][] visual = new char[grafo.length][grafo[0].length];
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo[0].length; j++) {
                switch (grafo[i][j]) {
                    case 0 -> visual[i][j] = ' ';
                    case 1 -> visual[i][j] = '#';
                    case 2 -> visual[i][j] = 'S';
                    case 3 -> visual[i][j] = 'E';
                }
            }
        }

        for (TupleMatriz p : caminho) {
            if (grafo[p.getabscissa()][p.getordenada()] == 0) {
                visual[p.getabscissa()][p.getordenada()] = '*'; // marca o caminho
            }
        }

        for (char[] linha : visual) {
            System.out.println(new String(linha));
        }
    }
}