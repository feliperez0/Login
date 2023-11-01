package dad.login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class View extends VBox{

	private TextField usuarioText;
	private Button accederButton, cancelarButton;
	private CheckBox ldapCheck;
	private PasswordField contraText;
	
	public View() {
		
		super();
		
		usuarioText = new TextField();
		usuarioText.setPromptText("Nombre de usuario");
		
		contraText = new PasswordField();
		contraText.setPromptText("Contraseña del usuario");
		
		ldapCheck = new CheckBox("Usar LDAP");
		
		accederButton = new Button("Acceder");
		cancelarButton = new Button("Cancelar");
		
		HBox botonesHBox = new HBox(5, accederButton, cancelarButton);
		
		GridPane root = new GridPane();
		root.setHgap(5);
		root.setVgap(5);
		root.setPadding(new Insets(5));
		root.addRow(0, new Label("Usuario: "), usuarioText);
		root.addRow(1, new Label("Contraseña: "), contraText);
		root.addRow(2, new Label(""), ldapCheck);
		
		setSpacing(5);
		setFillWidth(false);
		setAlignment(Pos.CENTER);
		getChildren().addAll(root, botonesHBox);		
	}

	public TextField getUsuarioText() {
		return usuarioText;
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
