package ArvoreBinariaPesquisa;

import java.util.Comparator;

public class Comparador<t> implements Comparator<no<t>>{

    @Override
    public int compare(no<t> o1, no<t> o2) {
        // TODO Auto-generated method stub
        int p = (Integer) o1.getValue();
        int k = (Integer) o2.getValue();
        return Integer.compare(p, k);
    }

    

    


}
