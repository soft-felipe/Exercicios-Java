package apliccation;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import entites.Employee;

public class Program {

    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>(); // implementando uma nova lista de objetos

        System.out.print("How many employees will be registred? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println();
            System.out.printf("Employee #%d:\n", i+1);

            System.out.print("Id: ");
            Integer id = sc.nextInt();
            while (hasId(list, id)) {
                System.out.print("Id already taken! Try again: ");
                id = sc.nextInt();
            }

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary);

            list.add(emp);
        }

        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        int idIncrease = sc.nextInt(); 
        Integer pos = positionIncrease(list, idIncrease); //passando a lista de objetos o id do funcionário que
        // vai ter o salário aumentado

        if (pos == null) {
            System.out.println("This id does not exist!");
        } else {
            System.out.print("Enther the porcentage: ");
            double percentage = sc.nextDouble();
            list.get(pos).increaseSalary(percentage); //acessando a lista no indice "pos" e chamando a função para
            // aumentar o salário do funcionário
        }

        System.out.println();
        System.out.println("List of employees:");
        for (Employee emp : list) { // utilizando o for each para percorrer toda a lista de objetos e imprimi-los
            System.out.println(emp);
        }


        sc.close();
    }

    /**
     * Método para percorrer toda a lista de objetos e verificar se o ID digitado na entrada
     * é válido, ou seja, se existe dentro da lista na propriedade "id"
     * 
     * @param list Lista de objetos, nesse caso as propriedades de cada funcionário
     * @param idIncrease O ID do funcionário que terá o salário aumentado
     * @return Retorna a posição na lista do funcionário encontrado
     */
    public static Integer positionIncrease (List<Employee> list, int idIncrease) {

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getId() == idIncrease) {
                return i;
            }
        }

        return null;
    }

    /**
     * Método para verificar se o ID digitado já existe ou não
     * 
     * @param list Lista de objetos
     * @param id Novo ID que vai ser adicionado à lista, mas para isso precisa ser verificado
     * @return retorna se o ID já existe ou não
     */
    public static boolean hasId(List<Employee> list, int id) {

        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}
