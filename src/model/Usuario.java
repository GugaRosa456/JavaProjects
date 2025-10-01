package model;

public class Usuario {
private String Nome;
private int CPF;
private int senha;
private boolean isadmin;

public Usuario(String Nome, int Senha, int CPF, boolean isadmin) {
this.Nome = Nome;
this.CPF = CPF;
this.senha = Senha;
this.isadmin = isadmin;
}

public boolean isAdmin() {
	return isadmin;
}

public void setAdmin(boolean admin) {
	this.isadmin = admin;
}



public String getNome() {
	return Nome;
}

public void setNome(String nome) {
	Nome = nome;
}

public int getSenha() {
	return senha;
}

public void setSenha(int senha) {
	this.senha = senha;
}
public int getCPF() {
	return CPF;
}

public void setCPF(int cpf) {
	CPF = cpf;
}

}
