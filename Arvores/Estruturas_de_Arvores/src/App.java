  import java.util.Iterator;

import GenericTree.ArvoreGeni;
import GenericTree.ArvreGeni;
import GenericTree.No;

  public class App {
      public static void main(String[] args) throws Exception {
    //  ArvoreGeni<String> SetNodes = new ArvoreGeni<>();
    //   No<String> node1 = new No<String>("primeiro");
    //   No<String> node2 = new No<String>("segundo");
    //   No<String> node3 = new No<String>("terceiro"); 
    //   SetNodes.InsertNo(SetNodes.getRoot(), node1);
    //   SetNodes.InsertNo(node1, node2);
    //   SetNodes.InsertNo(node1, node3);
    //   SetNodes.InsertNo(node2, new No<String>("carro"));
    //   SetNodes.InsertNo(node1, new No<String>("cerca"));
    ArvreGeni<Integer> tree = new ArvreGeni<Integer>(54);
    No<Integer> node1 = new No<Integer>(tree.root(), 125);
    No<Integer> node2 = new No<Integer>(node1, 56);
    No<Integer> node3 = new No<Integer>(tree.root(), 11);
    No<Integer> node4 = new No<Integer>(node3, 12);
    tree.addChild(tree.root(), new No<Integer>(tree.root(),112));
    tree.addChild(tree.root(), node1);
    tree.addChild(tree.root(), node3);
    tree.addChild(node1,new No<Integer>(node1,340));
    tree.addChild(node1, node2);
    tree.addChild(node3, node4);  
    tree.addChild(node2, new No<Integer>(node2,22));
    tree.addChild(node2,new No<Integer>(node2,3));
    // tree.preOrdem(tree.root());
    System.out.println(tree.depth(node4));
    System.out.println(tree.Pesquisar(new No<Integer>(tree.root(), 112)));

    Iterator<No<Integer>> princ =  tree.elements(); 
    while (princ.hasNext()) {
      System.out.println(princ.next());
    }  
  }
  }
