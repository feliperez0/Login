package dad.login;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {

	private StringProperty nombre = new SimpleStringProperty();
	private StringProperty contra = new SimpleStringProperty();
	private BooleanProperty ldap = new SimpleBooleanProperty();
	
	public final StringProperty nombreProperty() {
		return this.nombre;
	}
	
	public final String getNombre() {
		return this.nombreProperty().get();
	}
	
	public final void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}
	
	public final StringProperty contraProperty() {
		return this.contra;
	}
	
	public final String getContra() {
		return this.contraProperty().get();
	}
	
	public final void setContra(final String contra) {
		this.contraProperty().set(contra);
	}

    public final BooleanProperty ldapProperty() {
        return this.ldap;
    }
    
    public final boolean isLdap() {
        return this.ldapProperty().get();
    }

    public final void setLdap(final boolean ldap) {
        this.ldapProperty().set(ldap);
    }
	
}
