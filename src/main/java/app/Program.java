package app;

import model.Company;
import model.Individual;
import model.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Pagos de Taxes");
        System.out.println(" number of tax payers: ");
        int numberOfTaxPayers = scan.nextInt();

        // primer parametro de payer
        final int FIRST_POSITION = 0;
        // 0 123456
        // I ndividual
        // c ompany

        List<TaxPayer> listTaxPayers = new ArrayList<>();

        for (int i = 1; i <= numberOfTaxPayers ; i++) {
            System.out.println("Enter tax payer # "+1+" : ");
            System.out.println("Individual or Company (i/c) : ");
            char type = Character.toLowerCase(scan.next().charAt(FIRST_POSITION));
            System.out.println("Name : ");
            String name = scan.next();
            System.out.println("Annual income : ");
            Double anualIncome = scan.nextDouble();

            if (type == 'i'){
                System.out.println("Health expenditure : ");
                double healthExpenditure = scan.nextDouble();

                Individual individual = new Individual(name, anualIncome, healthExpenditure);

                listTaxPayers.add(individual);
            }else {
                System.out.println("Number of Employees : ");
                int numberOfEmployees = scan.nextInt();
                Company company = new Company(name, anualIncome, numberOfEmployees);
                listTaxPayers.add(company);

            }

        }
        System.out.println("-==========-");
        System.out.println("Taxes paid");
        double sum =0;
        for (TaxPayer taxPayer : listTaxPayers) {
            System.out.println(taxPayer.getName()+" : "+taxPayer.calculateTaxes());
            sum += taxPayer.calculateTaxes();
        }
        System.out.println("Total taxes paid: "+sum);

    }
}
