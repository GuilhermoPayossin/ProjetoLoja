import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Produto> lista = new ArrayList<>();
        lista.add(new Produto(1, "Arroz", 19.99));
        lista.add(new Produto(1, "Arroz", 19.99));
        lista.add(new Produto(1, "Arroz", 19.99));
        lista.add(new Produto(1, "Arroz", 19.99));
        lista.add(new Produto(3, "Chocolate", 9.99));

        System.out.println(lista);
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getNome().equalsIgnoreCase("arroz")) {
                lista.remove(i);
            }
        }

        lista.remove(new Produto(1, "Arroz", 19.99));

        for (Produto p : lista) {

        }
        System.out.println("--------------------");
        System.out.println(lista);
    }
}