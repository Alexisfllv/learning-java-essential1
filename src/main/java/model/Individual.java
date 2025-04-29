package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Getter
public class Individual extends TaxPayer{

    private Double healthExpenditure;


    public Individual(String name, Double anualIncome, Double healthExpenditure) {
        super(name, anualIncome);
        this.healthExpenditure = healthExpenditure;
    }

    @Override
    public double calculateTaxes() {
        double basicTax;

        if (getAnualIncome() < 20_000) {
            basicTax = getAnualIncome() * 0.15;
        }else {
            basicTax = getAnualIncome() * 0.25;
        }
        basicTax -= getHealthExpenditure() * 0.5;

        if (basicTax < 0) {
            basicTax = 0;
        }
        return basicTax;
    }
}
