package application.data.domain;

import application.data.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class TipoEntity extends BaseEntity{
	
	public TipoEntity(){
		super("Tipo","idTipo");
	}

	private int idTipo;
	private String nome;
}
