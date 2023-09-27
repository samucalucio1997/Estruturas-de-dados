package FIFOWPil;

import PilhaExer.Deque;

public class FilaTestPil {
    public static void main(String[] args) {
        Fila f=new Fila(1,0); //criando fila tamnho 1 e duplicação
		f.enqueue(1);
		f.enqueue(2);
		f.enqueue(3);
		f.enqueue(4);
		try{
			System.out.println(f.first());
			f.dequeue();
			System.out.println(f.first());
			f.dequeue();
			System.out.println(f.first());
			f.dequeue();
			System.out.println(f.first());
			f.dequeue();
			System.out.println(f.first());
			// f.dequeue();
		
		}catch(FilaVaziaException erro){
			System.out.println(erro.getMessage());
			
		}
        
    }
}
