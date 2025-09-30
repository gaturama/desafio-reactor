import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Question2 {

     /*
        Recebe uma lista de usuários e retorna a quantos usuários admin tem na lista
     */

    public Mono<Long> countAdmins(final List<User> user) {
        return Flux.fromIterable(user)
                .filter(User::isAdmin)
                .count();
    }

    public static void main(String[] args) {
        Question2 q = new Question2();

        List<User> lista = List.of(
                new User(1L, "Gabriel", "gabriel@email.com", "123", true),
                new User(2L, "Pedro", "pedro@email.com", "245", false),
                new User(3L, "Thiago", "thiago@email.com", "789", true),
                new User(4L, "Henrique", "henrique@email.com", "323", false),
                new User(5L, "Juliano", "juliano@email.com", "369", false)
        );

        q.countAdmins(lista)
                .doOnNext(System.out::println)
                .subscribe();
    }
}
