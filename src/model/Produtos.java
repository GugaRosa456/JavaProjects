package model;

public class Produtos {
private int dataFabricacao;
private int dataVencimento;
private String nomeProduto;
private int valor;
private int quantidade;
private String marca;
private String estado;

public Produtos(String nomeProduto, int dataFabricacao, int dataVencimento,  int valor, int quantidade, String marca, String estado) {
this.dataFabricacao = dataFabricacao;
this.dataVencimento = dataVencimento;
this.nomeProduto = nomeProduto;
this.valor = valor;
this.quantidade = quantidade;
this.marca = marca;
this.estado = estado;
}

public int getDataFabricacao() {
	return dataFabricacao;
}
public void setDataFabricacao(int dataFabricacao) {
	this.dataFabricacao = dataFabricacao;
}
public int getDataVencimento() {
	return dataVencimento;
}
public void setDataVencimento(int dataVencimento) {
	this.dataVencimento = dataVencimento;
}
public String getNomeProduto() {
	return nomeProduto;
}
public void setNomeProduto(String nomeProduto) {
	this.nomeProduto = nomeProduto;
}
public int getValor() {
	return valor;
}
public void setValor(int valor) {
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

}
