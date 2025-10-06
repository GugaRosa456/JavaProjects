package model;

public class Usuario {
private String nome;
private String senha;
private String cpf;
private boolean isadmin;


public Usuario(String nome, String senha, String cpf, boolean isadmin) {
this.nome = nome;
this.senha = senha;
this.cpf = cpf;
this.isadmin = isadmin;
}

public boolean isAdmin() {
	return isadmin;
}

public void setAdmin(boolean admin) {
	this.isadmin = admin;
}



public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCPF() {
	return cpf;
}

public void setCPF(String cpf) {
	this.cpf = cpf;
}

public String getSenha() {
	return senha;
}

public void setSenha(String senha) {
	this.senha= senha;
}



}
