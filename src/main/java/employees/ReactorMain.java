package employees;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class ReactorMain {
    public static void main(String[] args) {
        //Lehetne stream is
        //Stream.of(new Employee("John", 1980))

        //Non blocking backpressure -  nem árasztjuk el a fogyasztót
        Flux.just(new Employee("John", 1980), new Employee("Jane", 1990))
                .filter(
                        employee -> employee.getAgeAt() > 1982
                )
                .map(Employee::name)
                .subscribe(
                        System.out::println
                );


        //Elemek bevárása lehetséges a block(Mono) vagy blockFirst/blockLast(Flux) metódussal
        //Ez már blokkoló programozás
        Flux.just(new Employee("John", 1980), new Employee("Jane", 1990))
                .filter(
                        employee -> employee.getAgeAt() > 1982
                )
                .map(Employee::name)
                //Ezt sose használjuk, pl Spring alkalmazásban kivételt dob
                .blockFirst();

        //Lehetne optional
        //Optional.of(new Employee("John", 1980)).stream().forEach(System.out::println);
        Mono.just(new Employee("John", 1980))
                .subscribe(System.out::println);

        //Mono -> Flux és Flux -> Mono is működik
        //Értelemszerűen ha több elem van akkor a Mono hibát dob
        //Futtatás nem állna meg, csak a stream lenne korrupt -> onErrorDropeed -> hibakezelés is callbback-ekkel megy
        Flux.just(new Employee("John", 1980), new Employee("Jane", 1990))
                .filter(
                        employee -> employee.getAgeAt() > 1982
                ).singleOrEmpty().subscribe(System.out::println);
    }
}
