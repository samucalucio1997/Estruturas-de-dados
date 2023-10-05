package Lista;

public class ListaTest {
    public static void main(String[] args) {
        // ArrayList list = new ArrayList(-1);
        // list.insertFirst(new Integer(45));//entrou
        // list.insertFirst(new Integer(28));
        // list.insertFirst(new Integer(25));
        // list.insertFirst(new Integer(71));
        // list.insertFirst(new Integer(5));
        // list.insertFirst(new Integer(47));
        // list.insertAfter(new Integer(71), new Integer(34));
        // list.insertBefore(new Integer(45), new Integer(12));
        // list.ShowElements();   
        // list.swapElement(new Integer(28), new Integer(71));
        // System.out.println();
        // list.insertBefore(new Integer(45), new Integer(102));
        // list.ShowElements();
      
        LinkedList lista = new LinkedList();
        lista.insertFirst(new Integer(45));
        lista.insertFirst(new Integer(28));
        lista.insertFirst(new Integer(12));
        lista.insertFirst(new Integer(31));
        lista.insertFirst(new Integer(91));
        lista.insertFirst(new Integer(52));
        lista.insertLast(new Integer(78));    
        lista.ShowElements();
        lista.replaceElement(new Integer(11), lista.size()-1);
        lista.insertLast(720);
        lista.insertAfter(720, 32);
        lista.insertBefore(52, 91);
        lista.ShowElements();
        lista.remove(28);
        lista.insertAfter(91, 71);
        lista.ShowElements();
    }
}
