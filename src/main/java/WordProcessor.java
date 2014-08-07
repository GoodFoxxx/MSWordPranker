import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * User: pberstenyov
 * <p>
 * Date: 07.08.14
 * <p>
 * Time: 10:17
 * <p>
 * To change this template use File | Settings | File Templates.
 */
public interface WordProcessor {
    XWPFDocument parseFile(String fileName);
    boolean saveDocument(XWPFDocument document, String fileName);
    XWPFDocument createDummyDocument();
    @Deprecated
    XWPFDocument doStuff(XWPFDocument document);

    /**
     * Add numeric labels after each picture.
     * @param   document    document to be processed
     * @param   prefix      global num prefix to be added before each pic. number
     */
    XWPFDocument addLabels(XWPFDocument document, String prefix);

    /**
     * Add numeric labels after each picture and find markers in text
     * @param   document    document to be processed
     * @param   prefix      global num prefix to be added before each pic. number
     */
    @Deprecated
    XWPFDocument addLabelsMk2(XWPFDocument document, String prefix);
}
