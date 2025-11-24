package employees;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    @Test
    void findEmployeeByName() {
        EmployeeService employeeService = new EmployeeService();
        StepVerifier.create(
                employeeService.findEmployeeByName("John")
        ).expectNext(new Employee("John", 1980))
         .verifyComplete();
    }

    @Test
    void findEmployeeByNameByFilter() {
        EmployeeService employeeService = new EmployeeService();
        StepVerifier.create(
                        employeeService.findEmployeeByName("John")
                ).expectNextMatches(e -> e.name().equals("John"))
                .verifyComplete();
    }
}