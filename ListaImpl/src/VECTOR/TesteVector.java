package VECTOR;

public class TesteVector {
    public static void main(String[] args) {
        Vector vetor = new Vector();
        vetor.insertAtRank(new Integer(4),0);
        vetor.ShowElements();
        vetor.insertAtRank(new Integer(45), 0);
        vetor.insertAtRank(new Integer(27), 0);
        vetor.insertAtRank(new Integer(78), 0);
        vetor.insertAtRank(new Integer(34), 0);
        vetor.insertAtRank(new Integer(12), 0);
        vetor.insertAtRank(new Integer(19), 0);
        vetor.insertAtRank(new Integer(15), 3);
        vetor.ShowElements();
        vetor.removeAtRank(7);
        vetor.ShowElements();
    }
}
