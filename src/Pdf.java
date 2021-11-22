import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Pdf {

    //Variablen
    private String path;
    private PDDocument document;
    private PDPage page;
    private PDPageContentStream pageCS;

    public static void main(String[] args) {
        //Test
        Pdf p = new Pdf("a", "b");
        p.pdfSchreiben();
    }

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



    //
    public void pdfSchreiben(){
        try{
            document = new PDDocument();
            page = new PDPage();

            document.addPage(page);
            pageCS = new PDPageContentStream(document, page);

            //Variablen
            addText("belegNr", 11, 175, 670);
            addText("kundenName", 11, 75, 600);
            addText("adresse", 11, 75, 585);
            addText("plzOrt", 11, 75, 570);
            addText("friedhof", 11, 325, 465);
            addText("grabname", 11, 325, 450);
            addText("grabNr", 11, 325, 435);
            addText("grabfeld", 11, 325, 420);
            addText("kundenNummer", 11, 325, 405);
            addText("Pflanze", 11, 75, 330);
            addText("Pflanze", 11, 75, 315);
            addText("Pflanze", 11, 75, 300);
            addText("Pflanze", 11, 75, 285);
            addText("Pflanze", 11, 75, 270);
            addText("Pflanze", 11, 75, 255);
            addText("Pflanze", 11, 75, 240);
            addText("Preis", 11, 275, 330);
            addText("Preis", 11, 275, 315);
            addText("Preis", 11, 275, 300);
            addText("Preis", 11, 275, 285);
            addText("Preis", 11, 275, 270);
            addText("Preis", 11, 275, 255);
            addText("Preis", 11, 275, 240);
            addText("Anzahl", 11, 375, 330);
            addText("Anzahl", 11, 375, 315);
            addText("Anzahl", 11, 375, 300);
            addText("Anzahl", 11, 375, 285);
            addText("Anzahl", 11, 375, 270);
            addText("Anzahl", 11, 375, 255);
            addText("Anzahl", 11, 375, 240);
            addText("Preis", 11, 450, 330);
            addText("Preis", 11, 450, 315);
            addText("Preis", 11, 450, 300);
            addText("Preis", 11, 450, 285);
            addText("Preis", 11, 450, 270);
            addText("Preis", 11, 450, 255);
            addText("Preis", 11, 450, 240);
            addText("Preis", 11, 275, 220); //Erde und Arbeitsaufwand
            addText("Preis", 11, 275, 205);
            addText("Anzahl", 11, 375, 220);
            addText("Anzahl", 11, 375, 205);
            addText("Preis", 11, 450, 220);
            addText("Preis", 11, 450, 205);
            addText("Netto", 11, 450, 175);
            addText("Mwst", 11, 450, 160);
            addTextBold("Endpreis", 11, 450, 135);


            //Konstant
            addTextBold("Rechnung", 24, 75, 700);
            addText("Belegnummer: ", 11, 75, 670); //TODO jede Rechnung hat eine Nummer
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
            addText("Kundennummer:", 11, 75, 405); //TODO jeder Kunde hat eine Kundennummer
            addTextBold("Leistung", 11, 75, 360);
            addTextBold("Stückpreis", 11, 275, 360);
            addTextBold("Anzahl", 11, 375, 360);
            addTextBold("Preis", 11, 450, 360);
            pageCS.drawLine(75, 350, 535, 350);
            addText("Erde und Dünger", 11, 75, 220);
            addText("Arbeitsaufwand", 11, 75, 205);
            addTextBold("Gesamt (Netto 19%)", 11, 75, 175);
            addTextBold("19% MWSt", 11, 75, 160);
            addTextBold("Endbetrag", 11, 75, 135);
            addText("Zahlbar ab sofort", 11, 75, 20);

            pageCS.close();
            document.save("Test.pdf"); //TODO path
            document.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }











    //Konstruktor
    public Pdf(String saison, String grabname){
        path = "Friedhof-Rechnungen/"+saison+"/"+grabname+".pdf";
    }
}
