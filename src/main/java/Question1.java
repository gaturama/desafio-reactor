import reactor.core.publisher.Flux;

import java.util.List;

public class Question1 {

    /*
        Recebe uma lista de longs, incrementa 1 nos valores e retorna um flux dos resultados
     */

    public Flux<Long> inc(final List<Long> numbers) {
        return Flux.fromIterable(numbers)
                .map(n -> n + 1);
    }

    public static void main(String[] args) {
        Question1 q = new Question1();

        List<Long> lista = List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L);

        q.inc(lista)
                .doOnNext(System.out::println)
                .subscribe();
    }
}
