import java.util.ArrayList;
import java.util.List;

public class Rechnung {

    //Variablen
    private final double arbeitsaufwand;
    private static final double STUNDENLOHN = 48.07;
    private static final double ERDEPREIS = 8.4;
    private final double gesamtPreis;
    private final double gesamtPreisBrutto;
    private String sonstiges;
    private final Grab grab;
    private final List<Integer> anzahlPflanzen;
    private final List<Pflanze> pflanzen;
    private static final List<Rechnung> alleRechnungen = new ArrayList<>();
    private static int anzahlRechnungen = -1;
    private static final double MEHRWERTSTEUER = 1.19;

    //Funktionen
    public double gesamtPreisBerechnen(double arbeitsaufwand, double erdeMenge, double preis, List<Integer> anzahlPflanzen, List<Pflanze> pflanzen){
        double p;
        List<Double> k = new ArrayList<>();
        p = arbeitBerechnen(arbeitsaufwand) + erdeBerechnen(erdeMenge) + sonstigesBerechnen(preis);
        k = pflanzenPreisBerechnen(anzahlPflanzen, pflanzen);
        for (int i = 0; i < k.size(); i++) {
            p += k.get(i);
        }
        return p;
    }
    public List<Double> pflanzenPreisBerechnen(List<Integer> anzahlPflanzen, List<Pflanze> pflanzen){
        List<Double> p = new ArrayList<>();
        for (int i = 0; i < pflanzen.size(); i++) {
            p.add(anzahlPflanzen.get(i)*pflanzen.get(i).getPreis());
        }
        return p;
    }
    public double arbeitBerechnen(double arbeitsaufwand){
        double p;
        p = arbeitsaufwand * STUNDENLOHN;
        p = Math.round((p)*100.0)/100.0;
        return p;
    }
    public double erdeBerechnen(double erdeMenge){
        double p;
        p = erdeMenge * ERDEPREIS;
        p = Math.round((p)*100.0)/100.0;
        return p;
    }
    public double sonstigesBerechnen(double preis){
        return preis;
    }
    //Getter und Setter
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
    public double getGesamtPreisBrutto() {
        return gesamtPreisBrutto;
    }

    //Konstruktor
    public Rechnung(double arbeitsaufwand, double erdeMenge, double sonstigesPreis, Grab grab, List<Integer> anzahlPflanzen, List<Pflanze> pflanzen) {
        this.arbeitsaufwand = arbeitsaufwand;
        this.grab = grab;
        this.anzahlPflanzen = anzahlPflanzen;
        this.pflanzen = pflanzen;
        gesamtPreis = gesamtPreisBerechnen(arbeitsaufwand, erdeMenge, sonstigesPreis, anzahlPflanzen, pflanzen);
        gesamtPreisBrutto = Math.round((gesamtPreis * MEHRWERTSTEUER)*100.0)/100.0;
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
