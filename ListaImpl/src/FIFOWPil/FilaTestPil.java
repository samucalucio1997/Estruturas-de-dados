package FIFOWPil;

import PilhaExer.Deque;

public class FilaTestPil {
    public static void main(String[] args) {
        // Fila fila = new Fila();
        // fila.enqueue(new Integer(45));
        // fila.enqueue(new Integer(40));
        // fila.enqueue(new Integer(47));
        // fila.enqueue(new Integer(84));
        // System.out.println(fila.dequeue());
        Deque pilha = new Deque(0);
        pilha.push(new Integer(45));
        pilha.push(new Integer(65));
        pilha.push(new Integer(12));
        pilha.push(new Integer(32));
        pilha.push(new Integer(15));
        System.out.println(pilha.pop());
        
    }
}
