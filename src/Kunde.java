import java.io.Serial;
import java.io.Serializable;

public class Kunde implements Serializable {

    //Variablen
    @Serial
    private static final long serialVersionUID = 6755692808689127339L;
    private long kundenNr;
    private String name;
    private String adresse;
    private String plzOrt;

    //Getter und Setter
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPlzOrt() {
        return plzOrt;
    }
    public void setPlzOrt(String plzOrt) {
        this.plzOrt = plzOrt;
    }
    public long getKundenNr() {
        return kundenNr;
    }

    //Konstruktor
    public Kunde(String name, String adresse, String plzOrt) {
        this.name = name;
        this.adresse = adresse;
        this.plzOrt = plzOrt;
        kundenNr = -1;
    }
    public Kunde(String name, String adresse, String plzOrt, int kundenNr){
        this.name = name;
        this.adresse = adresse;
        this.plzOrt = plzOrt;
        this.kundenNr = kundenNr;
    }
}
