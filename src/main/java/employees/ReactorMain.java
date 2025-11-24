package employees;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

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
    }
}
