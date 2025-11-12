package model;

public class Produtos {
private String dataFabricacao;
private String dataVencimento;
private String nomeProduto;
private double valor;
private int quantidade;
private String marca;
private String estado;
private int id;


public Produtos(String nomeProduto, String dataFabricacao, String dataVencimento, double valor, int quantidade, String marca, String estado) {
    this(nomeProduto, dataFabricacao, dataVencimento, valor, quantidade, marca, estado, 0);
}


public Produtos(String nomeProduto, String dataFabricacao, String dataVencimento, double valor, int quantidade, String marca, String estado, int id) {
    this.dataFabricacao = dataFabricacao;
    this.dataVencimento = dataVencimento;
    this.nomeProduto = nomeProduto;
    this.valor = valor;
    this.quantidade = quantidade;
    this.marca = marca;
    this.estado = estado;
    this.id = id;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getDataFabricacao() {
    return dataFabricacao;
}
public void setDataFabricacao(String dataFabricacao) {
    this.dataFabricacao = dataFabricacao;
}
public String getDataVencimento() {
    return dataVencimento;
}
public void setDataVencimento(String dataVencimento) {
    this.dataVencimento = dataVencimento;
}
public String getNomeProduto() {
    return nomeProduto;
}
public void setNomeProduto(String nomeProduto) {
    this.nomeProduto = nomeProduto;
}
public double getValor() {
    return valor;
}
public void setValor(double valor) {
    this.valor = valor;
}
public int getQuantidade() {
    return quantidade;
}
public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
}
public String getMarca() {
    return marca;
}
public void setMarca(String marca) {
    this.marca = marca;
}
public String getEstado() {
    return estado;
}
public void setEstado(String estado) {
    this.estado = estado;
}

public String getDataFabricacaoFormatada() {
    return (dataFabricacao == null) ? "" : dataFabricacao;
}
public String getDataVencimentoFormatada() {
    return (dataVencimento == null) ? "" : dataVencimento;
}

}