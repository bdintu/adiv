package user;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class FXController {

    public Parent start() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
        Parent root = loader.load();
        return root;
    }
}