import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
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
    @Nullable
    XWPFDocument parseFile(String fileName);
    boolean saveDocument(@NotNull XWPFDocument document, String fileName);
    @NotNull
    XWPFDocument createDummyDocument();
    @Deprecated
    @NotNull
    XWPFDocument doStuff(@NotNull XWPFDocument document);

    /**
     * Add numeric labels after each picture.
     * @param   document    document to be processed
     * @param   prefix      global num prefix to be added before each pic. number
     */
    @NotNull
    XWPFDocument addLabels(@NotNull XWPFDocument document, String prefix);

    /**
     * Add numeric labels after each picture and find markers in text
     * @param   document    document to be processed
     * @param   prefix      global num prefix to be added before each pic. number
     */
    @Deprecated
    XWPFDocument addLabelsMk2(XWPFDocument document, String prefix);
}
