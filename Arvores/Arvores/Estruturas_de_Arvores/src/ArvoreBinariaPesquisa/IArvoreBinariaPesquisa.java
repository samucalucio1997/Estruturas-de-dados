package ArvoreBinariaPesquisa;

public interface IArvoreBinariaPesquisa<t> {
    void setComparator(Comparador<t> c);

	Comparador<t> getComparador();

	No<t> pesquisar(No<t> no, t key);

	No<t> incluir(t key);

	t remover(t key);

	No<t> getRaiz();

	void setRaiz(No<t> p);

	void emOrdem(No<t> no);

	void preOrdem(No<t> no);

	void posOrdem(No<t> no);

	int altura(No<t> no);

	int profundidade(No<t> no);

	void mostrar();

	Iterator<No<t>> nos();

	Iterator<t> elements();

	int size();

	boolean isEmpty();
}
