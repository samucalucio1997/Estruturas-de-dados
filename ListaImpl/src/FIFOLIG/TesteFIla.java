package FIFOLIG;

public class TesteFIla {
    public static void main(String[] args) {
        FilaL<Integer> fila = new FilaL<>();
        fila.enQueue(new Integer(8));
        fila.enQueue(new Integer(14));
        fila.enQueue(new Integer(71));
        System.out.println(fila.getHead().getValue());
        // fila.deQueue();
        System.out.println(fila.getHead().getValue());
        // fila.deQueue();
        System.out.println(fila.getHead().getValue());
        fila.enQueue(new Integer(88));
        fila.ShowElements();
         
    }
}
