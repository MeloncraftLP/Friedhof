import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pflanze implements Serializable {

    //Variablen
    @Serial
    private static final long serialVersionUID = 3907194782642206926L;
    private String name;
    private String farbe;
    private int grosse;
    private double preis;
    private static List<Pflanze> allePflanzen = new ArrayList<>();

    //Konstruktor
    public Pflanze(String name, String farbe, int grosse, double preis) {
        this.name = name;
        this.preis = preis;
        this.farbe = farbe;
        this.grosse = grosse;
        allePflanzen.add(this);
    }
    public Pflanze(String name, int grosse, double preis) {
        this.name = name;
        this.grosse = grosse;
        this.preis = preis;
        allePflanzen.add(this);
    }
    public Pflanze(String name, double preis) {
        this.name = name;
        this.preis = preis;
        allePflanzen.add(this);
    }

    //Getter und Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPreis() {
        return preis;
    }
    public void setPreis(double preis) {
        this.preis = preis;
    }
    public String getFarbe() {
        return farbe;
    }
    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }
    public int getGrosse() {
        return grosse;
    }
    public void setGrosse(int grosse) {
        this.grosse = grosse;
    }
    public static List<Pflanze> getAllePflanzen() {
        return allePflanzen;
    }
    public static void addAllePflanzen(Pflanze p) {
        Pflanze.allePflanzen.add(p);
    }
    public static void setAllePflanzen(List<Pflanze> allePflanzen) {
        Pflanze.allePflanzen = allePflanzen;
    }

    //To String
    @Override
    public String toString() {
        return name + "   ( "+preis+"€ )";
    }
}
