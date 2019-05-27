package application.data.domain.base;

public abstract class BaseEntity {

	public BaseEntity(String table, String nameOfIdField) {
		this.table = table;
		this.id = nameOfIdField;
	}

	protected String table;
	protected String id;

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
