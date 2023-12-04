package ArvoreBinariaPesquisa;

public interface Comparador<t> {

    public int compare(No<t> no1,No<t> no2);
    public int compareT(int no1,int no2);
}
