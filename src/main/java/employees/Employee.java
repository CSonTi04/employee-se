package employees;

public record Employee(String name, int yearOfBirth) {

    public int getAgeAt(int year) {
        if (year < yearOfBirth) {
            throw new IllegalArgumentException("Year %d cannot be before year of birth %d".formatted(year, yearOfBirth));
        }
        return year - this.yearOfBirth;
    }

    public int getAgeAt() {
        int year = 2025;
        if (year < yearOfBirth) {
            throw new IllegalArgumentException("Year %d cannot be before year of birth %d".formatted(year, yearOfBirth));
        }
        return year - this.yearOfBirth;
    }
}
