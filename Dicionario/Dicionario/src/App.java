
public class App {
    public static void main(String[] args) throws Exception {
        HashTableLinearProbing<Integer> hash = new HashTableLinearProbing<>(2);
        hash.InsertItem(45, new Obj<>(45));
        hash.InsertItem(12, new Obj<>(12));
        hash.InsertItem(22, new Obj<>(22));
        hash.InsertItem(7, new Obj<>(7));
        hash.InsertItem(48, new Obj<>(48));
        hash.InsertItem(102, new Obj<>(102));
        hash.InsertItem(23, new Obj<>(23));
        hash.InsertItem(29, new Obj<>(23));
        hash.InsertItem(43, new Obj<>(23));
        hash.InsertItem(73, new Obj<>(23));
        hash.InsertItem(21, new Obj<>(23));
        hash.InsertItem(80, new Obj<>(80));
        System.out.println(hash.getTam());
        hash.Print(); 
    }
}
