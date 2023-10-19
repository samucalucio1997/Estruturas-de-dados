import java.util.function.Function;

import FIFO.Fila;

public class App {

    private static class Node {
        private Node next;
        private Node prev;
        private int value;
        
        
        public Node() {
        }
        public Node(int value) {
            this.value = value;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        public Node getPrev() {
            return prev;
        }
        public void setPrev(Node prev) {
            this.prev = prev;
        }
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }

    }
    public static void main(String[] args) throws Exception {

        Lista lista = new Lista();
        Lista new_Lista = new Lista();
        new_Lista.addFirst(new Node(75));
        new_Lista.addFirst(new Node(18));
        new_Lista.addFirst(new Node(46));
        new_Lista.addFirst(new Node(31));
        new_Lista.addFirst(new Node(56));
        new_Lista.addFirst(new Node(11));
        lista.addFirst(new Node(9));
        lista.addFirst(new Node(84));
        lista.addFirst(new Node(15));
        lista.addFirst(new Node(11));
        lista.addFirst(new Node(7));
        new_Lista.ShowElements();
        // new_Lista.makeFirst(2);
        lista.AdicionaLista(new_Lista);
        new_Lista.ShowElements();


        // Fila<Integer> queue = new Fila<Integer>(1, -2);
        // queue.enQueue(new Integer(5));
        // queue.enQueue(new Integer(65));
        // queue.enQueue(new Integer(45));
        // System.out.println(queue.deQueue());
        // queue.enQueue(new Integer(5));
        // queue.ShowElements();
        // System.out.println(queue.deQueue());
        // queue.enQueue(new Integer(8));
        // queue.enQueue(new Integer(84));
        // queue.enQueue(new Integer(15));
        // queue.enQueue(new Integer(23));
        // System.out.println(queue.deQueue()); 
        // queue.enQueue(new Integer(28));
        // System.out.println(queue.deQueue()); 
        // System.out.println(queue.deQueue()); 
        
        // queue.ShowElements();
        
    }

    private static class Lista implements ListaIm{
        private Node head;
        private Node tail;
        private int t=-1;
        
        public Lista() { 
            head = new Node();/*nós sentinela*/
            tail = new Node();
        }

        public Node firstNode(){
            return head.getNext();
        }

        @Override
        public void addFirst(Node node) {
            // TODO Auto-generated method stub
            Node new_no = node;
        if (t == -1) {
            head.setNext(new_no);
            tail.setPrev(new_no);
        } else {
            new_no.setNext(head.getNext());
            new_no.setPrev(head);
            head.getNext().setPrev(new_no);
            head.setNext(new_no);
        }
        t++;
        }
        
        Function<Integer,Node> Search = (p) -> {
            Node cursor = head.getNext();
            for (int j = 0; j < p; j++) {
                cursor = cursor.getNext();
            } 
            return cursor;
        }; 

        public Node makeFirst(int i){
            Node replaced = (App.Node) Search.apply(i);
            replaced.getPrev().setNext(replaced.getNext());
            replaced.getNext().setPrev(replaced.getPrev());
            addFirst(replaced);
            // replaced.setNext(head.getNext());
            // head.getNext().setPrev(replaced);
            // head.setNext(replaced);
            // replaced.setPrev(head);
            return head.getNext();
        }

        @Override
        public void addLast(Node node) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public boolean isEmpty() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public Node removeFirst() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Node removeLast() {
            // TODO Auto-generated method stub
            return null;
        }

        public Node Last(){
            return tail.getPrev();
        }

        public void AdicionaLista(Lista lista){
            Node ref = lista.Last(); 
            lista.Last().setNext(this.head.getNext());
            head.getNext().setPrev(ref);
            head = lista.head;
        }

        public void ShowElements() {
            Node cursNo = head;
            System.out.print("[");
            while (cursNo.getNext() != null && !cursNo.getNext().equals(head)) {
                System.out.print(cursNo.getNext().getValue() + ", ");
                cursNo = cursNo.getNext();
            }
            System.out.print("]");
            System.out.println();
        }

        @Override
        public int size() {
            // TODO Auto-generated method stub
            return t+1;
        }
        

        
    }


    private interface ListaIm {
    
    void addFirst(Node node);

    // Adiciona um elemento no final da lista.
    void addLast(Node node);

    // Remove o primeiro elemento da lista e o retorna.
    Node removeFirst();

    // Remove o último elemento da lista e o retorna.
    Node removeLast();

    // Verifica se a lista está vazia.
    boolean isEmpty();

    // Retorna o tamanho da lista.
    int size();

    }
}
