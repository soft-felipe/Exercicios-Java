package entites;

import java.util.Date;

public class HourContract {

    private Date date;
    private Double valuePerHor;
    private Integer hours;
    
    public HourContract() {
    }

    public HourContract(Date date, Double valuePerHor, Integer hours) {
        this.date = date;
        this.valuePerHor = valuePerHor;
        this.hours = hours;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValuePerHor() {
        return valuePerHor;
    }

    public void setValuePerHor(Double valuePerHor) {
        this.valuePerHor = valuePerHor;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    /**
     * Método para calcular o valor total do contrato
     */
    public Double totalValue() {
        return valuePerHor * hours;
    }
}
