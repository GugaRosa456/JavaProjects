package model;

public class Usuario {
private String Nome;
private String CPF;
private String Senha;
private boolean isadmin;

public Usuario(String Nome, String Senha, String CPF, boolean isadmin) {
this.Nome = Nome;
this.CPF = CPF;
this.Senha = Senha;
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

public String getCPF() {
	return CPF;
}

public void setCPF(String cPF) {
	CPF = cPF;
}

public String getSenha() {
	return Senha;
}

public void setSenha(String senha) {
	Senha = senha;
}



}
