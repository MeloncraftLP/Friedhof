import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JLabel lblRechnungBrutto;
    private JLabel lblRechnungNetto;
    private JLabel lblBrutto;
    private JLabel lblNetto;
    private JButton btnBerechnen;
    private JButton btnEinstellungen;
    private JButton btnNeuerKunde;
    private JButton btnNeuePflanze;


    List<Pflanze> aP = new ArrayList<Pflanze>();
    List<Grab> aG = new ArrayList<Grab>();

    private void init(){
        //Konfigurieren der Spinner
        sArbeitsaufwand.setModel(new SpinnerNumberModel(0,0,1000,0.25));
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


    //Konstruktor
    public GUI(){

        //Config
        setTitle("Friedhofs-Rechnungs-Software v0.1");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(800,450);

        //Init
        init();

        //Action Listener
        btnBerechnen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rechnung.addalleRechnungen(new Rechnung(Double.parseDouble(sArbeitsaufwand.getValue().toString()), aG.get(cbGrabname.getSelectedIndex()),
                        anzahlEinlesen(), pflanzenEinlesen()));
                lblBrutto.setText(String.valueOf(Rechnung.getalleRechnungen().get(Rechnung.getAnzahlRechnungen()).getGesamtPreis()) + " €");
                lblNetto.setText(String.valueOf(Rechnung.getalleRechnungen().get(Rechnung.getAnzahlRechnungen()).getGesamtPreisNetto()) + " €");
            }
        });

        setContentPane(panel1);
        setVisible(true);
    }

    public static void main(String[] args) {
       
        GUI g = new GUI();
    }
}