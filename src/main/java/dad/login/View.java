package dad.login;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class View extends VBox{

	private TextField nombreText;
	private Button accederButton, cancelarButton;
	private CheckBox ldapCheck;
	private PasswordField contraText;
	
	public View() {
		
		super();
		
		nombreText = new TextField();
		nombreText.setPromptText("Nombre de usuario");
		
		contraText = new PasswordField();
		contraText.setPromptText("Contraseña del usuario");
		
		ldapCheck = new CheckBox("Usar LDAP");
		
		accederButton = new Button("Acceder");
		cancelarButton = new Button("Cancelar");
		
		HBox nombreHBox = new HBox(5, new Label("Nombre: "), nombreText);
		
		HBox contraHBox = new HBox(5, new Label("Contraseña: "), contraText);
		
		HBox botonesHBox = new HBox(5, accederButton, cancelarButton);
		
		setSpacing(5);
		setFillWidth(false);
		setAlignment(Pos.CENTER);
		getChildren().addAll(nombreHBox, contraHBox, ldapCheck, botonesHBox);
		
	}

	public TextField getNombreText() {
		return nombreText;
	}

	public PasswordField getContraText() {
		return contraText;
	}
	
    public CheckBox getLdapCheck() {
        return ldapCheck;
    }

    public Button getAccederButton() {
        return accederButton;
    }

    public Button getCancelarButton() {
        return cancelarButton;
    }
	
}
