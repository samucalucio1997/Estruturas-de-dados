package ArvoreBinariaPesquisa;

public interface IArvoreBinariaPesquisa<t> {
    void setComparator(Comparador<t> c);

	Comparador<t> getComparador();

	no<t> pesquisar(no<t> no, t key);

	no<t> incluir(t key);

	t remover(t key);

	no<t> getRaiz();

	void setRaiz(no<t> p);

	void emOrdem(no<t> no);

	void preOrdem(no<t> no);

	void posOrdem(no<t> no);

	int altura(no<t> no);

	int profundidade(no<t> no);

	void mostrar();

	Iterator<t> nos();

	Iterator<t> elements();

	int size();

	boolean isEmpty();
}
