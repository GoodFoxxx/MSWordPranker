import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: pberstenyov
 * Date: 07.08.14
 * Time: 8:57
 * To change this template use File | Settings | File Templates.
 */
public class WordProcessorInstance implements WordProcessor {
    private Map<String,String> templates = new HashMap<>();

    public WordProcessorInstance(){
        templates.put("pic-label-short","Рис.");
        templates.put("pic-label-full","Рисунок ");
    }

    @Override
    public XWPFDocument parseFile(String fileName){
        File docFile = new File(fileName);
        if (!docFile.exists()) {
            Log.getInstance().warn("File " + fileName + " does not exist.");
        }
        XWPFDocument xwpfDocument = null;
        try (FileInputStream fileInputStream = new FileInputStream(docFile)){
            xwpfDocument = new XWPFDocument(fileInputStream);
        } catch(IOException e){
            Log.getInstance().warn("Could not parse " + fileName + "");
        }
        return xwpfDocument;
    }

    @Override
    public boolean saveDocument(XWPFDocument document, String fileName){
        boolean success = false;
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName))){
            document.write(fileOutputStream);
            success = true;
        } catch (IOException e){
            Log.getInstance().warn("Could not save document " + fileName + "");
            success = false;
        }
        return success;
    }

    @Override
    public XWPFDocument createDummyDocument(){
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("Lorem ipsum dolor sit amet.");
        document.enforceCommentsProtection();
        return document;
    }

    private XWPFDocument centerAll(XWPFDocument document){
        for(Iterator<XWPFParagraph> paragraphIterator = document.getParagraphsIterator(); paragraphIterator.hasNext();){
            XWPFParagraph paragraph =  paragraphIterator.next();
            paragraph.setAlignment(ParagraphAlignment.CENTER);
//            try{
//                CTJc jc = paragraph.getCTP().getPPr().getJc();
//                if (null == jc){
//                    jc = paragraph.getCTP().getPPr().addNewJc();
//                }
//                jc.setVal(STJc.CENTER);
//                paragraph.getCTP().getPPr().setJc(jc);
//            } catch (NullPointerException e){
//                ;
//            }
        }
        return document;
    }

    @Override
    public XWPFDocument doStuff(XWPFDocument document) {
        ArrayList<String> runTextArray = new ArrayList<>();//important to use ArrayList due to index access
        StringCollection stringCollection = new StringCollectionInstance();
        for(Iterator<XWPFParagraph> paragraphIterator = document.getParagraphsIterator(); paragraphIterator.hasNext();){
            runTextArray.clear();
            XWPFParagraph paragraph =  paragraphIterator.next();
            for (XWPFRun run : paragraph.getRuns()){
                runTextArray.add(run.getText(0));
            }
            stringCollection.findAndReplace(runTextArray,"ABC###","Предмет #1");
            stringCollection.findAndReplace(runTextArray,"ловеч","бураш");

            for (int i=0; i< runTextArray.size(); i++){
                Log.getInstance().trace(runTextArray.get(i));
            }

            for (int i=0; i< paragraph.getRuns().size(); i++){
                paragraph.getRuns().get(i).setText(runTextArray.get(i),0);
            }
        }
        return document;
    }

    private void stuffRun(XWPFRun run){
        Log.getInstance().debug(run.getText(0));
    }

    @Override
    public XWPFDocument addLabels(XWPFDocument document, String prefix) {
        int pictureNum = 1;
        for(Iterator<XWPFParagraph> paragraphIterator = document.getParagraphsIterator(); paragraphIterator.hasNext();){
            XWPFParagraph paragraph =  paragraphIterator.next();
            for (XWPFRun run : paragraph.getRuns()){
                if (!run.getEmbeddedPictures().isEmpty() && (null == run.getText(0))){
                    run.setText(templates.get("pic-label-full")+prefix+pictureNum++);
                    run.setFontSize(9);
                }
            }
        }
        return document;
    }

    @Override
    public XWPFDocument addLabelsMk2(XWPFDocument document, String prefix) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
