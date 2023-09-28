package Lista;

public class ArrayList implements ArrayListIM {
    private int capacity;
    private Object[] ar;  
    private int c=-1;


    public ArrayList(int tam) {
        this.capacity = tam>0?tam:1;
        ar = new Object[capacity];
    }


    @Override
    public int size() {
        // TODO Auto-generated method stub
        if(c==-1){
          throw new RuntimeException("lista vazia!!");
        }  
        return c+1;
    }


    @Override
    public boolean isEmpty() {
        return c==-1; 
    }


    @Override
    public Boolean isLast(Object jk) {
        // TODO Auto-generated method stub
      if(isEmpty()){
          throw new RuntimeException("lista vazia"); 
      }
      if(ar[ar.length-1]==jk){
        return true;
      }   
      else{
        return false;
      }
    }


    @Override
    public Boolean isFirst(Object jk) {
        // TODO Auto-generated method stub

        throw new UnsupportedOperationException("Unimplemented method 'isFirst'");
    }


    @Override
    public Object First() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'First'");
    }


    @Override
    public Object Last() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Last'");
    }


    @Override
    public Object replaceElement(Object n, int o) {
        // TODO Auto-generated method stub
            ar[o]=n;
            return ar[o];
        }


    @Override
    public Object swapElement(Object a, Object b) {
        // TODO Auto-generated method stub
        int i=0;
        for (int j = 0; j < ar.length; j++) {
            if(ar[j]==b){
               ar[j]=a;
               i=j;
               break;
            }
        }
        return ar[i];
    }


    @Override
    public Object insertBefore(Object p, Object o) {
        if(this.c==capacity-1){
              int antcapa = capacity;
              capacity*=2;
              Object[] novo = new Object[capacity];
              int con = ar.length; 
              for (int i = 0; i < novo.length; i++) {
                  novo[i]=ar[c];
                  con=(con+1)%antcapa;
                }
              ar=novo;
            }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertBefore'");
    }


    @Override
    public Object insertAfter(Object p, Object l) {
        if(this.c==capacity+1){
              int antcapa = capacity;
              capacity*=2;
              Object[] novo = new Object[capacity];
              int con = ar.length; 
              for (int i = 0; i < novo.length; i++) {
                  novo[i]=ar[c];
                  con=(con+1)%antcapa;
                }
              ar=novo;
            }
            if(size()==1){
                ar[0]=l;
            }else{
                for (int i = 0; i < ar.length; i++) {
                    if(ar[i]==p){
                        Object pri = ar[i];
                        ar[i]=l;
                         for (int j = i+1; j < ar.length; j++) {
                          Object x = ar[j];
                          ar[j]=pri;
                          pri=x;
                        }      
                    }
                }
            }
            this.c++;
     return l;       
    }


    @Override
    public Object insertFirst(Object p) {
        if(this.c==capacity-1){
              int antcapa = capacity;
              capacity*=2;
              Object[] novo = new Object[capacity]; 
              for (int i = 0; i < antcapa; i++) {
                 if(ar[i]!=null){
                     novo[i]=ar[i];
                      System.out.println(novo[i]);
                 } 
                }
              ar=novo;
              System.out.println("aqui");
            }
            Object pri = ar[0];
            ar[0]=p;
            for (int i = 1; i < this.c; i++) {
                Object x = ar[i];
                ar[i]=pri;
                pri=x;
            }
            this.c++;
            return ar[0];
        }


    @Override
    public Object insertLast(Object m) {
        if(size()==capacity+1){
              int antcapa = capacity;
              capacity*=2;
              Object[] novo = new Object[capacity];
              int con = ar.length; 
              for (int i = 0; i < novo.length; i++) {
                  novo[i]=ar[c];
                  con=(con+1)%antcapa;
                }
              ar=novo;
            }
            ar[++c]=m;
            return m;
        }
         
        public void ShowElements(){
            System.out.print("[");
            System.out.print(ar[0]);
            for (int i = 1; i < ar.length; i++) {
                System.out.print(" ,"+ar[i]);
            }
            System.out.print("]");
        }
}
