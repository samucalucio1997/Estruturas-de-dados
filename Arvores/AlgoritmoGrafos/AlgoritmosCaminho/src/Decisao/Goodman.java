package Decisao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import melhorcaminho.TupleMatriz;

public class Goodman { 

    public boolean isConexo(List<Vertice> listaVertices) {
        int seq=0;
        final var grafoResutalte = new HashMap<String, List<Vertice>>();
        alimentarGrafo(listaVertices, grafoResutalte);
        while (!listaVertices.isEmpty()) {
            final var verticeInterado = listaVertices.remove(0);
            for (Vertice vertice : listaVertices) {
                if (isAdjacente(verticeInterado, vertice)) {
                    aglutinarVerticeConexo(verticeInterado, vertice, grafoResutalte);
                }
            }
        }
        return false;
    }
    
    private void aglutinarVerticeConexo(Vertice verticePrincipal, Vertice verticeAglutinato, HashMap<String, List<Vertice>> grafo){
        final var verticeAserAglutinado = grafo.get(String.valueOf(verticeAglutinato.getId()));
        final var verticeGlutinado = grafo.get(String.valueOf(verticeAglutinato.getId()));

        grafo.remove(String.valueOf(verticeAglutinato.getId()));

        final var chaves = grafo.entrySet();

        var chave = chaves.stream().filter(n -> n.getKey().equals(verticeAglutinato.getId())).findFirst().orElse(null);

        verticeAserAglutinado.get(0).setArestas(null);
        verticeGlutinado.add(verticeAserAglutinado.get(0));
        // chave =  
    }

    private int[][] preencherMatriz(List<TupleMatriz> listaVertices) {
        final var matriz = new int[50][50];
        for (TupleMatriz tupleMatriz : listaVertices) {
            matriz[tupleMatriz.getordenada()][tupleMatriz.getabscissa()] = (int) tupleMatriz.getG();
        }
        return matriz;
    }

    public boolean isAdjacente(Vertice verticeIn, Vertice vertice) {
        return verticeIn.getArestas().contains(vertice);
    }


    public void alimentarGrafo(List<Vertice> vertices, Map<String,List<Vertice>> map){
        int index = 1;
        for (Vertice vertice : vertices) {
            final var indexStr = Integer.toString(index);
            vertice.setId(index);
            map.put(indexStr, List.of(vertice));
            index++;
        }
    }


    public boolean outroMetodo(List<TupleMatriz> listaVertices) {
        int grau = 0;
        int sum = 0;
        int linhaAtual = 0;
        final var matriz = preencherMatriz(listaVertices);

        while (sum <= 2 && linhaAtual <= matriz.length) {
            grau = 0;
            for (int i = 0; i < matriz.length; i++) {
                grau+=matriz[linhaAtual][i];
            }
            if (grau%2 == 1) {
                sum++;
            }
            linhaAtual++;
        }
        return sum>2;
    }
    
    public class Aresta {
        private Vertice Vertice1;
        private Vertice vertice2;

        public Vertice getVertice1() {
            return Vertice1;
        }

        public void setVertice1(Vertice vertice1) {
            Vertice1 = vertice1;
        }

        public Vertice getVertice2() {
            return vertice2;
        }

        public void setVertice2(Vertice vertice2) {
            this.vertice2 = vertice2;
        }

    }

    public class Vertice {
        private int id;
        private int x;
        private int y;
        private List<Aresta> arestas;

        public int getX() {
            return x;
        }
        public void setX(int x) {
            this.x = x;
        }
        public int getY() {
            return y;
        }
        public void setY(int y) {
            this.y = y;
        }
        
        public List<Aresta> getArestas() {
            return arestas;
        }
        public void setArestas(List<Aresta> arestas) {
            this.arestas = arestas;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }        
    }
}


