package dad.login;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import dad.login.auth.AuthService;
import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;

public class Controller {
    private View view;
    private Model model;
    private AuthService authService;
    
    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
                
        view.getAccederButton().setOnAction(e -> login());
        view.getCancelarButton().setOnAction(e -> cancelar());
        
        view.getUsuarioText().textProperty().addListener((o, ov, nv) -> {
        	model.setUsuario(nv);
        });
        
        view.getContraText().textProperty().addListener((o, ov, nv) -> {
        	model.setContra(nv);
        });
        
        view.getLdapCheck().selectedProperty().addListener((o, ov, nv) -> {
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

    }


