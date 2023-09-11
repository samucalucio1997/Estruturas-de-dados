package FIFO;

public class Fila<T extends Object> implements FilaIS {

    private int i = 0;
    private int capacity;
    private int f = 0;
    private T[] fila;
    private int fi;

    public Fila(int tam, int FI) {
        this.capacity = (int) (tam > 0 ? tam : 1);
        f = capacity;
        fila = (T[]) new Object[capacity];
        fi = FI > 0 ? FI : 0;
    }

    public int getI() {
        return i;
    }

    public int getF() {
        return f;
    }

    @Override
    public Object enQueue(Object no) {
        if (i == f || f + i == capacity) {
            if (fi == 0) {
                capacity *= 2;
            } else {
                capacity += fi;
            }
            T[] novo = (T[]) new Object[capacity];
            int inicio = i;
            i = fila.length;
            f = i;
            // System.out.println("duplicou");
            for (int in = 0; in < fila.length; in++) {
                // System.out.println("f = " + f);
                if (f == capacity-1) {
                    f -= capacity;
                }
                
                if (inicio == fila.length-1) {
                    inicio -= fila.length;
                }
                f++;
                inicio++;
                novo[f] = fila[inicio];
            }
            fila = novo;
        }
        if (f == capacity) {
            f -= capacity;
            // System.out.println("Passou aqui");
        }
        fila[f++] = (T) no;

        return no;
    }

    @Override
    public Object deQueue() {
        if(i==capacity-1){
            
        }
        T resp = fila[i];
        fila[i] = null;
        ++i;
        return resp;
    }

    @Override
    public String first() {
        return fila[i].toString();
    }

    @Override
    public int size() {
        int res = f > i ? f - i : i + f;
        return res;
    }

    @Override
    public Boolean isEmpty() {

        return i == -1;
    }

    public void ShowElements() {
        System.out.print("[");
        System.out.print(fila[0]);
        for (int i = 1; i < fila.length - 1; i++) {
            System.out.print(", " + fila[i]);
        }
        System.out.print(", " + fila[fila.length - 1] + "]");
    }

}
