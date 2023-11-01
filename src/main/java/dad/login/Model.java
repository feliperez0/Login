package dad.login;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {

	private StringProperty usuario = new SimpleStringProperty();
	private StringProperty contra = new SimpleStringProperty();
	private BooleanProperty ldap = new SimpleBooleanProperty();
	
	public final StringProperty usuarioProperty() {
		return this.usuario;
	}
	
	public final String getUsuario() {
		return this.usuarioProperty().get();
	}
	
	public final void setUsuario(final String nombre) {
		this.usuarioProperty().set(nombre);
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
