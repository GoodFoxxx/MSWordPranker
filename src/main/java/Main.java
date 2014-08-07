import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


public class Main {

    public static void main(String[] args) throws Exception {
        Log.getInstance().info("beg");
        DOMConfigurator.configure(Log.getPropertyPath());
        WordProcessor word = new WordProcessorInstance();
        word.saveDocument(word.createDummyDocument(), "tmp/created.docx");
        XWPFDocument xwpfDocument = word.parseFile("tmp/prem-in.docx");

        word.doStuff(xwpfDocument);

        word.saveDocument(word.addLabels(xwpfDocument,"7."), "tmp/prem-out.docx");

        Log.getInstance().info("fin");
    }
}
