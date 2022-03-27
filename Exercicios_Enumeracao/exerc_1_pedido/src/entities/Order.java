package entities;

import java.util.Date;

import enumeracoes.OrderStatus;

public class Order {
    
    private Integer numero;
    private String momento;
    private OrderStatus situacao;

    public Order() {

    }

    public Order(Integer numero, String momento, OrderStatus situacao) {
        this.numero = numero;
        this.momento = momento;
        this.situacao = situacao;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /*public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    } */

    public OrderStatus getSituacao() {
        return situacao;
    }

    public void setSituacao(OrderStatus situacao) {
        this.situacao = situacao;
    }

    public String toString() {
        return "Order [momento=" + momento + ", numero=" + numero + ", situacao=" + situacao + "]";
    }
}
