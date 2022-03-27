package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entites.Department;
import entites.HourContract;
import entites.Worker;
import enums.WorkerLevel;

public class Program {

    public static void main(String[] args) throws ParseException {
 
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println();

        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();

        // Instanciando o objeto principal Worker e passando os atributos normalmente, entretanto o workerLevel
        // precisa ser passado com a função .valueOf por ser uma enumeração e o department precisa ser instanciado
        // pois se trata de uma associação (combinação), ou seja, um objeto dentro do outro;
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
        System.out.println();

        System.out.print("How many contracts to this worker? ");
        int numberContracts = sc.nextInt();
        System.out.println();

        for (int i = 1; i <= numberContracts; i++) {

            System.out.printf("Enter contract #%d data:\n", i);
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHor = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();

            HourContract contract = new HourContract(contractDate, valuePerHor, hours); // O contrato foi criado
            worker.addContract(contract); // O contrato foi atribuído ao funcionário
            System.out.println();
        }

        System.out.printf("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2)); // Quebrando a string maior em uma subtring e a transformando em um inteiro
        int year = Integer.parseInt(monthAndYear.substring(3)); // Quebrando a string maior em uma subtring e a transformando em um inteiro
        System.out.println();

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName()); // Funcionário -> Departamento -> Nome do departamento
        System.out.printf("Income for %s : %.2f\n", monthAndYear, worker.income(year, month));

        sc.close();
    }
}
