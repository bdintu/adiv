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

public class Main extends Application {

    private static final String filepath="obj";
    private static ArrayList<user.Model> users;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Main serObj = new Main();
        user.Model userss = new user.Model(1, "j@mail.com","j","passwd");
        ArrayList<user.Model> users = new ArrayList<user.Model>();
        users.add(userss);
        serObj.serializeWrite(users);
        System.out.println("The Object  was succesfully written to a file");

        serializeRead();
        for(user.Model user : users) {
            System.out.println("username: " + user.getUsername());
        }
        launch(args);
    }

    public void serializeWrite(Object serObj) {

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
            users = (ArrayList<user.Model>)objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}