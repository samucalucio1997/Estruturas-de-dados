package PilhaExer;

public class TestePilha {
    public static void main(String[] args) {
        Deque pilha = new Deque(0);
        pilha.push(new Integer(54));
        pilha.push(new Integer(97));
        pilha.push(new Integer(22));
        pilha.push(new Integer(15));
        // pilha.push(new Integer(45));
        // pilha.push(new Integer(18));
        // System.out.println(pilha.pop());
        // System.out.println(pilha.size());
        // System.out.println(pilha.top());
        Deque p1 = pilha.Copy();
        // p1.pop();
        pilha.ShwEl();
        System.out.println();
        System.out.println(pilha.pop());
        // pilha.ShwEl();
        System.out.println(); 
        p1.ShwEl();
        p1.pop();
        System.out.println();
        p1.ShwEl();
        
        

    }
}
