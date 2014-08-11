import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @author pberstenyov
 * Date: 07.08.14
 * Time: 18:26
 * To change this template use File | Settings | File Templates.
 */
public interface StringCollection {
    void findAndReplace(@NotNull List<String> collection, @NotNull String mark, @NotNull String newValue);
}
