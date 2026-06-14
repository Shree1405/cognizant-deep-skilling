interface Document{
    void open();
}
class WordDocument implements Document{
     @Override
    public void open() {

        System.out.println("Word Document Opened");
    }

}
class PdfDocument implements Document {
    @Override
    public void open(){
        System.out.println("Pdf Document Opened");

    }
}
 class ExcelDocument implements Document{
     @Override
    public void open() {

        System.out.println(" Excel Document Opened");
    }
 }
 abstract class DocumentFactory{
    public abstract Document createDocument();
 }
 class WordFactory extends DocumentFactory {

    @Override
    public Document createDocument() {

        return new WordDocument();
    }
}
class PdfFactory extends DocumentFactory{
    @Override
    public Document createDocument(){
        return new PdfDocument();
    }
}
class ExcelFactory extends DocumentFactory {

    @Override
    public Document createDocument() {

        return new ExcelDocument();
    }
}
public class FactoryMethodPatternExample {
    public static void main(String[] args){
        DocumentFactory pdfFactory =
                new PdfFactory();

        Document pdf =
                pdfFactory.createDocument();

        pdf.open();

        DocumentFactory wordFactory =
                new WordFactory();

        Document word =
                wordFactory.createDocument();

        word.open();

        DocumentFactory excelFactory =
                new ExcelFactory();

        Document excel =
                excelFactory.createDocument();

        excel.open();
    }
}