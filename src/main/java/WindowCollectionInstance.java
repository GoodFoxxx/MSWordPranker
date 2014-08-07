import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pberstenyov
 * Date: 07.08.14
 * Time: 18:27
 * To change this template use File | Settings | File Templates.
 */
public class WindowCollectionInstance<T> implements WindowCollection<T> {
    private int windowSize = 3;
    private int lastIndex = 0;
    private T window;
    private List<T> collection = new ArrayList<>();

    @Override
    public void load(List<T> collection) {
        this.collection = collection.copy();
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void findAndReplace(T mark, T newValue) {
        //To change body of implemented methods use File | Settings | File Templates.

//                textWindow = "";
//                lastIndex++;
//                for (int i = Math.max(lastIndex-windowSize,0); i<lastIndex; i++){
//                    textWindow = textWindow.concat(runTextArray.get(i).getText(0));
//                }
//
//                if (textWindow.contains("KKL###")){
//                    int begPos = textWindow.indexOf("KKL###");
//                    int endPos = begPos+"KKL###".length();
//                    int[] windowRunMask = new int[textWindow.length()];
//                    int[] windowWatermarkMask = new int[textWindow.length()];
//                    int[] windowMask = new int[textWindow.length()];
//                    int currentRun = Math.max(lastIndex-windowSize,0);
//                    int collectLength = 0;
//                    for (int i=0; i<textWindow.length();i++){
//                        /**
//                         * mask for Watermark position
//                         */
//                        windowWatermarkMask[i] = (begPos<=i && i<=endPos) ? 1 : 0;
//                        /**
//                         * mask for run apply
//                         */
//                        while (collectLength + runTextArray.get(currentRun).getText(0).length() < i){
//                            collectLength += runTextArray.get(currentRun).getText(0).length();
//                            currentRun++;
//                        }
//                        windowRunMask[i] = currentRun;
//                    }
//
//
//
//                }
//                stuffRun(run);

    }
}
