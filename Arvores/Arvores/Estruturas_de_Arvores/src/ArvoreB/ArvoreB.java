package ArvoreB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class ArvoreB<T extends Object> {
    
    private NoB<T> root;
    private int t;
    
    public ArvoreB(NoB<T> root, int t) {
        this.root = root;
        this.t = t;
    }

    public NoB<T> inserirNo(NoB<T> node){

        return null;
    }

    public NoB<T> searchNo(NoB<T> node, T Key){
        if (node.getFilhos().length == 0) {
            return node;
        }

        final var chavesNo = Optional.ofNullable(node.getChaves()).orElse(null);
        final var indexSearch = getIndexSearch(chavesNo, Key);
        final var chaveSearch = chavesNo[indexSearch];

        if (chaveSearch == Key) {
            return node;
        }

        // if (chaveSearch > Key) {//usar o comparator
        //     return searchNo(node.getChaves(), Key);
        // }

        return null;
        
    }
    
    
    private int getIndexSearch(T[] arr,T key) {
        return Arrays.binarySearch(arr, t);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public NoB<T> getRoot() {
        return root;
    }

    public void setRoot(NoB<T> root) {
        this.root = root;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }
    
    
}
