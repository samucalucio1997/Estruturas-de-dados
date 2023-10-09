package SEQUENCIA;

import Lista.ArrayListIM;
import VECTOR.VectorIM;

public interface SequenciaIM extends ArrayListIM,VectorIM{

    @Override
    default Object First() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'First'");
    }

    public No atRank(int rank);

    public int RankOf(No no);

    @Override
    default Object Last() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Last'");
    }

    @Override
    default Object insertAfter(Object p, Object l) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertAfter'");
    }

    @Override
    default Object insertBefore(Object p, Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertBefore'");
    }

    @Override
    default Object insertFirst(Object p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertFirst'");
    }

    @Override
    default Object insertLast(Object m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertLast'");
    }

    @Override
    default boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    default Boolean isFirst(Object jk) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isFirst'");
    }

    @Override
    default Boolean isLast(Object jk) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isLast'");
    }

    @Override
    default Object remove(Object no) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    default Object replaceElement(Object n, int o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'replaceElement'");
    }

    @Override
    default int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    default void swapElement(Object a, Object b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'swapElement'");
    }

    @Override
    default Object ReplaceAtRank(int r, Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ReplaceAtRank'");
    }

    @Override
    default Object elementAtRank(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'elementAtRank'");
    }

    @Override
    default Object insertAtRank(Object o, int p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertAtRank'");
    }

    @Override
    default Object removeAtRank(int ar) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAtRank'");
    }
    
}
