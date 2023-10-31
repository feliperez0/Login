package dad.login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Controller {
    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;

        view.getAccederButton().setOnAction(new AccederButtonHandler());
        view.getCancelarButton().setOnAction(new CancelarButtonHandler());
    }

    class AccederButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            String nombre = model.getNombre();
            String contrasena = model.getContra();
            boolean usarLdap = view.getLdapCheck().isSelected();

            if (usarLdap) {
                // Lógica de autenticación LDAP
                mostrarResultadoAutenticacion("Acceso permitido");
            } else {
                // Lógica de autenticación con archivo
                if (autenticarUsuario(nombre, contrasena)) {
                    mostrarResultadoAutenticacion("Acceso permitido");
                } else {
                    mostrarResultadoAutenticacion("Acceso denegado");
                    view.getContraText().clear();
                }
            }
        }

        private boolean autenticarUsuario(String nombre, String contrasena) {
            Path usersFile = Paths.get("src/main/resources/users.csv"); // Ajusta la ruta según tu configuración

            try {
                List<String> lines = Files.readAllLines(usersFile, StandardCharsets.UTF_8);

                for (String line : lines) {
                    String[] parts = line.split(",");
                    if (parts.length == 2 && parts[0].equals(nombre) && parts[1].equals(contrasena)) {
                        return true; // Usuario autenticado
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return false; // Acceso denegado o error
        }

        
        private void mostrarResultadoAutenticacion(String mensaje) {
            Alert alert = new Alert(AlertType.INFORMATION, mensaje, ButtonType.OK);
            alert.showAndWait();
        }
    }

    class CancelarButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            System.exit(0); // Cierra la aplicación
        }
    }
}


