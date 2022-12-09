package ro.alex;

import java.time.LocalDate;

public record Invoice(
        int serialNumber,
        String companyName,
        Address address,
        LocalDate date,
        int cif,
        double invoiceTotal
) {
}
