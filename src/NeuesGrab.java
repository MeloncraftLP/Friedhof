import javax.swing.*;
import java.awt.event.*;

public class NeuesGrab extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel pnlButtons;
    private JPanel pnlMain;
    private JTextField tfGrabname;
    private JLabel lblGrabname;
    private JLabel lblGrabnummer;
    private JLabel lblFriedhof;
    private JLabel lblBetreuerName;
    private JLabel lblBetruerAdresse;
    private JTextField tfBetreuerName;
    private JTextField tfbetruerAdresse;
    private JSpinner sGrabnummer;
    private JLabel lblKundenNr;
    private JSpinner sKundenNr;
    private JComboBox cbFriedhof;
    private JLabel lblOrtPlz;
    private JTextField tfPlzOrt;
    private JLabel lblFeldname;
    private JTextField tfFeldname;
    private JLabel lblGrabart;
    private JComboBox cbGrabart;

    public NeuesGrab() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {

        String grabArt, grabFeld;
        int grabNummer, kundenNummer;

            grabArt = cbGrabart.getSelectedItem().toString();
            grabFeld = tfFeldname.getText();
            grabNummer = Integer.parseInt(sGrabnummer.getValue().toString());
            kundenNummer = Integer.parseInt(sGrabnummer.getValue().toString());

        if(grabArt != "keine" && grabFeld == "" && grabNummer == 0){
            new Grab(tfGrabname.getText(), cbFriedhof.getSelectedItem().toString(), grabArt, tfBetreuerName.getText(), tfbetruerAdresse.getText(), tfPlzOrt.getText());
            showInfo("Es wurde ein neues Grab erstellt.");
        }
        else if(grabArt != "keine" && grabFeld != "" && grabNummer != 0 && kundenNummer == 0){
            new Grab(tfGrabname.getText(), cbFriedhof.getSelectedItem().toString(), grabArt, grabNummer, grabFeld, tfBetreuerName.getText(), tfbetruerAdresse.getText(), tfPlzOrt.getText());
            showInfo("Es wurde ein neues Grab erstellt.");
        }
        else if(grabArt != "keine" && grabFeld != "" && grabNummer != 0 && kundenNummer != 0){
            new Grab(tfGrabname.getText(), cbFriedhof.getSelectedItem().toString(), grabNummer, grabFeld, grabArt, tfBetreuerName.getText(), tfbetruerAdresse.getText(), tfPlzOrt.getText(), kundenNummer);
            showInfo("Es wurde ein neues Grab erstellt.");
        }
        else if(grabArt == "keine" && grabFeld == "" && grabNummer == 0 && kundenNummer == 0){
            new Grab(tfGrabname.getText(), cbFriedhof.getSelectedItem().toString(), tfBetreuerName.getText(), tfbetruerAdresse.getText(), tfPlzOrt.getText());
            showInfo("Es wurde ein neues Grab erstellt.");
        }
        else{
            showWarning("Es konnte kein neues Grab erstellt werden.");
        }

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    private void showInfo(String message) {
        JOptionPane.showMessageDialog(this,
                message);
    }
    private void showWarning(String message){
        JOptionPane.showMessageDialog(this,
                message,
                "Warning",
                JOptionPane.WARNING_MESSAGE);
    }


    public static void main(String[] args) {
        NeuesGrab dialog = new NeuesGrab();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
