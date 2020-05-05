package obscollections.map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Example for initialized observable map
 * Created :  05.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class ObservableMapTest {

    public static void main(String[] args) {
        ObservableMap<String, Integer> map1 = FXCollections.observableHashMap();
        map1.put("one", 1);
        map1.put("two", 2);
        System.out.println("Map 1: " + map1);
        Map<String, Integer> backingMap = new HashMap<>();
        backingMap.put("ten", 10);
        backingMap.put("twenty", 20);
        ObservableMap<String, Integer> map2 = FXCollections.observableMap(backingMap);
        System.out.println("Map 2: " + map2);
    }
}
