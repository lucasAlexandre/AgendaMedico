package modelo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


public class Paciente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6183322718052064619L;

	private String nome;
	private String cpf;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Paciente(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}	
	
	
	