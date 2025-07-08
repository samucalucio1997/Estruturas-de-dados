package ArvoreB;

import java.util.Arrays;

public class TesteArvoreB {
    public static void main(String[] args) {
        ArvoreB<Integer> node = new ArvoreB<Integer>(4);
        NoB<Integer> no = new NoB<Integer>(4);
        NoB<Integer> no1 = new NoB<Integer>(4);
        NoB<Integer> no2 = new NoB<Integer>(4);
        NoB<Integer> no3 = new NoB<Integer>(4);

        final var listaPrincipal = new Integer[]{15, 45, 2, 12, 20};//2, 12, 28, 30, 45
        final var lista1 = new Integer[]{-10, -9, -7, -6, 1};
        Arrays.sort(lista1);
        no1.setChaves(lista1);

        final var lista2 = new Integer[]{13, 15, 21, 21, 20};
        Arrays.sort(lista2);
        no2.setChaves(lista2);

        final var lista3 = new Integer[]{31, 32, 35, 38, 36};
        Arrays.sort(lista3);
        no3.setChaves(lista3);

        Arrays.sort(listaPrincipal);
        no.setChaves(listaPrincipal);
        
        no1.setPai(no);no2.setPai(no);no3.setPai(no);no.setFilhos(new NoB[]{no1,no2,no3});

        final var numberSearch = node.searchNo(no, 13);
        System.out.println(numberSearch);
    }
}
