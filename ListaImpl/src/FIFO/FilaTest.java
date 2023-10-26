package FIFO;

import FIFOWPil.FilaVaziaException;

public class FilaTest {
    public static void main(String[] args) {
        Fila<Integer> f=new Fila(1,0); //criando fila tamnho 1 e duplicação
		f.enQueue(1);
		f.enQueue(2);
		f.enQueue(3);
		f.enQueue(4);
			System.out.println(f.first());
			f.deQueue();
			System.out.println(f.first());
			f.deQueue();
			System.out.println(f.first());
			f.deQueue();
			System.out.println(f.first());
			// f.deQueue();
			// System.out.println(f.first());
			// f.dequeue();
		
		
    }
}
