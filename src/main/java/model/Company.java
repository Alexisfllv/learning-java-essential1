package model;

import lombok.Getter;

@Getter
public class Company extends TaxPayer {

    private Integer numberOfEmployees;

    public Company(String name, Double anualIncome, Integer numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double calculateTaxes() {
        if (getNumberOfEmployees() > 10) {
            return getAnualIncome() * 0.14;
        }else {
            return getAnualIncome() * 0.16;
        }
    }
}
