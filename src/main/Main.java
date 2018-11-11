package main;

import javafx.application.Application;

import serialize.Serialize;
import stage.Stage;

public class Main extends Application {

    @Override
    public void start(javafx.stage.Stage primaryStage) throws Exception {
        Stage.Stage(primaryStage);
        Stage.stage.changeStage("Login");
        Stage.stage.setTitle("ADIV");
        Stage.stage.show();
    }

    public static void main(String[] args) {
        Serialize.Serialize();
        Serialize.serialize.objRead();

        user.Controller.Controller();
        seeker.Controller.Controller();
        industry.Controller.Controller();
        company.Controller.Controller();
        skill.Controller.Controller();
        jobfunction.Controller.Controller();
        joblevel.Controller.Controller();
        job.Controller.Controller();

        launch(args);
        Serialize.serialize.objWrite();
    }
}