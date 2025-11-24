package employees;

import reactor.core.publisher.Flux;

public class ReactorMain {
    public static void main(String[] args) {
        //Lehetne stream is
        //Stream.of(new Employee("John", 1980))

        //Non blocking backpressure -  nem árasztjuk el a fogyasztót
        Flux.just(new Employee("John", 1980))
                .subscribe(
                        System.out::println
                );
    }
}
