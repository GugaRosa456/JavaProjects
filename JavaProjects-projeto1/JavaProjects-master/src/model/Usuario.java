package model;

public class Usuario {
private String Nome;
private String CPF;
private String Usuario;
private int senha;

public Usuario(String Nome, String CPF, String Usuario, int senha) {
this.Nome = Nome;
this.CPF = CPF;
this.Usuario = Usuario;
this.senha = senha;
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

public String getUsuario() {
	return Usuario;
}

public void setUsuario(String usuario) {
	Usuario = usuario;
}

public int getSenha() {
	return senha;
}

public void setSenha(int senha) {
	this.senha = senha;
}
}
