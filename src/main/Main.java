package main;

import javafx.application.Application;

import serialize.Serialize;
import stage.Stage;
import user.Controller;

public class Main extends Application {

    @Override
    public void start(javafx.stage.Stage primaryStage) throws Exception {
        Stage.Stage(primaryStage);
        Stage.stage.changeStage("Login");
        Stage.stage.setTitle("ADIV");
        Stage.stage.show();
    }

    public static void main(String[] args) {

        user.Controller.Controller();
        location.Controller.Controller();
        seeker.Controller.Controller();
        industry.Controller.Controller();
        company.Controller.Controller();
        skill.Controller.Controller();
        jobfunction.Controller.Controller();
        joblevel.Controller.Controller();
        jobtype.Controller.Controller();
        job.Controller.Controller();

        Serialize.Serialize();
        Serialize.serialize.objRead();

//        user.Test.init();
//        user.Test.print();
//
//        seeker.Test.init();
//        seeker.Test.print();
//
//        company.Test.init();
//        company.Test.print();
//
//        job.Test.init();
//        job.Test.print();

        launch(args);
        Serialize.serialize.objWrite();
    }
}