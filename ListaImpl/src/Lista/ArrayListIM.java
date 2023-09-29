package Lista;

public interface ArrayListIM {
    abstract int size();
    abstract boolean isEmpty();
    abstract Boolean isLast(Object jk);
    abstract Boolean isFirst(Object jk);
    abstract Object First();
    abstract Object Last();
    abstract Object replaceElement(Object n,int o);
    abstract Object swapElement(Object a,Object b);
    abstract Object insertBefore(Object p,Object o);
    abstract Object insertAfter(Object p, Object l);
    abstract Object insertFirst(Object p);
    abstract Object insertLast(Object m);
    abstract Object remove(Object no);
}
