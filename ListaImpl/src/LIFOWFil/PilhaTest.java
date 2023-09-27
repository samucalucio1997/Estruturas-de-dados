package LIFOWFil;

public class PilhaTest {
    public static void main(String[] args) {
        PilhaIMP mag = new PilhaIMP();
        mag.push(new Integer(12));
        mag.push(new Integer(22));
        mag.push(new Integer(48));
        mag.push(new Integer(16));
        mag.push(new Integer(29));
       System.out.println(mag.pop());
       System.out.println(mag.pop());
       System.out.println(mag.top());
       mag.push(new Integer(81));
       mag.pop();
       System.out.println(mag.top());  
    }
}
