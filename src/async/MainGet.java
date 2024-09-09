package async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MainGet {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
       try {
         CompletableFuture.runAsync(() -> {
            PokemonAbilityFetch pokemonAbilityFetch = new PokemonAbilityFetch("pikachu");
            pokemonAbilityFetch.fetch();
        }).get();

        for(int i = 0; i < 10; i++) {
            System.out.println("Main thread is running...");
            Thread.sleep(10000);
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
