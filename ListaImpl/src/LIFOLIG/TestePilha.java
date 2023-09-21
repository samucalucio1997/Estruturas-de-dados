package LIFOLIG;





public class TestePilha {
    public static void main(String[] args) {
        Pilha<Integer> pil = new Pilha<>();
        pil.push(new Integer(45));
        pil.push(new Integer(81));
        pil.push(new Integer(62));
        pil.push(new Integer(7));
        pil.push(new Integer(91));
        pil.pop();
        // pil.showElements();
        pil.pop();
        pil.pop();
        System.out.println(pil.first());
        pil.showElements();
        
          

    }
}
