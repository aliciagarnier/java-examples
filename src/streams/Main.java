package streams;

public class Main {

    interface FactorialNumber {

        boolean test(int a, int b);
    }

    public static void main(String[] args) {


        FactorialNumber isFactor = (a, b) -> (b % a) == 0; // armazenar o "procedimento" em uma variável --> anônima.

        if(isFactor.test(9, 5)) {
            System.out.println("5 is a factor of 9");
        } else {
            System.out.println("5 is not a factor of 9");
        }
    }
}