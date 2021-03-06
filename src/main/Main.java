package main;

import javafx.application.Application;

import serialize.Serialize;
import stage.Stage;

public class Main extends Application {

    @Override
    public void start(javafx.stage.Stage primaryStage) throws Exception {
        Stage.Stage(primaryStage);
        Stage.stage.changeStage("Login");
        Stage.stage.setTitle("Login");
        Stage.stage.show();
    }

    public static void main(String[] args) {

        Serialize.Serialize();
        Serialize.serialize.objRead();

//        user.Test.init();
//        user.Test.print();
//
//        company.Test.init();
//        company.Test.print();
//
//        seeker.Test.init();
//        seeker.Test.print();
//
//        job.Test.init();
//        job.Test.print();

        launch(args);
        Serialize.serialize.objWrite();
    }
}