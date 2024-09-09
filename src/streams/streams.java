package streams;

import java.util.ArrayList;
import java.util.List;

public class streams {

    // A API de streams.streams foi introduzida no Java 8, seu objetivo é facilitar trabalhar com conjunto de dados. A ideia é
    // iterar sobre coleções de objetos, e a cada elemento, realizar alguma ação ou aplicar uma função.

    public static void main(String[] args) {

        List<String> frutas = new ArrayList<String>();

        frutas.add("maça");
        frutas.add("banana");
        frutas.add("mango");

        // Esse loop especifica como queremos adicionar o valor de cada elemento. Essa técnica é conhecida como iteração externa (porque é você que especifica como iterar não a biblioteca)
        // e exige acessar os elementos sequencialmente do início ao fim em uma única thread de execução.
        // A iteração externa é propensa a erros.

        for (int i = 0; i < frutas.size(); i++)
        {
            System.out.println("Fruta: " + frutas.get(i));
        }

        frutas.stream().forEach(System.out::println); // Não faz nada além de chamar um método
        //frutas.stream().forEach(item -> System.out.println(item));

    }
}
