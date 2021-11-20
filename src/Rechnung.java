import java.util.ArrayList;
import java.util.List;

public class Rechnung {

    //Variablen
    private double arbeitsaufwand;
    private static final double STUNDENLOHN = 10;
    private double gesamtPreis;
    private double gesamtPreisNetto;
    private Grab grab;
    private List<Integer> anzahlPflanzen;
    private List<Pflanze> pflanzen;
    private static List<Rechnung> alleRechnungen = new ArrayList<>();
    private static int anzahlRechnungen = -1;
    private static final double MEHRWERTSTEUER = 1.19;

    //Getter und Setter
    public double gesamtPreisBerechnen(){
        double p =arbeitsaufwand*STUNDENLOHN;
        for (int i = 0; i < anzahlPflanzen.size(); i++) {
            p+=anzahlPflanzen.get(i)*pflanzen.get(i).getPreis();
        }
        p=Math.round(p*100.0)/100.0;
        return p;
    }
    public double getGesamtPreis(){
        return gesamtPreis;
    }
    public Grab getGrab(){
        return grab;
    }
    public static List<Rechnung> getalleRechnungen() {
        return alleRechnungen;
    }
    public static void addalleRechnungen(Rechnung p) {
        Rechnung.alleRechnungen.add(p);
    }
    public List<Integer> getAnzahlPflanzen() {
        return anzahlPflanzen;
    }
    public List<Pflanze> getPflanzen() {
        return pflanzen;
    }
    public static int getAnzahlRechnungen() {
        return anzahlRechnungen;
    }
    public double getGesamtPreisNetto() {
        return gesamtPreisNetto;
    }

    //Konstruktor
    public Rechnung(double arbeitsaufwand, Grab grab, List<Integer> anzahlPflanzen, List<Pflanze> pflanzen) {
        this.arbeitsaufwand = arbeitsaufwand;
        this.grab = grab;
        this.anzahlPflanzen = anzahlPflanzen;
        this.pflanzen = pflanzen;
        gesamtPreis = gesamtPreisBerechnen();
        gesamtPreisNetto = Math.round((gesamtPreis * MEHRWERTSTEUER)*100.0)/100.0;;
        anzahlRechnungen++;
    }

    //To String
    @Override
    public String toString() {
        return "Rechnung{" +
                "arbeitsaufwand=" + arbeitsaufwand +
                ", gesamtPreis=" + gesamtPreis +
                ", grab=" + grab +
                ", anzahlPflanzen=" + anzahlPflanzen +
                ", pflanzen=" + pflanzen +
                '}';
    }
}