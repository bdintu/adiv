package serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Serialize {

    public static Serialize serialize;

    private final String dbpath = "adiv.db";
    private HashMap<String, ArrayList> map;

    public static void Serialize() {
        serialize = new Serialize();
    }

    public void objWrite() {
        HashMap<String, ArrayList> map = new HashMap<String, ArrayList>();
        map.put("user", user.Controller.controller.getModels());
//        map.put("location", location.Controller.getModels());
//        map.put("seeker", seeker.Controller.getModels());
//        map.put("industry", industry.Controller.getModels());
//        map.put("company", company.Controller.getModels());
//        map.put("skill", skill.Controller.getModels());
//        map.put("jobfunction", jobfunction.Controller.getModels());
//        map.put("joblevel", joblevel.Controller.getModels());
//        map.put("jobtype", jobtype.Controller.getModels());
//        map.put("job", job.Controller.getModels());

        serializeWrite(map);
        System.out.println("The Object  was succesfully written to a file");
    }

    public void objRead() {
        serializeRead();
        System.out.println("The Object  was succesfully read");

        user.Controller.controller.setModels(map.get("user"));
//        location.Controller.setModels(map.get("location"));
//        seeker.Controller.setModels( map.get("seeker"));
//        industry.Controller.setModels(map.get("industry"));
//        company.Controller.setModels(map.get("company"));
//        skill.Controller.setModels(map.get("skill"));
//        jobfunction.Controller.setModels(map.get("jobfunction"));
//        joblevel.Controller.setModels(map.get("joblevel"));
//        jobtype.Controller.setModels(map.get("jobtype"));
//        job.Controller.setModels(map.get("job"));
    }

    public void serializeWrite(Object serObj) {

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

    public void serializeRead() {

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
