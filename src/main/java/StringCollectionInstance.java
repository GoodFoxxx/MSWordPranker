import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pberstenyov
 * Date: 07.08.14
 * Time: 18:27
 * To change this template use File | Settings | File Templates.
 */
public class StringCollectionInstance implements StringCollection {

    /**
     * O(n^2)
     * N - total length of collection
     * M - length of mark (M<N)
     * S - size of collection (S<N)
     * n - average length of collection member (eq N/S)
     * m - estimated number of marks in collection (m<N)
     */
    @Override
    public void findAndReplace(List<String> collection, String mark, String newValue) { // O(MNmnS) = O(MNNm)
        if (newValue.contains(mark)) return; //O(M)

        String fullString = glueCollection(collection,""); // O(S)
        int position = fullString.indexOf(mark); // O(NM)

        for (; -1!=position; ){ // O(m)
            int[] border = formBorders(collection,""); // // O(S) left border
            int foundPosIndex = -1;
            int foundEndIndex = -1;
            for (int i=0; i < collection.size(); i++){ // O(N)
                if (-1 == foundPosIndex && border[i]<=position && border[i+1]>position) {
                    foundPosIndex = i;
                }

                if (-1 == foundEndIndex && border[i]<=(position+mark.length()-1) && border[i+1]>(position+mark.length()-1)) {
                    foundEndIndex = i;
                }
                if (-1 != foundPosIndex && -1 != foundEndIndex){
                    break;
                }
            }
            for (int i=foundPosIndex; i <= foundEndIndex; i++){ // O(n)

                String prefix = collection.get(i).substring(0,Math.max(0, position - border[i]));
                String modifiedString = prefix.concat(i==foundPosIndex ? newValue : "");
                int endIndex = Math.min(position+mark.length()-border[i], (border[i+1]-border[i]) );
                String suffix = collection.get(i).substring(endIndex);
                modifiedString = modifiedString.concat(suffix);
                collection.set(i, modifiedString);
            }

            fullString = glueCollection(collection,""); // O(S)
            position = fullString.indexOf(mark); // O(NM)
        }
        Log.getInstance().debug("fullString "+glueCollection(collection,"|"));

    }

    private String glueCollection(List<String> collection, String delimeter){
        String result = "";
        for (int i=0; i < collection.size()-1; i++){
            String part = collection.get(i);
            if (null == part) part = "";
            result = result.concat(part)+delimeter;
        }
        return result;
    }

    private int[] formBorders(List<String> collection, String delimeter){
        int[] border = new int[collection.size()+1];
        if (0 != collection.size()) {
            border[0] = 0;
        }
        for (int i=0; i < collection.size(); i++){
            int partLength = 0;
            String part = collection.get(i);
            if (null != part) {
                partLength = part.length();
            } else {
                partLength = 0;
            }
            partLength+=delimeter.length();
            border[i+1] = border[Math.max(0,i)] + partLength;
        }
        return border;
    }

}
