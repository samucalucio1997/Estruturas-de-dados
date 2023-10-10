package SEQUENCIA;

public class TesteSeq {
    public static void main(String[] args) {
        Sequencia seq = new Sequencia();
        seq.insertFirst(45);
        seq.insertFirst(81);
        seq.insertFirst(19);
        seq.insertFirst(28);
        seq.insertFirst(11);
        seq.insertFirst(31);
        seq.insertLast(105);
        System.out.println(seq.First());
        seq.insertAfter(19, 71);
        System.out.println(seq.elementAtRank(7));
        seq.ReplaceAtRank(4, 86<<1);
        seq.insertAtRank(17, 3);
        while(seq.hasNext()){
             System.out.println(seq.nextObject());
        }
        seq.showElements();
    }
}
