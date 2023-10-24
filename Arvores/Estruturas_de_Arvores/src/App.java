  import GenericTree.ArvoreGeni;
  import GenericTree.No;

  public class App {
      public static void main(String[] args) throws Exception {
     ArvoreGeni<String> SetNodes = new ArvoreGeni<>();
      No<String> node1 = new No<String>("primeiro");
      No<String> node2 = new No<String>("segundo");
      No<String> node3 = new No<String>("terceiro"); 
      SetNodes.InsertNo(SetNodes.getRoot(), node1);
      SetNodes.InsertNo(node1, node2);
      SetNodes.InsertNo(node1, node3);
      SetNodes.InsertNo(node2, new No<String>("carro"));
      SetNodes.InsertNo(node1, new No<String>("cerca"));

      SetNodes.GetNo(SetNodes.getRoot());

      }
  }
