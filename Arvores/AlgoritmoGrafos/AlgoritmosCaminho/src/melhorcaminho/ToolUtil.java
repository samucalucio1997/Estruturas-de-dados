package melhorcaminho;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToolUtil {

    // Método utilitário para calcular a função f(n) = g(n) + h(n)
    public static int calcularFuncaoF(int g, int h) {
        return g + h;
    }

    // Método utilitário para estimar o custo do caminho (h(n))
    public static int heuristica(TupleMatriz atual, TupleMatriz destino) {// heuristica da distância de Euclidines(Cemrota usa ele)
       return (int) Math.sqrt(Math.pow(destino.getabscissa() - atual.getabscissa(), 2) + Math.pow(destino.getordenada() - atual.getordenada(), 2));
    }

    public static TupleMatriz localizador(int[][] matriz, int valor) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == valor) {
                    return new TupleMatriz(i, j);
                }
            }
        }
        return new TupleMatriz(0, 0);
    }

    public static void reconstruirCaminho(TupleMatriz no, List<TupleMatriz> noVisitados) {
        List<TupleMatriz> caminho = new ArrayList<>();
        while (no != null) {
            caminho.add(0, no);
            no = no.getPai();
        }
        noVisitados.clear();
        noVisitados.addAll(caminho);
    }

    public static List<TupleMatriz> vizinhosValidos(TupleMatriz atual, int[][] grafo, List<TupleMatriz> todosOsNos) {
        List<TupleMatriz> vizinhos = new ArrayList<>();
        int[][] direcoes = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

        for (int[] d : direcoes) {
            int nx = atual.getabscissa() + d[0];
            int ny = atual.getordenada() + d[1];

            atual.setDiagonal(Math.abs(d[0]) == 1 && Math.abs(d[1]) == 1);      

            if (nx >= 0 && nx < grafo.length && ny >= 0 && ny < grafo[0].length && grafo[nx][ny] != 1) {
                TupleMatriz candidato = new TupleMatriz(nx, ny);
                // Procurar a instância já existente em todosOsNos
                for (TupleMatriz existente : todosOsNos) {
                    if (existente.equals(candidato)) {
                        vizinhos.add(existente);
                        break;
                    }
                }
            }
        }

        return vizinhos;
    }


    public static int[][] lerMatrizDeArquivo(String caminhoArquivo) throws IOException {
        try  {
            List<int[]> linhas = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));
            String linha;
            while ((linha = br.readLine()) != null) {
                int[] valores = linha.chars().map(c -> c - '0').toArray();
                linhas.add(valores);
            }
            br.close();
            return linhas.toArray(new int[0][]);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Erro ao ler o arquivo: " + caminhoArquivo, e);
        }
    }
}
