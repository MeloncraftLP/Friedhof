import java.util.ArrayList;
import java.util.List;

public class Rechnung {

    //Variablen
    private double arbeitsaufwand;
    private double arbeitsPreis;
    private double erdeMenge;
    private double erdeBerPreis;
    private double sonstigesPreis;
    private double gesamtPreis;
    private double gesamtPreisBrutto;
    private double mwstPreis;
    private long belegNummer;
    private String sonstiges;
    private final Grab grab;
    private List<Integer> anzahlPflanzen;
    private List<Pflanze> pflanzen;
    private static final List<Rechnung> alleRechnungen = new ArrayList<>();
    private static int anzahlRechnungen = -1; //-1 damit in Array die Indexe stimmen (siehe GUI)
    public static final double MEHRWERTSTEUER = 1.19;
    public static final double STUNDENLOHN = 48.07;
    public static final double ERDEPREIS = 8.4;

    //Funktionen
    private void gesamtPreisBerechnen(double arbeitsaufwand, double erdeMenge, double preis, List<Integer> anzahlPflanzen, List<Pflanze> pflanzen){
        double p;
        List<Double> k = new ArrayList<>();
        p = arbeitBerechnen(arbeitsaufwand) + erdeBerechnen(erdeMenge) + sonstigesBerechnen(preis);
        k = pflanzenPreisBerechnen(anzahlPflanzen, pflanzen);
        for (int i = 0; i < k.size(); i++) {
            p += k.get(i);
        }
        p = Math.round((p)*100.0)/100.0;
        gesamtPreis = p;
    }
    private void gesamtPreisBruttoBerechnen(double gesamtPreis){
        gesamtPreisBrutto = Math.round((gesamtPreis * MEHRWERTSTEUER)*100.0)/100.0;
    }
    private void mwstBerechnen(){
        double p = gesamtPreisBrutto-gesamtPreis;
        p = Math.round((p)*100.0)/100.0;
        mwstPreis = p;
    }
    public List<Double> pflanzenPreisBerechnen(List<Integer> anzahlPflanzen, List<Pflanze> pflanzen){
        List<Double> p = new ArrayList<>();
        for (int i = 0; i < pflanzen.size(); i++) {
            p.add(anzahlPflanzen.get(i)*pflanzen.get(i).getPreis());
        }
        return p;
    }
    private double arbeitBerechnen(double arbeitsaufwand){
        double p;
        p = arbeitsaufwand * STUNDENLOHN;
        p = Math.round((p)*100.0)/100.0;
        arbeitsPreis = p;
        return p;
    }
    private double erdeBerechnen(double erdeMenge){
        double p;
        p = erdeMenge * ERDEPREIS;
        p = Math.round((p)*100.0)/100.0;
        erdeBerPreis = p;
        return p;
    }
    private double sonstigesBerechnen(double preis){
        sonstigesPreis = Math.round(preis * 100.0d)/100.0d;
        return  sonstigesPreis;
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
    public long getBelegNummer() {
        return belegNummer;
    }
    public String getSonstiges() {
        return sonstiges;
    }
    public double getSonstigesPreis(){
        return sonstigesPreis;
    }
    public double getErdeMenge(){
        return erdeMenge;
    }
    public double getErdeBerPreis(){
        return erdeBerPreis;
    }
    public double getArbeitsaufwand(){
        return arbeitsaufwand;
    }
    public double getArbeitsPreis(){
        return arbeitsPreis;
    }
    public double getMwstPreis(){
        return mwstPreis;
    }

    //Konstruktor
    public Rechnung(double arbeitsAufwand, double erdeMenge, double sonstigesPreis, String sonstiges, Grab grab, List<Integer> anzahlPflanzen, List<Pflanze> pflanzen) {
        this.grab = grab;
        this.anzahlPflanzen = anzahlPflanzen;
        this.pflanzen = pflanzen;
        this.sonstiges = sonstiges;
        this.sonstigesPreis = sonstigesPreis;
        this.erdeMenge = erdeMenge;
        this.arbeitsaufwand = arbeitsAufwand;
        arbeitBerechnen(arbeitsAufwand);
        erdeBerechnen(erdeMenge);
        sonstigesBerechnen(sonstigesPreis);
        gesamtPreisBerechnen(arbeitsAufwand, erdeMenge, sonstigesPreis, anzahlPflanzen, pflanzen);
        gesamtPreisBruttoBerechnen(gesamtPreis);
        mwstBerechnen();
        anzahlRechnungen++;
        belegNummer = 11000000 + anzahlRechnungen;
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
