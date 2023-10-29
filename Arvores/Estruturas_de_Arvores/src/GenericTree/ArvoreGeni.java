package GenericTree;


public class ArvoreGeni<t> {
    int[][] ar = new int[1000][1000];
    private int t=1;
    // private No<t> root = new No<t>(null);
    
    // public boolean isInternal(No<t> no){
    //     if(!no.getFilhos().hasNext()){
    //         return true;
    //     }
    //     return false;
    // }
    
    // public boolean isRoot(No<t> no){
    //     return no.equals(root);
    // }
    
//     public void InsertNo(No<t> raiz,No<t> insertNo){
//         insertNo.setFather(raiz);
//         raiz.adicionarNoint(insertNo);
//         t++;
//     }
    
//     public No<t> Pega1NO(No<t> raiz,No<t> ref){
//         No<t> cursor = raiz;
//         if(cursor.getFilhos()==null){
//            cursor = cursor.getFather();
//            while(cursor.getFilhos().hasNext()){
//                if(cursor.getValue().equals(ref.getValue())){
//                     break;
//                }
//            }
//            return cursor;
//         }else{
//             // while (condition) {
                
//             // }
//         }

//         return null;
//    }

    // public void GetNo(No<t> raiz){
    //     No<t> cursor = raiz;
    //     if(!cursor.getFilhos().hasNext()){
    //         return;
    //     }
    //     for (No<t> is : cursor) {
    //         System.out.println(is.getValue());
    //         GetNo(is);
    //     }
    // }
///////////////////////////////////////////////////////////////////////
    // public No<t> getRoot() {
    //     return root;
    // }
    
    // public void setRoot(No<t> root) {
    //     this.root = root;
    // }
///////////////////////////////////////////////////////////////////////    
}
