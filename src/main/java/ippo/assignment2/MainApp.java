package ippo.assignment2;

import javafx.application.Application;
        import javafx.stage.Stage;
        import java.io.IOException;
        import java.util.logging.Level;
        import java.util.logging.Logger;

        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.scene.layout.AnchorPane;

public class MainApp extends Application {

    public void start(Stage stage) {

        try {

            String viewerFxml = "/GUI.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource(viewerFxml));
            AnchorPane page = (AnchorPane) fxmlLoader.load();
            Scene scene = new Scene(page);
            stage.setScene(scene);

            World world = new World();
            world.initialize();

            WorldController controller = (WorldController) fxmlLoader.getController();
            controller.initialize(world);

            stage.show();


        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }

    public static void main(String args[]) {
        launch(args);
        System.exit(0);
    }
}
