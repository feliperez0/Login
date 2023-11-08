package dad.login;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.login.auth.AuthService;
import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Controller implements Initializable{
    private Model model;
    private AuthService authService;
    
    @FXML
    private Button accederButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private PasswordField contraText;

    @FXML
    private CheckBox ldapCheck;

    @FXML
    private TextField usuarioText;

    @FXML
    private VBox root;
    
    
    public Controller(Model model) {
        this.model = model;
                
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
			loader.setController(this);
			loader.load();
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
        
        accederButton.setOnAction(e -> login());
        cancelarButton.setOnAction(e -> cancelar());
        
        usuarioText.textProperty().addListener((o, ov, nv) -> {
        	model.setUsuario(nv);
        });
        
        contraText.textProperty().addListener((o, ov, nv) -> {
        	model.setContra(nv);
        });
        
        ldapCheck.selectedProperty().addListener((o, ov, nv) -> {
        	model.setLdap(nv);
        });
        
    }
               
        public void login() {
        	
        	boolean autenticado = false;
        	
        	if(model.isLdap())
        		authService = new LdapAuthService();
        	else 
        		authService = new FileAuthService();
        		
        	try {
        		
        		autenticado = authService.login(model.getUsuario(), model.getContra());
        
        	}catch(Exception e ) {
      
        		auntenticacionIncorrecta();
        		
        	}
        	
        	if(autenticado == true) {
        		auntenticacionCorrecta();
        		System.exit(0);
        	}else 
        		auntenticacionIncorrecta();
        
	}

		private void auntenticacionCorrecta() {
        	Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Iniciar sesión");
        	alert.setHeaderText("Acceso permitido");
        	alert.setContentText("Las creedenciales de acceso son válidas");

        	alert.showAndWait();
        }
        
        private void auntenticacionIncorrecta() {
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("Iniciar sesión");
        	alert.setHeaderText("Acceso denegado");
        	alert.setContentText("El usuario y/o la contraseña no son válido");

        	alert.showAndWait();
        }
  
        
        public void cancelar() {
            System.exit(0);
        }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
		}

		public VBox getView() {
			return root;
			
		}
		
    }


