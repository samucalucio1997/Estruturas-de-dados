package ArvoreB;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

import utils.ComparatorUtil;

public class ArvoreB<T extends Object> {
    
    private NoB<T> root;
    private int t;

    private final ComparatorUtil<T> comparator;
    
    public ArvoreB(int t) {
        this.t = t;
        this.root = new NoB<T>(t);
        this.comparator = new ComparatorUtil<T>();
    }

    public NoB<T> inserirNo(NoB<T> node){

        return null;
    }

    public NoB<T> searchNo(NoB<T> node, T Key){
        if (node.getFilhos().length == 0) {
            return node;
        }

        final var chavesNo = Optional.ofNullable(node.getChaves()).orElse(null);
        var indexSearch = getIndexSearch(chavesNo, Key);
        final var chaveSearch = indexSearch > 0 ? chavesNo[indexSearch - 1] : null;

        if (indexSearch < 0) {
            indexSearch*=-1;
            indexSearch-=1;
        }
        
        if (chaveSearch !=null && chaveSearch == Key) {
            return node;
        }
        final var filho = Arrays.asList(node.getFilhos()).get(indexSearch);
        
        if (filho != null) {
            
        }

        return searchNo(filho, Key);
    }
    
    
    private int getIndexSearch(T[] arr,T key) {
        return Arrays.binarySearch(arr, key);
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
