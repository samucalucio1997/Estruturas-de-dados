import Pilha.PilhaArray;
import Pilha.Preto;
import Pilha.Vermelho;

public class App {
    public static void main(String[] args) throws Exception {
                
        PilhaArray pilha  = new PilhaArray(1, -4);

        pilha.push(new  Vermelho(4));
        pilha.push(new  Preto(45));
        //  pilha.push(new  Vermelho(7));
           pilha.push(new  Preto(2));
           
         System.out.println(pilha.size());
           System.out.println(pilha.topPreto());
           System.out.println(pilha.topVermelho());

    }
}
