import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.awt.*;
import java.util.*;

/**
 * Created by Lori on 2/2/2017.
 */
public class Application {

    /**
     * This method modifies and returns the given map so that if the keys a and b are present
     * it appends their values together and store it under the key "ab".
     *
     * @param map the provided map.
     * @return the modified map or unmodified if the a and b keys are not both present.
     */
    private Map<String, String> mapAB(Map<String, String> map) {
        String keyA;
        String keyB;

        if (map.get("a") == null || map.get("b") == null) {
            keyA = valueToStringOrEmpty(map, "a");
            keyB = valueToStringOrEmpty(map, "b");
            map.put("ab", keyA + keyB);
        } else
            map.put("ab", map.get("a") + map.get("b"));

        return map;
    }

    /**
     * This method is used to verify the value of the given key.
     * If the value is null, change it to empty.
     * Else convert it to string.
     *
     * @param map the map in which we find the key and value.
     * @param key the key that we will verify the value from.
     * @return the modified value.
     */
    private String valueToStringOrEmpty(Map<String, String> map, String key) {
        String value = map.get(key);
        return value == null ? "" : value;
    }

    public static void main(String[] args) {
        Application application = new Application();
        Map<String, String> map = new HashMap<String, String>();
        map.put("b", "There");
        map.put("a", "Hi");

        Set set = application.mapAB(map).entrySet();
        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
        }
    }
}
