import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JFrame{
    private JPanel panel1;
    private JPanel pnlPflanzen;
    private JComboBox cbNameP1;
    private JSpinner sAnzP1;
    private JLabel lblP1;
    private JLabel lblP2;
    private JLabel lblP3;
    private JLabel lblP4;
    private JLabel lblP5;
    private JLabel lblP6;
    private JLabel lblP7;
    private JComboBox cbNameP2;
    private JComboBox cbNameP3;
    private JComboBox cbNameP4;
    private JComboBox cbNameP5;
    private JComboBox cbNameP6;
    private JComboBox cbNameP7;
    private JSpinner sAnzP2;
    private JSpinner sAnzP3;
    private JSpinner sAnzP4;
    private JSpinner sAnzP5;
    private JSpinner sAnzP6;
    private JSpinner sAnzP7;
    private JLabel lblArbeitsaufwand;
    private JSpinner sArbeitsaufwand;
    private JPanel pnlSettings;
    private JLabel lblGrabname;
    private JComboBox cbGrabname;
    private JPanel pnlSpeichern;
    private JButton btnSpeichernExcel;
    private JButton btnSpeichernRechnung;
    private JLabel lblRechnungNetto;
    private JLabel lblRechnungBrutto;
    private JLabel lblNetto;
    private JLabel lblBrutto;
    private JButton btnBerechnen;
    private JButton btnEinstellungen;
    private JButton btnNeuerKunde;
    private JButton btnNeuePflanze;
    private JLabel lblSonstiges;
    private JTextField tfSonstiges;
    private JSpinner sSonstiges;
    private JLabel lblErde;
    private JSpinner sErdeMenge;
    private JLabel lblPreisP1;
    private JLabel lblPreisP2;
    private JLabel lblPreisP3;
    private JLabel lblPreisP4;
    private JLabel lblPreisP5;
    private JLabel lblPreisP6;
    private JLabel lblPreisP7;
    private JLabel lblPreisErde;
    private JLabel lblPreisSonstiges;
    private JLabel lblPreisArbeit;
    //TODO JComboBox mit Suchfunktion einrichten
    private Einstellungen einstellungen;
    private List<Pflanze> aP = new ArrayList<Pflanze>();
    private List<Grab> aG = new ArrayList<Grab>();

    private void init(){
        objekteLaden();

        //Konfigurieren der Spinner
        sArbeitsaufwand.setModel(new SpinnerNumberModel(0,0,10000,0.25));
        sErdeMenge.setModel(new SpinnerNumberModel(0,0,10000,0.001));
        sSonstiges.setModel(new SpinnerNumberModel(0,0,10000,0.01));
        sAnzP1.setModel(new SpinnerNumberModel(0,0,1000,1));
        sAnzP2.setModel(new SpinnerNumberModel(0,0,1000,1));
        sAnzP3.setModel(new SpinnerNumberModel(0,0,1000,1));
        sAnzP4.setModel(new SpinnerNumberModel(0,0,1000,1));
        sAnzP5.setModel(new SpinnerNumberModel(0,0,1000,1));
        sAnzP6.setModel(new SpinnerNumberModel(0,0,1000,1));
        sAnzP7.setModel(new SpinnerNumberModel(0,0,1000,1));

        //alle Pflanzen und Graeber aktualisieren
        aP = Pflanze.getAllePflanzen();
        aG = Grab.getAlleGraber();

        //Pflanzen Combo-Boxen initialisieren
        for (int i = 0; i < aP.size(); i++) {
            cbNameP1.addItem(aP.get(i));
            cbNameP2.addItem(aP.get(i));
            cbNameP3.addItem(aP.get(i));
            cbNameP4.addItem(aP.get(i));
            cbNameP5.addItem(aP.get(i));
            cbNameP6.addItem(aP.get(i));
            cbNameP7.addItem(aP.get(i));
        }
        //Graber initialisieren
        for (int i = 0; i < aG.size(); i++) {
            cbGrabname.addItem(aG.get(i));
        }
    }

    //Objekte aus der Datei laden und erstellen
    private void objekteLaden() {
        einstellungen = new Einstellungen(this);
        Pflanze.setAllePflanzen(einstellungen.allePflanzenLaden());
        Grab.setAlleGraber(einstellungen.alleGraberLaden());
    }

    //Daten einlesen
    private List<Pflanze> pflanzenEinlesen(){
        List<Pflanze> l = new ArrayList<>();

        l.add(aP.get(cbNameP1.getSelectedIndex()));
        l.add(aP.get(cbNameP2.getSelectedIndex()));
        l.add(aP.get(cbNameP3.getSelectedIndex()));
        l.add(aP.get(cbNameP4.getSelectedIndex()));
        l.add(aP.get(cbNameP5.getSelectedIndex()));
        l.add(aP.get(cbNameP6.getSelectedIndex()));
        l.add(aP.get(cbNameP7.getSelectedIndex()));

        return l;
    }
    private List<Integer> anzahlEinlesen(){
        List<Integer> l = new ArrayList<>();

        l.add(Integer.parseInt(sAnzP1.getValue().toString()));
        l.add(Integer.parseInt(sAnzP2.getValue().toString()));
        l.add(Integer.parseInt(sAnzP3.getValue().toString()));
        l.add(Integer.parseInt(sAnzP4.getValue().toString()));
        l.add(Integer.parseInt(sAnzP5.getValue().toString()));
        l.add(Integer.parseInt(sAnzP6.getValue().toString()));
        l.add(Integer.parseInt(sAnzP7.getValue().toString()));

        return l;
    }

    //Errors anzeigen
    public void showError(String message){
        JOptionPane.showMessageDialog(this,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    //Konstruktor
    public GUI(){

        //Config
        setTitle("Friedhofs-Rechnungs-Software v0.2");
        setSize(800,450); //800, 450
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                einstellungen.alleGraberSpeichern(Grab.getAlleGraber());
                einstellungen.allePflanzenSpeichern(Pflanze.getAllePflanzen());
                System.exit(0); //schließen und VM beenden
            }
        });

        //Init
        init();

        //Action Listener
        btnBerechnen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //neue Rechnung erstellen und Preis berechnen
                    Rechnung.addalleRechnungen(new Rechnung(Double.parseDouble(sArbeitsaufwand.getValue().toString()),
                            Double.parseDouble(sErdeMenge.getValue().toString()),Double.parseDouble(sSonstiges.getValue().toString()),
                            aG.get(cbGrabname.getSelectedIndex()), anzahlEinlesen(), pflanzenEinlesen()));

                    //Labels mit einzelnen Preisen setzen
                    lblPreisArbeit.setText(Rechnung.getalleRechnungen().get(Rechnung.getAnzahlRechnungen()).arbeitBerechnen(Double.parseDouble(sArbeitsaufwand.getValue().toString())) + " €");
                    lblPreisErde.setText(Rechnung.getalleRechnungen().get(Rechnung.getAnzahlRechnungen()).erdeBerechnen(Double.parseDouble(sErdeMenge.getValue().toString())) + " €");
                    lblPreisSonstiges.setText(Rechnung.getalleRechnungen().get(Rechnung.getAnzahlRechnungen()).sonstigesBerechnen(Double.parseDouble(sSonstiges.getValue().toString())) + " €");
                    lblPreisP1.setText(Rechnung.getalleRechnungen().get(Rechnung.getAnzahlRechnungen()).pflanzenPreisBerechnen(anzahlEinlesen(), pflanzenEinlesen()).get(0) + " €");
                    lblPreisP2.setText(Rechnung.getalleRechnungen().get(Rechnung.getAnzahlRechnungen()).pflanzenPreisBerechnen(anzahlEinlesen(), pflanzenEinlesen()).get(1) + " €");
                    lblPreisP3.setText(Rechnung.getalleRechnungen().get(Rechnung.getAnzahlRechnungen()).pflanzenPreisBerechnen(anzahlEinlesen(), pflanzenEinlesen()).get(2) + " €");
                    lblPreisP4.setText(Rechnung.getalleRechnungen().get(Rechnung.getAnzahlRechnungen()).pflanzenPreisBerechnen(anzahlEinlesen(), pflanzenEinlesen()).get(3) + " €");
                    lblPreisP5.setText(Rechnung.getalleRechnungen().get(Rechnung.getAnzahlRechnungen()).pflanzenPreisBerechnen(anzahlEinlesen(), pflanzenEinlesen()).get(4) + " €");
                    lblPreisP6.setText(Rechnung.getalleRechnungen().get(Rechnung.getAnzahlRechnungen()).pflanzenPreisBerechnen(anzahlEinlesen(), pflanzenEinlesen()).get(5) + " €");
                    lblPreisP7.setText(Rechnung.getalleRechnungen().get(Rechnung.getAnzahlRechnungen()).pflanzenPreisBerechnen(anzahlEinlesen(), pflanzenEinlesen()).get(6) + " €");

                }catch (Exception x){
                    x.printStackTrace();
                    showError("Die Eingabe enthält keine Werte.");
                }
                lblNetto.setText(Rechnung.getalleRechnungen().get(Rechnung.getAnzahlRechnungen()).getGesamtPreis() + " €");
                lblBrutto.setText(Rechnung.getalleRechnungen().get(Rechnung.getAnzahlRechnungen()).getGesamtPreisBrutto() + " €");
            }
        });

        setContentPane(panel1);
        setVisible(true);
    }

    public static void main(String[] args) {

        GUI g = new GUI();

    }
}
