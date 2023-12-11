import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String nome="";
        List<String> list = new ArrayList<>();
        System.out.println(list.getClass().isInstance(new LinkedList<>()));
    }
}
