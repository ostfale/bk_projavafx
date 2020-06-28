package fxml.controller.builder;

import javafx.util.Builder;

/**
 * JavaFX builder class for {@link Item} object
 * Created :  28.06.2020
 *
 * @author : Uwe Sauerbrei
 */
public class ItemBuilder implements Builder<Item> {

    private Long id;
    private String name;

    @Override
    public Item build() {
        return new Item(id, name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
