import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Einstellungen {

    private final File graber;
    private final File pflanzen;
    private FileOutputStream graberFOS;
    private FileOutputStream pflanzenFOS;
    private ObjectOutputStream graberOOS;
    private ObjectOutputStream pflanzenOOS;
    private FileInputStream graberFIS;
    private FileInputStream pflanzenFIS;
    private ObjectInputStream graberOIS;
    private ObjectInputStream pflanzenOIS;
    private final GUI gui;

    //Konstruktor
    public Einstellungen(GUI g){
        gui = g;
        graber = new File("GraeberConf.grb");
        pflanzen = new File("PflanzenConf.plz");
    }

    //Funktionen
    public void alleGraberSpeichern(List<Grab> l){
        try {
                graberFOS = new FileOutputStream(graber);
                graberOOS = new ObjectOutputStream(graberFOS);
                graberOOS.writeObject(l);
        } catch (Exception e) {
            e.printStackTrace();
            gui.showError("Graeber konnten nicht gepseichert werden.");
        }
    }
    public List<Grab> alleGraberLaden() {
        List<Grab> l = new ArrayList<>();
        try {
            graberFIS = new FileInputStream(graber);
            graberOIS = new ObjectInputStream(graberFIS);
            l = (List<Grab>) graberOIS.readObject();
        } catch (Exception e){
            e.printStackTrace();
            gui.showError("Graber konnten nicht geladen werden.");
        }
        return l;
    }
    public void allePflanzenSpeichern(List<Pflanze> l){
        try {
            pflanzenFOS = new FileOutputStream(pflanzen);
            pflanzenOOS = new ObjectOutputStream(pflanzenFOS);
            pflanzenOOS.writeObject(l);
        } catch (Exception e) {
            e.printStackTrace();
            gui.showError("Pflanzen konnten nicht gepseichert werden.");
        }
    }
    public List<Pflanze> allePflanzenLaden() {
        List<Pflanze> l = new ArrayList<>();
        try {
            pflanzenFIS = new FileInputStream(pflanzen);
            pflanzenOIS = new ObjectInputStream(pflanzenFIS);
            l = (List<Pflanze>) pflanzenOIS.readObject();
        } catch (Exception e){
            e.printStackTrace();
            gui.showError("Pflanzen konnten nicht geladen werden.");
        }
        return l;
    }

    public static void main(String[] args) {

    }
}
