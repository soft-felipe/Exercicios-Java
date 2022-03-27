package entidades;

public class Produto {
    
    private Integer codigo;
    private String nome;
    private Double precoCompra;
    private Double precoVenda;
    private Integer quantidade;

    public Produto() {

    }

    public Produto(Integer codigo ,String nome, Double precoCompra, Double precoVenda, Integer quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.quantidade = quantidade;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public static Double calcularGastos(Double precoCompra, Integer quantidade) {
        return precoCompra * quantidade;
    }

    public static Double calcularLucro(Double precoCompra ,Double precoVenda, Integer quantidade) {
        return (precoVenda - precoCompra) * quantidade;
    }

    public String toString() {
        return
        "Codigo: " + codigo + "\n"
        + "Nome: " + nome + "\n"
        + "Preco de compra: " + String.format("%.2f", precoCompra) + "\n"
        + "Preco de venda: " + String.format("%.2f", precoVenda) + "\n"
        + "Quantidade em estoque: " + quantidade + "\n"
        + "Gastos: " + String.format("%.2f", calcularGastos(precoCompra, quantidade)) + "\n"
        + "Lucro esperado: " + String.format("%.2f", calcularLucro(precoCompra, precoVenda, quantidade));
    }
}
