package application;

import java.text.SimpleDateFormat;
import java.util.Date;

import entities.Order;
import enumeracoes.OrderStatus;

public class Program {

    public static void main(String[] args) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // passando como eu quero que seja 
        // impressa a data, nesse caso, a data vira uma String e deixa de ser do tipo Date
        
        Order order = new Order(111, sdf.format(new Date()), OrderStatus.AGUARDANDO_PAGAMENTO);

        System.out.println(order);

        OrderStatus os1 = OrderStatus.PROCESSANDO;
        OrderStatus os2 = OrderStatus.valueOf("PROCESSANDO");

        System.out.println(os1);
        System.out.println(os2);
    }
}
