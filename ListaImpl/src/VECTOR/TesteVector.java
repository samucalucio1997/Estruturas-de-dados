package VECTOR;

public class TesteVector {
    public static void main(String[] args) {
        // Vector vetor = new Vector();
        // vetor.insertAtRank(new Integer(4),0);
        // vetor.ShowElements();
        // vetor.insertAtRank(new Integer(45), 0);
        // vetor.insertAtRank(new Integer(27), 0);
        // vetor.insertAtRank(new Integer(78), 0);
        // vetor.insertAtRank(new Integer(34), 0);
        // vetor.insertAtRank(new Integer(12), 0);
        // vetor.insertAtRank(new Integer(19), 0);
        // vetor.insertAtRank(new Integer(15), 3);
        // vetor.ShowElements();
        // vetor.removeAtRank(7);
        // vetor.ShowElements();

        VectorLIG vetor = new VectorLIG();
        vetor.insertAtRank(new Integer(45), 0);
        vetor.showElements();
        vetor.insertAtRank(new Integer(27), 0);
        vetor.insertAtRank(new Integer(37), 0);
        vetor.insertAtRank(new Integer(32), 0);
        vetor.insertAtRank(new Integer(102), 0);
        vetor.insertAtRank(new Integer(56), 0);
        vetor.insertAtRank(new Integer(22), 7);
        vetor.insertAtRank(new Integer(203), 0);
        vetor.showElements();
        System.out.println(vetor.size());
        
        System.out.println("----------------------------------");
        // vetor.ReplaceAtRank(3, new Integer(104));
        // vetor.showElements();
        // System.out.println(vetor.size());
        vetor.showElements();
        vetor.removeAtRank(3);
    }
}
