package GenericTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArvreGeni<t>{
    
    No<t> raiz;
	int tamanho;
	//Construtor
	public ArvreGeni(t o)
	{
		raiz = new No<t>(null, o);
		tamanho = 1;
	}
	/** Retorna a raiz da árvore */
	public No<t> root(){
		return raiz;
	}
	/** Retorna o No<t> pai de um No<t> */
	public No<t> parent(No<t> v){
		return (v.parent());
	}

	/** retorna os filhos de um No<t> */
	public Iterator children(No<t> v)
	{
		return v.children();
	}
	/** Testa se um No<t> é interno */
	public boolean isInternal(No<t> v)
	{
		return (v.childrenNumber() > 0);
	}
	/** Testa se um No<t> é externo*/
	public boolean isExternal(No<t> v)
	{
		return (v.childrenNumber() == 0);
	}
	/** Testa se um No<t> é a raiz */
	public boolean isRoot(No<t> v)
	{
		// v == raiz;
		return v.element().equals(raiz.element()); 
	}
	/** Adiciona um filho a um No<t> */
	public void addChild(No<t> v, No<t> o)
	{
		v.addChild(o);
		tamanho++;
	}
	/** Remove um No<t>
	 *  Só pode remover Nos externos e que tenham um pai (não seja raiz)
	*/
	public t remove(No<t> v) throws InvalidNoException
	{
		No<t> pai = v.parent();
		if (pai != null || isExternal(v))
			pai.removeChild(v);
		else
			throw new InvalidNoException();
		t o = v.element();
		tamanho--;
		return o;
	}
	/** Troca dois elementos de posição */
	public void swapElements(No<t> v, No<t> w)
	{
		/*Método que serve de exercício
		 * Este método deverá fazer com que o objeto
		 * que estava na posição v fique na posição w
		 * e fazer com que o objeto que estava na posição w
		 * fique na posição v
		 */  
		t save = w.element(); 
        w.setElement(v.element());
		v.setElement(save);        
	}
	/** Retorna a profundidade de um No<t> */
	public int depth(No<t> v)
	{
		int profundidade = profundidade(v);
		return profundidade;
	}
	private int profundidade(No<t> v)
	{
		if (v == raiz)
			return 0;
		else
			return 1 + profundidade(v.parent());
	}
	/** Retorna a altura da árvore */
	public int height()
	{
		// Método que serve de exercício
		int altura = 0;
		return altura;
	}

    private void preOrdemTree(No<t> no, List<No<t>> lista){
         if(no == null){
			return;
		 }
		 lista.add(no);
		 Iterator<No<t>> fil = no.children();
		 while (fil.hasNext()) {
				No<t> filho = fil.next();
				preOrdem(filho);
		 }
	}

	public No<t> Pesquisar(No<t> no){
		No<t> cursNo=null;
		while(elements().hasNext()){
			if(elements().next().equals(no.element())){
				cursNo = (No<t>) elements().next();break;
			}
		}
		return cursNo;
	}

	/** Retorna um iterator com os elementos armazenados na árvore */
	public Iterator elements(){
		// Método que serve de exercício
        List<No<t>> lista = new ArrayList<>();
		preOrdemTree(raiz, lista);    
		return lista.iterator();
	}
	/** Retorna um iterator com as posições (Nos) da árvore */
	public Iterator Nos(){
		// Método que serve de exercício
        List<No<t>> it = new ArrayList<>();

        return null;
	}
	/** Retorna o número de Nos da árvore
	 */
	public int size()
	{
	 // Método que serve de exercício
		return tamanho;
	}
    /********************************************* */
    public void preOrdem(No<t> no) {
        // TODO Auto-generated method stub
        No<t> cursor = no;
        if(cursor == null){
            return;
        }
        System.out.println(cursor.element());
        Iterator<No<t>> agarra = cursor.children();
        while(agarra.hasNext()){
           cursor = agarra.next();
           preOrdem(cursor);           
        }
    }
	/** Retorna se a ávore está vazia. Sempre vai ser falso, pois não permitimos remover a raiz
	 */
	public boolean isEmpty()
	{
		return false;
	}
	public t replace(No<t> v, t o)
	{
	 // Método que serve de exercício
		return null;
	} 
    
}

// private No<t> raiz;
// private int tam;



// public int getTam() {
//     return tam;
// }
// public void setTam(int tam) {
//     this.tam = tam;
// }

// public ArvreGeni(t value) {
//     this.raiz = new No<t><t>(value);
// }

// public Boolean isInternal(No<t><t> no){
//    if(no.getFilhos().hasNext()){
//        return false;
//    }else{
//     return true;
//    }
// }
// @Override
// public int altura(No<t><T> No<t>) {
//     // TODO Auto-generated method stub
//     return 0;
// }
// @Override
// public Iterator elements() {
//     // TODO Auto-generated method stub
    
//     return null;
// }
// @Override
// public Comparador getComparador() {
//     // TODO Auto-generated method stub
//     return null;
// }
// @Override
// public No<t><T> getRaiz() {
//     // TODO Auto-generated method stub
//     return null;
// }
// @Override
// public No<t><T> incluir(T key) {
//     // TODO Auto-generated method stub
//     No<t><t> novo = new No<t><t>(key);
    
//     return null;
// }
// @Override
// public boolean isEmpty() {
//     // TODO Auto-generated method stub
//     return false;
// }
// @Override
// public void mostrar() {
//     // TODO Auto-generated method stub
    
// }
// @Override
// public Iterator<No<t><t>> nos() {
//     // TODO Auto-generated method stub
//     return null;
// }
// @Override
// public No<t><T> pesquisar(No<t><T> No<t>, T key) {
//     // TODO Auto-generated method stub
//     No<t><t> cursNo = No<t>;
//     while (cursNo.getFilhos().hasNext()) {
//         cursNo =(No<t><t>) cursNo.getFilhos().next();
//         pesquisar(cursNo, key);
//     }    
//     return cursNo;
// }
// @Override
// public void posOrdem(No<t><T> No<t>) {
//     // TODO Auto-generated method stub
    
// }
// @Override
// public void preOrdem(No<t><T> No<t>) {
//     // TODO Auto-generated method stub
    
// }
// @Override
// public int profundidade(No<t><T> No<t>) {
//     // TODO Auto-generated method stub
//     return 0;
// }
// @Override
// public T remover(T key) {
//     // TODO Auto-generated method stub
//     return null;
// }
// @Override
// public void setComparator(Comparador c) {
//     // TODO Auto-generated method stub
    
// }
// @Override
// public void setRaiz(No<t><T> p) {
//     // TODO Auto-generated method stub
    
// }
// @Override
// public int size() {
//     // TODO Auto-generated method stub
//     return 0;
// }