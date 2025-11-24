package employees;

import java.time.LocalDate;
import java.util.List;

public record Employee(String name, int yearOfBirth) {

    public int getAgeAt(int year) {
        if (year < yearOfBirth) {
            throw new IllegalArgumentException("Year %d cannot be before year of birth %d".formatted(year, yearOfBirth));
        }
        return year - this.yearOfBirth;
    }

    public int getAgeAt() {
        int year = LocalDate.now().getYear();
        if (year < yearOfBirth) {
            throw new IllegalArgumentException("Year %d cannot be before year of birth %d".formatted(year, yearOfBirth));
        }
        return year - this.yearOfBirth;
    }

    public List<Character> getNameCharacters() {
        return name.chars()
                .mapToObj(c -> (char) c)
                .toList();
    }
}
