
public class App {
    public static void main(String[] args) throws Exception {
        HashTableLinearProbing<Integer> hash = new HashTableLinearProbing<>(2);
        hash.InsertItem(45, new Obj<>(45));
        hash.InsertItem(12, new Obj<>(12));
        hash.InsertItem(22, new Obj<>(22));
        hash.InsertItem(7, new Obj<>(7));
        hash.InsertItem(48, new Obj<>(48));
        // hash.InsertItem(102, new Obj<>(102));
        System.out.println(hash.getTam());
        System.out.println(hash.Isprimo(4));
        hash.Print(); 
    }
}
