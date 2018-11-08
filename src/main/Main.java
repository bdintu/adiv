package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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

    public static final int width = 1280;
    public static final int height = 720;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ADIV");
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
    }

    public static void main(String[] args) {

        objRead();
        user.Controller.Controller();

        launch(args);

        objWrite();
    }

    public static void objWrite() {
        HashMap<String, ArrayList> map = new HashMap<String, ArrayList>();
        map.put("user", user.Controller.models);
        map.put("seeker", seeker.Controller.models);
        map.put("company", company.Controller.models);
        map.put("job", job.Controller.models);
        map.put("skill", skill.Controller.models);
        serializeWrite(map);
        System.out.println("The Object  was succesfully written to a file");
    }

    public static void objRead() {
        serializeRead();
        System.out.println("The Object  was succesfully read");
        user.Controller.models = map.get("user");
        seeker.Controller.models = map.get("seeker");
        company.Controller.models = map.get("company");
        job.Controller.models = map.get("jobs");
        skill.Controller.models = map.get("skill");
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