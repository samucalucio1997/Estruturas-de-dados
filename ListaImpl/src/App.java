import Pilha.PilhaArray;
import Pilha.Preto;
import Pilha.Vermelho;

public class App {
    public static void main(String[] args) throws Exception {

        PilhaArray pilha = new PilhaArray(1, -4);

        pilha.pushRed(new Vermelho(4));
        pilha.pushBlack(new Preto(2));
        pilha.pushRed(new Vermelho(7));
        pilha.pushRed(new Vermelho(77));
        // pilha.push(new Preto(452));
        // pilha.push(new Preto(452));
        // pilha.push(new Preto(125));
        // pilha.push(new Vermelho(751));
        // pilha.push(new Preto(75));
        // pilha.push(new Preto(102));
        // pilha.push(new Preto(200));
        // pilha.push(new Vermelho(125));
        
        pilha.ShowElements();
        System.out.println(pilha.popPreto());
        pilha.ShowElements();
        System.out.println(pilha.topPreto());
        System.out.println(pilha.popVermelha());
        System.out.println(pilha.topVermelho());
        pilha.ShowElements();
    }
}
