import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        String nome="";
        List<String> list = new ArrayList<>();
        System.out.println(list.getClass().isInstance(new LinkedList<>()));
        HashTableLinearProbing<Integer> hash = new HashTableLinearProbing<>(2);
        hash.InsertItem(45, new Obj<>());
        hash.InsertItem(12, new Obj<>());
        hash.InsertItem(22, new Obj<>());
        hash.InsertItem(7, new Obj<>());
        hash.Print(); 
    }
}
