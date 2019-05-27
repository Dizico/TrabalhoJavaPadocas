package application.model;

public class Filter {
    private String nameField;
    private Object value;

    public Filter(String nameField, Object value) {
        this.nameField = nameField;
        this.value = value;
    }

    public String getNameField() {
        return nameField;
    }

    public void setNameField(String nameField) {
        this.nameField = nameField;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
