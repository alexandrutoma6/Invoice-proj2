package ro.alex;

public record Address(
        String country,
        String city,
        int number
) {
    @Override
    public String toString() {
        return country + ", " + city+ ", numar: " + number;
    }
}
