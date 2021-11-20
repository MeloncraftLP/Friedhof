import javax.swing.*;
import java.awt.event.*;

public class NeuesGrab extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel pnlButtons;
    private JPanel pnlMain;
    private JTextField textField1;
    private JLabel lblGrabname;
    private JLabel lblGrabnummer;
    private JLabel lblFriedhof;
    private JLabel lblBetreuerName;
    private JLabel lblBetruerEmail;
    private JLabel lblBetruerTelefon;
    private JLabel lblBetruerAdresse;
    private JCheckBox checkBetruetesGrabfeld;
    private JSpinner sGrabnummer;
    private JTextField tfFriedhof;
    private JTextField tfBetreuerName;
    private JTextField tfBetreuerEmail;
    private JTextField tfBetruerTelefon;
    private JTextField tfbetruerAdresse;

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
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        NeuesGrab dialog = new NeuesGrab();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
