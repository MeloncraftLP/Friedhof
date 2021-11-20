import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Grab extends Kunde implements Serializable {


    //Variablen
    @Serial
    private static final long serialVersionUID = -262287073964400689L;
    private String grabName;
    private String friedhof;
    private String feldName;
    private String grabArt;
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
    public String getFeldName() {
        return feldName;
    }
    public void setFeldName(String feldName) {
        this.feldName = feldName;
    }
    public String getGrabArt() {
        return grabArt;
    }
    public void setGrabArt(String grabArt) {
        this.grabArt = grabArt;
    }

    //Konstruktor
    public Grab(String grabName, String friedhof, int grabNummer, String feldName, String grabArt, boolean betreutesGrabfeld, String name, String adresse, String plzOrt) {
        super(name, adresse, plzOrt);
        this.grabName = grabName;
        this.friedhof = friedhof;
        this.grabNummer = grabNummer;
        this.betreutesGrabfeld = betreutesGrabfeld;
        this.feldName = feldName;
        this.grabArt = grabArt;
        alleGraber.add(this);
    }






















    //TODO Konstruktoren bauen



    @Override
    public String toString() {
        return grabName+" | "+super.getName();
    }
}
