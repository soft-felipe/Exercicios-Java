package entites;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import enums.WorkerLevel;

public class Worker {

    // ATRIBUTOS BÁSICOS:
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    // ASSOCIAÇÕES:
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();
    
    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    /**
     * Método para adicionar um novo contrato
     * 
     * @param contract Novo contrato
     */
    public void addContract(HourContract contract) {
        contracts.add(contract); // A função .add para adicionar um elemento na lista
    }

    /**
     * Método para remover um contrato que já estava na lista
     * 
     * @param contract Contrato a ser removido
     */
    public void removeContract(HourContract contract) {
        contracts.remove(contract); // A função .remove para remover um elemento na lista
    }

    /**
     * Método para calcular o valor de um determinado contrato, a partir do seu mês e ano
     * 
     * @param year Ano do contrato a ser procurado
     * @param month Mês do contrato a ser procurado
     * @return Valor total desse contrato
     */
    public double income(int year, int month) {

        double sum = baseSalary;
        Calendar cal = Calendar.getInstance(); // Utilizando o objeto Calendar para acessar as datas

        for (HourContract c : contracts) {

            cal.setTime(c.getDate()); // Guardando as datas para acessá-las
            int c_year = cal.get(Calendar.YEAR); // Acessando o ano dos contratos
            int c_month = 1 + cal.get(Calendar.MONTH); // Acessando os meses dos contratos

            if (year == c_year && month == c_month) {
                sum += c.totalValue();
            }
        }

        return sum;
    }
}