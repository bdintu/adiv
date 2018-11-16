package stage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Stage {

    public static Stage stage;

    private javafx.stage.Stage primaryStage;

    public static void Stage(javafx.stage.Stage primaryStage) {
        stage = new Stage();
        stage.setStage(primaryStage);
        stage.getStage().setResizable(false);
    }

    public void changeStage(String name) throws  Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/"+name+".fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

    public void setTitle(String name) {
        primaryStage.setTitle("ADIV: " + name);
    }

    public void show() {
        primaryStage.show();
    }

    public javafx.stage.Stage getStage() {
        return primaryStage;
    }

    public void setStage(javafx.stage.Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
