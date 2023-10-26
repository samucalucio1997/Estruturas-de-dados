package FIFO;

public class Fila<T extends Object> implements FilaIS {

    private int i = 0;
    private int capacity;
    private int f = 0;
    private T[] fila;
    private int fi;

    public Fila(int tam, int FI) {
        this.capacity = (tam > 0 ? tam : 1);
        fila = (T[]) new Object[capacity];
        fi = FI > 0 ? FI : 0;
    }

    @Override
    public void enQueue(Object no) {
        if (size() == capacity - 1) {
            int novotam;
            if (fi == 0) {
                novotam = capacity * 2;
            } else {
                novotam = capacity + fi;
            }
            T[] novo = (T[]) new Object[novotam];
            int ite = i;
            for (int itef = 0; itef < fila.length; itef++) {
                novo[itef] = fila[ite];
                ite = (ite + 1) % capacity;
            }
            f = size();
            i = 0;
            capacity = novotam;
            fila = novo;
        }
        fila[f] = (T) no;
        f = (f + 1) % capacity;
    }

    @Override
    public Object deQueue() {
        if(isEmpty()){
            throw new FilaExecption("pilha vazia meu chapa");
        }
        if (i == capacity) {
            i = 0;
        }
        T resp = fila[i];
        fila[i] = null;
        ++i;
        return resp;
    }

    @Override
    public T first() {
        if (i == f) {
            throw new FilaExecption("Fila vazia");
        }
        return fila[i];
    }

    @Override
    public int size() {
        return (capacity - i + f) % capacity;
    }

    @Override
    public Boolean isEmpty() {
        return i == f;
    }

    public void ShowElements() {
        System.out.print("[");
        System.out.print(fila[0]);
        for (int i = 1; i < fila.length - 1; i++) {
            System.out.print(", " + fila[i]);
        }
        System.out.print(", " + fila[fila.length - 1] + "]");
    }


    public Fila<T> Copy(){/*Aqui está o hacking para a copia da fila invertida para a implementação da pilha com duas filas*/
        Fila<T> copyFila = new Fila<T>(capacity, fi);
        for (int i = this.size() -1; i >-1 ; i--) {
            if(fila[i]!=null){
                copyFila.enQueue(fila[i]);
            }
        }
        return copyFila;
    }

}
