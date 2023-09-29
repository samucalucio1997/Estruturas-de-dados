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
      if(ar[this.c-1].equals(jk)){
        return true;
      }   
      else{
        return false;
      }
    }


    @Override
    public Boolean isFirst(Object jk) {
        // TODO Auto-generated method stub
         if(isEmpty()){
          throw new RuntimeException("lista vazia"); 
        }
        if(ar[0].equals(jk)){
            return true;
        }else{
            return false;
        } 
    }


    @Override
    public Object First() {
        // TODO Auto-generated method stub
        if(isEmpty()){
          throw new RuntimeException("lista vazia"); 
        }
        return ar[0];
    }


    @Override
    public Object Last() {
        // TODO Auto-generated method stub
        if(isEmpty()){
          throw new RuntimeException("lista vazia"); 
        }
        return ar[this.c-1];
    }


    @Override
    public Object replaceElement(Object n, int o) {
        // TODO Auto-generated method stub
            if(isEmpty()){
              throw new RuntimeException("lista vazia"); 
            }
            ar[o]=n;
            return ar[o];
        }


    @Override
    public Object swapElement(Object a, Object b) {
        // TODO Auto-generated method stub
        if(isEmpty()){
          throw new RuntimeException("lista vazia"); 
        }
        int i=0;
        for (int j = 0; j < ar.length; j++) {
            if(ar[j].equals(a)){
               ar[j]=b;
               i=j;
               break;
            }
        }
        return ar[i];
    }


    @Override
    public Object insertBefore(Object p, Object o) {
        if(this.c==capacity-1){
              capacity*=2;
              Object[] novo = new Object[capacity];
              for (int i = 0; i < ar.length; i++) {
                  novo[i]=ar[i];
                }
              ar=novo;
        }
        int index = 0;
        for (int i = 0; i < ar.length; i++) {
            if(ar[i]!=null&&ar[i].equals(p)){
               index = i;
            }
        }
        for (int i = this.c+1; i > index; i--) {
          ar[i]=ar[i-1];
        }
        ar[index]=o;
        this.c++;
        return ar[index];
    }


    @Override
    public Object insertAfter(Object p, Object l) {
        if(this.c==capacity-1){
              capacity*=2;
              Object[] novo = new Object[capacity];
              for (int i = 0; i < ar.length; i++) {
                  novo[i]=ar[i];
                }
              ar=novo;
            }
            int index = 0;
            for (int i = 0; i < ar.length; i++) {
                if(ar[i].equals(p)&&!(ar[i].equals(null))){
                     index = i ;
                     break;
                }
            }    
            for (int i = this.c+1; i>index+1; i--) {
                ar[i]=ar[i-1];
            }
            ar[index+1]=l;
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
                 } 
                }
              ar=novo;
            }
            for (int i = this.c+1; i>0; i--) {
                ar[i]=ar[i-1];     
            }
          //  System.out.println(this.c);
            //ShowElements();
            ar[0]=p;
            this.c++;
            return ar[0];
        }


    @Override
    public Object insertLast(Object m) {
        if(this.c==capacity-1){
              capacity*=2;
              Object[] novo = new Object[capacity];
              for (int i = 0; i < ar.length; i++) {
                  novo[i]=ar[i];
                }
              ar=novo;
            }
            ar[++c]=m;
            return ar[this.c];
        }
         
        public void ShowElements(){
            System.out.print("[");
            System.out.print(ar[0]);
            for (int i = 1; i < ar.length; i++) {
                System.out.print(" ,"+ar[i]);
            }
            System.out.print("]");
        }


        @Override
        public Object remove(Object no) {
            if(size()==0){
                throw new RuntimeException("Lista vazia");
            }
            int x=0;
            for (int i = this.c; i > 0; i--) {
                if(ar[i].equals(no)){
                     x=i;break;
                }
            }
            for (int i = x; i < this.c+1; i++) {
                 ar[i]=ar[i+1];
            }
            return no;
        }
}
