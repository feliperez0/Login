package dad.login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Model model = new Model();
        Controller controller = new Controller(model);

        Scene scene = new Scene(controller.getView(), 400, 300);

        primaryStage.setTitle("Login.fxml");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

