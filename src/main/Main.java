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

    private static final String filepath="adiv.db";
    private static HashMap<String, ArrayList> map;
    public static ArrayList<user.Model> users;
    public static ArrayList<user.Model> skills;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 550));
        primaryStage.show();
    }

    public static void main(String[] args) {

        objRead();
        for(user.Model u: users)
            System.out.println(u);

        launch(args);

        //objWrite();
    }

    public static void objWrite() {
        HashMap<String, ArrayList> map = new HashMap<String, ArrayList>();
        map.put("user", users);
        map.put("skill", skills);
        serializeWrite(map);
        System.out.println("The Object  was succesfully written to a file");
    }

    public static void objRead() {
        serializeRead();
        users = map.get("user");
        skills = map.get("skill");
    }

    public static void serializeWrite(Object serObj) {

        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
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
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            map = (HashMap<String, ArrayList>)objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}