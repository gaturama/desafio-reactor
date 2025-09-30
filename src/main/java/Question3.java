import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Question3 {

    /*
       Verifica se o usuário passado é valido, caso seja retorna void, caso contrário deve disparar uma exception
       (para esse desafio vamos considerar que o usário é valido quando ele tem uma senha com mais de 8 caractéres)
    */

    public Mono<Void> userIsValid(final User user) {
        if (user.password().length() >= 8) {
            return Mono.empty();
        } else {
            return Mono.error(new Exception("A senha possui menos de 8 caracteres"));
        }
    }

    public static void main(String[] args) {
        Question3 q = new Question3();

        User u1 = new User(1L, "Gabriel", "gabriel@email.com", "12345678903", true);
        User u2 = new User(2L, "Pedro", "pedro@email.com", "1263489700", false);
        User u3 = new User(3L, "Thiago", "thiago@email.com", "78912340000", true);

        q.userIsValid(u1)
                .doOnSuccess(System.out::println)
                .doOnError(System.err::println)
                .subscribe();

        q.userIsValid(u2)
                .doOnSuccess(System.out::println)
                .doOnError(System.err::println)
                .subscribe();

        q.userIsValid(u3)
                .doOnSuccess(System.out::println)
                .doOnError(System.err::println)
                .subscribe();
    }
}
