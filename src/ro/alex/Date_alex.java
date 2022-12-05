package ro.alex;

public record Date_alex(
        int day,
        int month,
        int year
) {
    @Override
    public String toString() {
        return day+"."+month+"."+year;
    }
}
