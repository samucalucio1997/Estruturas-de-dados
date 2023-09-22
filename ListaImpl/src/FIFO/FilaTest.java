package FIFO;

public class FilaTest {
    public static void main(String[] args) {
        Fila<Integer> fila1,fila2;
        fila1 = new Fila<>(0, 0);
        fila1.enQueue(new Integer(48));
        fila1.enQueue(new Integer(77));
        fila1.enQueue(new Integer(52));
        fila1.enQueue(new Integer(30));
        fila1.enQueue(new Integer(84));
        fila1.enQueue(new Integer(9)); 
        fila2 = fila1.Copy();
        fila1.ShowElements();
        System.out.println(fila2.deQueue());
        System.out.println(fila2.first());
        System.out.println(fila1.first());
    }
}
