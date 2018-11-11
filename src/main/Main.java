package main;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {

    private static final String dbpath = "adiv.db";
    private static HashMap<String, ArrayList> map;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent login = new user.FXController().start();

        Scene scene = new Scene(login);
        primaryStage.setTitle("ADIV");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

//        primaryStage.getScene().setRoot(login);
    }

    public static void main(String[] args) {

        objRead();
//        user.Controller.Controller();
//        seeker.Controller.Controller();
//        industry.Controller.Controller();
//        company.Controller.Controller();
//        skill.Controller.Controller();
//        jobfunction.Controller.Controller();
//        joblevel.Controller.Controller();
//        job.Controller.Controller();

        launch(args);

        objWrite();
    }

    public static void objWrite() {
        HashMap<String, ArrayList> map = new HashMap<String, ArrayList>();
        map.put("user", user.Controller.getModels());
        map.put("seeker", seeker.Controller.getModels());
        map.put("industry", industry.Controller.getModels());
        map.put("company", company.Controller.getModels());
        map.put("skill", skill.Controller.getModels());
        map.put("jobfunction", jobfunction.Controller.getModels());
        map.put("joblevel", joblevel.Controller.getModels());
        map.put("jobtype", jobtype.Controller.getModels());
        map.put("job", job.Controller.getModels());

        serializeWrite(map);
        System.out.println("The Object  was succesfully written to a file");
    }

    public static void objRead() {
        serializeRead();
        System.out.println("The Object  was succesfully read");

        user.Controller.setModels(map.get("user"));
        seeker.Controller.setModels( map.get("seeker"));
        industry.Controller.setModels(map.get("industry"));
        company.Controller.setModels(map.get("company"));
        skill.Controller.setModels(map.get("skill"));
        jobfunction.Controller.setModels(map.get("jobfunction"));
        joblevel.Controller.setModels(map.get("joblevel"));
        jobtype.Controller.setModels(map.get("jobtype"));
        job.Controller.setModels(map.get("job"));
    }

    public static void serializeWrite(Object serObj) {

        try {
            FileOutputStream fileOut = new FileOutputStream(dbpath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            fileOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void serializeRead() {

        try {
            FileInputStream fileIn = new FileInputStream(dbpath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            map = (HashMap<String, ArrayList>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}