import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Grab extends Kunde implements Serializable {

    //Variablen
    private String grabName;
    private String friedhof;
    private int grabNummer;
    private boolean betreutesGrabfeld;
    private static List<Grab> alleGraber = new ArrayList<>();

    //Getter und Setter
    public String getGrabName() {
        return grabName;
    }
    public void setGrabName(String grabName) {
        this.grabName = grabName;
    }
    public String getFriedhof() {
        return friedhof;
    }
    public void setFriedhof(String friedhof) {
        this.friedhof = friedhof;
    }
    public int getGrabNummer() {
        return grabNummer;
    }
    public void setGrabNummer(int grabNummer) {
        this.grabNummer = grabNummer;
    }
    public boolean isBetreutesGrabfeld() {
        return betreutesGrabfeld;
    }
    public void setBetreutesGrabfeld(boolean betreutesGrabfeld) {
        this.betreutesGrabfeld = betreutesGrabfeld;
    }
    public static List<Grab> getAlleGraber() {
        return alleGraber;
    }
    public static void addAlleGraber(Grab g) {
        Grab.alleGraber.add(g);
    }
    public static void setAlleGraber(List<Grab> alleGraber) {
        Grab.alleGraber = alleGraber;
    }

    //Konstruktor
    public Grab(String grabName, String friedhof, int grabNummer, boolean betreutesGrabfeld, String name, String telefonnummer, String adresse) {
        super(name, telefonnummer, adresse);
        this.grabName = grabName;
        this.friedhof = friedhof;
        this.grabNummer = grabNummer;
        this.betreutesGrabfeld = betreutesGrabfeld;
        alleGraber.add(this);
    }

    @Override
    public String toString() {
        return grabName+" | "+super.getName();
    }
}