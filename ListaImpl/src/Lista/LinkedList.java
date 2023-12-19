package Lista;

public class LinkedList implements ArrayListIM {
    private No firstNo;
    private No tailNo;
    private int t = -1;

    public LinkedList() {
        this.firstNo = new No();
        this.tailNo = new No();
    }

    public No getFirstNo() {
        return firstNo;
    }

    public void setFirstNo(No firstNo) {
        this.firstNo = firstNo;
    }

    public No getTailNo() {
        return tailNo;
    }

    public void setTailNo(No tailNo) {
        this.tailNo = tailNo;
    }

    @Override
    public Object First() {
        if (isEmpty()) {
            throw new RuntimeException("Lista vazia");
        }
        return firstNo.getNextNo().getValue();
    }

    @Override
    public Object Last() {
        if (isEmpty()) {
            throw new RuntimeException("Lista vazia");
        }
        return tailNo.getPrevNo().getValue();
    }

    public No Search(Object no) {
        No cursNo = firstNo.getNextNo();
        while (!cursNo.getValue().equals(no)) {
            if (cursNo.getValue().equals(null)) {
                throw new RuntimeException("Não tem o nó coleguinha");
            }
            cursNo = cursNo.getNextNo();
        }
        return cursNo;
    }

    @Override
    public Object insertAfter(Object p, Object l) {
        No new_no = new No(l);
        if (t == -1) {
            firstNo.setNextNo(new_no);
            tailNo.setPrevNo(new_no);
        } else {
            No cursNo = Search(p);
            if(cursNo != null){
                new_no.setNextNo(cursNo.getNextNo());
                new_no.setPrevNo(cursNo);
                cursNo.getNextNo().setPrevNo(new_no);
                cursNo.setNextNo(new_no);
            }
        }
        t++;
        return new_no;
    }

    @Override
    public Object insertBefore(Object p, Object o) {
        No new_no = new No(o);
        if (t == -1) {
            firstNo.setNextNo(new_no);
            tailNo.setPrevNo(new_no);
        } else {
            No cursor = Search(o);
            cursor = cursor.getPrevNo();
            new_no.setNextNo(cursor);
            new_no.setPrevNo(cursor.getPrevNo());
            cursor.getNextNo().setPrevNo(new_no);
            cursor.getPrevNo().setNextNo(new_no);
        }
        t++;
        return new_no.getValue();
    }

    @Override
    public Object insertFirst(Object p) {
        No new_no = new No(p);
        if (t == -1) {
            firstNo.setNextNo(new_no);
            tailNo.setPrevNo(new_no);
        } else {
            new_no.setNextNo(firstNo.getNextNo());
            new_no.setPrevNo(firstNo);
            firstNo.getNextNo().setPrevNo(new_no);
            firstNo.setNextNo(new_no);
        }
        t++;
        return firstNo;
    }

    @Override
    public Object insertLast(Object m) {
        No new_no = new No(m);
        if (isEmpty()) {
            firstNo.setNextNo(new_no);
            tailNo.setPrevNo(new_no);
        } else {
            new_no.setNextNo(tailNo);
            new_no.setPrevNo(tailNo.getPrevNo());
            tailNo.getPrevNo().setNextNo(new_no);
            tailNo.setPrevNo(new_no);
        }
        t++;
        return tailNo.getPrevNo();
    }

    @Override
    public boolean isEmpty() {
        return t == -1;
    }

    @Override
    public Boolean isFirst(Object jk) {
        if (isEmpty()) {
            throw new RuntimeException("Lista vazia");
        }
        return firstNo.getNextNo().getValue().equals(jk);
    }

    @Override
    public Boolean isLast(Object jk) {
        if (isEmpty()) {
            throw new RuntimeException("Lista vazia");
        }
        return tailNo.getPrevNo().getValue().equals(jk);
    }

    @Override
    public Object remove(Object no) {
        if (isEmpty()) {
            throw new RuntimeException("Lista vazia");
        }
        No cursNo = Search(no);
        No remove = cursNo;
        cursNo.getPrevNo().setNextNo(cursNo.getNextNo());
        cursNo.getNextNo().setPrevNo(cursNo.getPrevNo());
        cursNo = null;
        return remove.getValue();
    }

    @Override
    public Object replaceElement(Object n, int o) {
        No cursor = firstNo.getNextNo();
        No new_no = new No(n);
        for (int i = 0; i < o; i++) {
            cursor = cursor.getNextNo();
        }
        new_no.setNextNo(cursor.getNextNo());
        new_no.setPrevNo(cursor.getPrevNo());
        cursor.getPrevNo().setNextNo(new_no);
        cursor.getNextNo().setPrevNo(new_no);
        cursor = null;
        return new_no.getValue();
    }

    @Override
    public int size() {
        return t + 1;
    }

    @Override
    public void swapElement(Object a, Object b) {
        No cursorNo = firstNo.getNextNo();
        No cursor = firstNo.getNextNo();
        int c = 0;
        int d = 0;
        if (t == -1) {
            throw new RuntimeException("Lista vazia");
        }
        while (!cursorNo.getValue().equals(a)) {
            cursorNo = cursorNo.getNextNo();
            c++;
        }
        while (!cursor.getValue().equals(b)) {
            cursor = cursor.getNextNo();
            d++;
        }
        replaceElement(cursor.getValue(), c);
        replaceElement(cursorNo.getValue(), d);
    }

    public void ShowElements() {
        No cursNo = firstNo;
        System.out.print("[");
        while (cursNo.getNextNo() != null && !cursNo.getNextNo().equals(firstNo)) {
            System.out.print(cursNo.getNextNo().getValue() + ", ");
            cursNo = cursNo.getNextNo();
        }
        System.out.print("]");
        System.out.println();
    }
}