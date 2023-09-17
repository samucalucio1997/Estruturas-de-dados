import FIFO.Fila;

public class App {
    public static void main(String[] args) throws Exception {

        Fila<Integer> queue = new Fila<Integer>(1, -2);
        queue.enQueue(new Integer(5));
        queue.enQueue(new Integer(65));
        queue.enQueue(new Integer(45));
        
        System.out.println(queue.deQueue());
        queue.enQueue(new Integer(5));
        System.out.println(queue.deQueue());
        queue.enQueue(new Integer(8));
        queue.enQueue(new Integer(84));
        queue.enQueue(new Integer(15));
        queue.enQueue(new Integer(23));
        System.out.println(queue.deQueue()); 
        queue.enQueue(new Integer(28));
        System.out.println(queue.deQueue()); 
        System.out.println(queue.deQueue()); 
        System.out.println(queue.deQueue()); 
        System.out.println(queue.deQueue()); 
        System.out.println(queue.deQueue()); 
        System.out.println(queue.deQueue()); 
        System.out.println(queue.deQueue()); 
        System.out.println(queue.deQueue()); 
        System.out.println(queue.deQueue()); 
        // queue.ShowElements();
        
    }
}
