package employees;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class EmployeeService {

    private List<Employee> employees = List.of(
        new Employee("John", 1980),
        new Employee("Jane", 1990),
        new Employee("Alice", 1985),
        new Employee("Bob", 1975)
    );

    public Mono<Employee> findEmployeeByName(String name) {
        return Flux.fromIterable(employees)
                .filter(e -> e.name().equalsIgnoreCase(name))
                .singleOrEmpty();
    }
}
