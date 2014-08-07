import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pberstenyov
 * Date: 07.08.14
 * Time: 18:26
 * To change this template use File | Settings | File Templates.
 */
public interface WindowCollection<T> {
    void load(List<T> collection);
    void findAndReplace(T mark, T newValue);
}
