package PilhaExer;

public class TestePilha {
    
    
    // private class Principal{
        
    // }
    
    
    public static void main(String[] args) {
        Deque pilha = new Deque(0);
        Deque pil2 = new Deque(0);
        
        pilha.push(54);
        pilha.push(97);
        pilha.push(22);
        pilha.push(15);
        // pilha.ShwEl();
        pil2.push(64);
        pil2.push(45);
        pil2.push(77);
        pil2.push(120);
        pil2.ShwEl();
        pil2.AdicionaPilha(pilha);
        // System.out.println(pilha.pop());
        // System.out.println(pilha.size());
        // System.out.println(pilha.top());
        // Deque p1 = pilha.Copy();
        // p1.pop();
        // pil2.ShwEl();
        // pilha.ShwEl();
        // pilha.empty();
        // pilha.ShwEl();

        pilha =pilha.Inverse();
        pilha.ShwEl();
        // System.out.println();
        // System.out.println(pilha.pop());
        // pilha.ShwEl();
        // System.out.println(); 
        // p1.ShwEl();
        // p1.pop();
        // System.out.println();
        // p1.ShwEl();
        
        

    }
}
