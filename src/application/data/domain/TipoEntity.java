package application.data.domain;

import application.data.domain.base.BaseEntity;


public class TipoEntity extends BaseEntity{
	
	public TipoEntity(){
		super("Tipo","idTipo");
	}

	private int idTipo;
	private String nome;

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
