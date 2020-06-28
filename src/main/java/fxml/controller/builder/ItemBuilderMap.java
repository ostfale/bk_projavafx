package fxml.controller.builder;

import javafx.util.Builder;

import java.util.AbstractMap;
import java.util.Set;

/**
 * Builder for Map interface
 * Created :  28.06.2020
 *
 * @author : Uwe Sauerbrei
 */
public class ItemBuilderMap extends AbstractMap<String, Object> implements Builder<Item> {

    private String name;
    private Long id;

    @Override
    public Object put(String key, Object value) {
        if ("name".equals(key)) {
            this.name = (String) value;
        } else if ("id".equals(key)) {
            this.id = Long.valueOf((String) value);
        } else {
            throw new IllegalArgumentException("Unknown Item property: " + key);
        }
        return null;
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Item build() {
        return new Item(id, name);
    }
}
