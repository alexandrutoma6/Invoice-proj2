package ro.alex;

public record Invoice(
        int serialNumber,
        String companyName,
        Address address,
        Date_alex date,
        int cif,
        double invoiceTotal
) {
}
