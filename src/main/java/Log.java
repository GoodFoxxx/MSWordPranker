import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: pberstenyov
 * Date: 07.08.14
 * Time: 9:13
 * To change this template use File | Settings | File Templates.
 */
public class Log {
    private static Logger instance = null;
    private static String propertyPath = System.getProperty("user.dir") + "\\src\\main\\resources\\log4j.xml";

    public static Logger getInstance(){
        if (null == instance) instance = Logger.getLogger("Main");
        return instance;
    }

    public static String getPropertyPath(){
        return propertyPath;
    }

}
