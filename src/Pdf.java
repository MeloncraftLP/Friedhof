import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Pdf {

    //Variablen
    private Rechnung r;
    private GUI g;
    private final String path;
    private final String pathFolder;
    private PDDocument document;
    private PDPage page;
    private PDPageContentStream pageCS;

    private void addText(String text,float fontSize, float x, float y){
        try {
            pageCS.beginText();
            pageCS.setFont(PDType1Font.COURIER, fontSize);
            pageCS.moveTextPositionByAmount(x, y);
            pageCS.showText(text);
            pageCS.endText();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void addTextBold(String text,float fontSize, float x, float y){
        try {
            pageCS.beginText();
            pageCS.setFont(PDType1Font.COURIER_BOLD, fontSize);
            pageCS.moveTextPositionByAmount(x, y);
            pageCS.showText(text);
            pageCS.endText();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void rechnungSpeichern() {
        try{
            //Ordner erstellen
            File dir = new File(pathFolder);
            if(!dir.exists()){
                dir.mkdirs();
            }
            //PDF Datei erstellen
            File pdf = new File(path);
            if(!pdf.exists()) {
                pdf.createNewFile();
            }

            //PDF mit Text speichern
            document.save(path);
            document.close();
            g.showMessage("Eine PDF-Rechnung wurde erstellt.");

        }catch (Exception e){
            e.printStackTrace();
            g.showError("PDF konnte nicht gespeichert werden.");
        }

    }

    //TODO Methode bauen fuer "Schmierzettel"
    //TODO wenn man ein Grab ohne alle Parameter erstellt soll keine Rechnung erstellt werden koennen bzw nicht gedruckt werden

    //Rechnung schreiben
    public void pdfSchreiben(Rechnung r){
        try{
            document = new PDDocument();
            page = new PDPage();
            document.addPage(page);
            pageCS = new PDPageContentStream(document, page);

            //TODO Datum muss rein

            //Variablen
            addText(String.valueOf(r.getBelegNummer()), 11, 175, 670);
            addText(r.getGrab().getName(), 11, 75, 600);
            addText(r.getGrab().getAdresse(), 11, 75, 585);
            addText(r.getGrab().getPlzOrt(), 11, 75, 570);
            addText(r.getGrab().getFriedhof(), 11, 325, 465);
            addText(r.getGrab().getGrabName(), 11, 325, 450);
            addText(String.valueOf(r.getGrab().getGrabNummer()), 11, 325, 435);
            addText(r.getGrab().getFeldName(), 11, 325, 420);
            addText(String.valueOf(r.getGrab().getKundenNr()), 11, 325, 390);
            addText(r.getGrab().getGrabArt(), 11, 325, 405);

            for(int i = 0; i < r.getPflanzen().size(); i++){
                if(r.getAnzahlPflanzen().get(i)!=0 && !r.getPflanzen().get(i).getName().equals("none")){
                    //n fuer Name und p fuer preis
                    addText(r.getPflanzen().get(i).toPDF('n'), 11, 75, 315 - i * 15); //Pflanzen Namen
                    addText(r.getPflanzen().get(i).toPDF('p') + " €", 11, 275, 315 - i * 15); //Pflanzen Stuckpreise
                    addText(String.valueOf(r.getAnzahlPflanzen().get(i)), 11, 375, 315 - i * 15); //pflanzen Anzahl
                    addText(r.pflanzenPreisBerechnen(r.getAnzahlPflanzen(), r.getPflanzen()).get(i) + " €", 11, 450, 315 - i * 15); //Gesamtpreis
                }
            }

            if(!r.getSonstiges().equals("") && !r.getSonstiges().equals(" ")) {
                addText(r.getSonstiges(), 11, 75, 210);//Sonstiges
                addText(r.getSonstigesPreis() + " €", 11, 450, 210);
            }
            if(r.getErdeMenge()>0) {
                addText(Rechnung.ERDEPREIS + " €", 11, 275, 190); //Erde
                addText(String.valueOf(r.getErdeMenge()), 11, 375, 190);
            }
            addText(r.getErdeBerPreis() + " €", 11, 450, 190);
            if(r.getArbeitsaufwand()>0) {
                addText(Rechnung.STUNDENLOHN + " €", 11, 275, 175); //Arbeitsaufwand
                addText(r.getArbeitsaufwand() + "h", 11, 375, 175);
            }
            addText(r.getArbeitsPreis() + " €", 11, 450, 175);

            addText(r.getGesamtPreis() + " €", 11, 450, 145);
            addText(r.getMwstPreis() + " €", 11, 450, 130);
            addTextBold(r.getGesamtPreisBrutto() + " €", 11, 450, 105);

            //Konstant
            addTextBold("Rechnung", 24, 75, 700);
            addText("Belegnummer: ", 11, 75, 670);
            PDImageXObject pdImage = PDImageXObject.createFromFile("Logo.png", document);
            pageCS.drawImage(pdImage, 325, 660);
            addText("Betriebsname", 11, 325, 600);
            addText("Betriebsadresse", 11, 325, 585);
            addText("Ort und PLZ", 11, 325, 570);
            addText("Telefon: Telefon-Nummer", 11, 325, 540);
            addText("E-Mail: Email-Adresse", 11, 325, 525);
            addText("Friedhof:", 11, 75, 465);
            addText("Grabname:", 11, 75, 450);
            addText("Grabnummer:", 11, 75, 435);
            addText("Grabfeld:", 11, 75, 420);
            addText("Grabart:", 11, 75, 405);
            addText("KundenNr: ", 11, 75, 390);

            addTextBold("Leistung", 11, 75, 345); 
            addTextBold("Stückpreis", 11, 275, 345);
            addTextBold("Anzahl", 11, 375, 345);
            addTextBold("Preis", 11, 450, 345);
            pageCS.drawLine(75, 335, 535, 335);
            addText("Erde und Dünger", 11, 75, 190);
            addText("Arbeitsaufwand", 11, 75, 175);
            addTextBold("Gesamt (Netto 19%)", 11, 75, 145);
            addTextBold("19% MWSt", 11, 75, 130);
            addTextBold("Endbetrag", 11, 75, 105);
            addText("Zahlbar ab sofort", 11, 75, 25);

            pageCS.close();

            rechnungSpeichern();
        }
        catch(Exception e){
            e.printStackTrace();
            g.showError("PDF konnte nicht erstellt werden.");
        }
    }

    //Konstruktor
    public Pdf(String saison, Rechnung r, GUI g){
        this.r = r;
        this.g = g;
        pathFolder = FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+"/0-Friedhofsoftware-Rechnungen/" + saison;
        path = FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+"/0-Friedhofsoftware-Rechnungen/"+saison+"/"+r.getGrab().getGrabName()+".pdf";
        pdfSchreiben(r);
    }
}
