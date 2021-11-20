public class Kunde {

    //Variablen
    private String name;
    private String adresse;
    private String telefonnummer;
    private String email;

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
    public String getTelefonnummer() {
        return telefonnummer;
    }
    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //Konstruktor
    public Kunde(String name, String telefonnummer, String adresse){
        this.name = name;
        this.adresse = adresse;
        this.telefonnummer = telefonnummer;
    }
}