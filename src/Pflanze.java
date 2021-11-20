import java.util.ArrayList;
import java.util.List;

public class Pflanze {

    //Variablen
    private String name;
    private double preis;
    private static List<Pflanze> allePflanzen = new ArrayList<>();

    //Konstruktor
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
    public static List<Pflanze> getAllePflanzen() {
        return allePflanzen;
    }
    public static void addAllePflanzen(Pflanze p) {
        Pflanze.allePflanzen.add(p);
    }

    //To String
    @Override
    public String toString() {
        return name + "   ( "+preis+"€ )";
    }
}