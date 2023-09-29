package Lista;

public class ListaTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(-1);
        list.insertFirst(new Integer(45));//entrou
        list.insertFirst(new Integer(28));
        list.insertFirst(new Integer(25));
        list.insertFirst(new Integer(71));
        list.insertFirst(new Integer(5));
        list.insertFirst(new Integer(47));
        list.swapElement(new Integer(28), new Integer(6));
        list.insertAfter(new Integer(71), new Integer(34));
        list.insertBefore(new Integer(45), new Integer(12));
        list.ShowElements();   
        System.out.println();
        list.insertBefore(new Integer(45), new Integer(102));
        list.ShowElements();
    }
}
