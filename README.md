# Employee Reactive Programming Example

A Java SE project demonstrating reactive programming concepts using Project Reactor.

## Overview

This project showcases the fundamentals of reactive programming in Java using the Reactor library. It demonstrates key concepts including `Flux`, `Mono`, error handling, and the difference between reactive and blocking operations.

## Features

### Reactive Streams
- **Flux**: Working with multiple elements (0..N)
- **Mono**: Working with single elements (0..1)
- **Backpressure**: Non-blocking stream processing

### Key Concepts Demonstrated

1. **Basic Stream Operations**
   - Filtering employees by age
   - Mapping to extract employee names
   - Non-blocking subscription

2. **Blocking vs Non-Blocking**
   - Reactive subscription with callbacks
   - Blocking operations (`blockFirst()`) - shown for educational purposes only

3. **Conversions**
   - Mono to Flux and vice versa
   - `singleOrEmpty()` for single element extraction

4. **Error Handling**
   - `onErrorReturn()` - Return a default value on error
   - `onErrorResume()` - Switch to alternative stream on error
   - `doOnError()` - Side effect for error logging

5. **FlatMap Operations**
   - Transforming single elements into multiple elements
   - Converting collections to reactive streams
   - Error handling within nested streams

## Project Structure

```
employees-se/
├── src/
│   └── main/
│       └── java/
│           └── employees/
│               ├── Employee.java      # Record class for Employee
│               └── ReactorMain.java   # Main demonstration class
├── pom.xml                            # Maven configuration
└── README.md                          # This file
```

## Classes

### Employee.java
A Java record representing an employee with:
- `name` - Employee name
- `yearOfBirth` - Year of birth

**Methods:**
- `getAgeAt(int year)` - Calculate age at a specific year (throws exception if year < yearOfBirth)
- `getAgeAt()` - Calculate current age
- `getNameCharacters()` - Get list of characters in the employee's name

### ReactorMain.java
Main class demonstrating various reactive programming patterns:
- Stream filtering and mapping
- Error handling strategies
- FlatMap for complex transformations
- Difference between reactive and blocking code

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- Project Reactor library (included in pom.xml)

## Running the Project

```bash
# Compile the project
mvn clean compile

# Run the main class
mvn exec:java -Dexec.mainClass="employees.ReactorMain"
```

Or run directly from your IDE by executing the `ReactorMain.main()` method.

## Example Output

The program demonstrates various reactive patterns and will output results showing:
- Filtered employee names
- Error handling with default values
- Character-by-character name processing
- Age calculations with error recovery

## Key Takeaways

### ✅ DO
- Use reactive streams for non-blocking operations
- Handle errors using `onErrorReturn()` or `onErrorResume()`
- Use `flatMap()` for complex transformations and nested error handling
- Subscribe with callbacks for reactive execution

### ❌ DON'T
- Avoid using `block()`, `blockFirst()`, or `blockLast()` in production (especially in Spring applications)
- Don't ignore error handling in reactive streams
- Don't break the reactive chain by introducing blocking operations

## Dependencies

```xml
<dependency>
    <groupId>io.projectreactor</groupId>
    <artifactId>reactor-core</artifactId>
    <version>3.x.x</version>
</dependency>
```

## Learning Resources

- [Project Reactor Documentation](https://projectreactor.io/docs)
- [Reactive Streams Specification](https://www.reactive-streams.org/)
- [Reactor Core Reference Guide](https://projectreactor.io/docs/core/release/reference/)

## License

This is a training/educational project.

## Author

Training project for Java reactive programming concepts.

