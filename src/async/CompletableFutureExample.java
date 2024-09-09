package async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public void run() throws ExecutionException, InterruptedException {
        CompletableFuture.runAsync(() -> {
            PokemonAbilityFetch pokemonAbilityFetch = new PokemonAbilityFetch("pikachu");
            pokemonAbilityFetch.fetch();
        }).get(); // executar essa parte do código onde o resultado (retorno) não importa. desejo apenas executar.
    }

}
