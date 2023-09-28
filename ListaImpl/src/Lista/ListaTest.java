package Lista;

public class ListaTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(-1);
        // System.out.println(list.size());
        list.insertFirst(new Integer(45));//entrou
        list.insertFirst(new Integer(28));
        list.ShowElements();
        System.out.println(list.size());
        //list.insertFirst(new Integer(25));
        //list.insertFirst(new Integer(71));
        //list.insertFirst(new Integer(5));
        //list.insertFirst(new Integer(47));
    }
}
